package com.web.app.backend_netflix.billService.service;

import com.web.app.backend_netflix.billService.modual.Bill;
import com.web.app.backend_netflix.billService.request.BillRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BillService {

    BillRequest saveBill(BillRequest billRequest);

    BillRequest getBillById(Long billId);

    List<BillRequest> getAllBills();

    List<BillRequest> getBillsByOrderId(Integer orderId);

    BillRequest updateBill(Long billId, BillRequest billRequest);

    void deleteBill(Long billId);
}
