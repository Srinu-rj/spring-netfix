package com.web.app.backend_netflix.billService.serviceImpl;

import com.web.app.backend_netflix.billService.modual.Bill;
import com.web.app.backend_netflix.billService.repository.BillRepo;
import com.web.app.backend_netflix.billService.request.BillRequest;
import com.web.app.backend_netflix.billService.service.BillService;
import com.web.app.backend_netflix.security.exception.BusinessException;
import com.web.app.backend_netflix.security.exception.ErrorCode;
import com.web.app.backend_netflix.orderDeatilesService.modual.OrderDetails;
import com.web.app.backend_netflix.orderDeatilesService.repository.OrderDetailRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Slf4j
public class BillServiceImpl implements BillService {

    private final BillRepo billRepo;
    private final OrderDetailRepo orderDetailRepo;
    private final ErrorCode errorCode;

    @Override
    @Transactional
    public BillRequest saveBill(BillRequest request) {
        log.info("Saving bill for orderId: {}", request.getOrderId());

        OrderDetails order = orderDetailRepo.findById(
                        request.getOrderId().longValue())
                .orElseThrow(() -> new BusinessException(ErrorCode.BAD_CREDENTIALS,request));

        // Prevent duplicate bill for same order
        if (billRepo.existsByOrder_OrderId(request.getOrderId())) {
            throw new BusinessException(ErrorCode.BILL_NOT_FOUND);
        }

        Bill bill = mapToBill(request, order);
        Bill saved = billRepo.save(bill);
        return mapToResponse(saved);
    }

    @Override
    public BillRequest getBillById(Long billId) {
        Bill bill = findBillOrThrow(billId);
        return mapToResponse(bill);
    }

    @Override
    public List<BillRequest> getAllBills() {
        return billRepo.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<BillRequest> getBillsByOrderId(Integer orderId) {
        return billRepo.findByOrder_OrderId(orderId)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public BillRequest updateBill(Long billId, BillRequest request) {
        log.info("Updating bill id: {}", billId);

        Bill existing = findBillOrThrow(billId);

        OrderDetails order = orderDetailRepo.findById(
                        request.getOrderId().longValue())
                .orElseThrow(() -> new BusinessException(ErrorCode.BILL_NOT_FOUND));

        existing.setBillDate(request.getBillDate());
        existing.setTotalCost(request.getTotalCost());
        existing.setTotalItem(request.getTotalItem());
        existing.setOrder(order);

        return mapToResponse(billRepo.save(existing));
    }

    @Override
    @Transactional
    public void deleteBill(Long billId) {
        log.info("Deleting bill id: {}", billId);
        Bill bill = findBillOrThrow(billId);
        billRepo.delete(bill);
    }

    private Bill findBillOrThrow(Long billId) {
        return billRepo.findById(billId)
                .orElseThrow(() -> new BusinessException(ErrorCode.BILL_NOT_FOUND,billId));
    }

    private Bill mapToBill(BillRequest req, OrderDetails order) {
        Bill bill = new Bill();
        bill.setBillDate(req.getBillDate());
        bill.setTotalCost(req.getTotalCost());
        bill.setTotalItem(req.getTotalItem());
        bill.setOrder(order);
        return bill;
    }

    private BillRequest mapToResponse(Bill bill) {
        return BillRequest.builder()
                .billId(bill.getBillId())
                .billDate(bill.getBillDate())
                .totalCost(bill.getTotalCost())
                .totalItem(bill.getTotalItem())
                .orderId(Math.toIntExact(bill.getOrder().getOrderId()))
                .build();
    }
}
















