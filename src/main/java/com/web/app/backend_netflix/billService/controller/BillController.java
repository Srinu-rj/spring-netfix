package com.web.app.backend_netflix.billService.controller;

import com.web.app.backend_netflix.billService.modual.Bill;
import com.web.app.backend_netflix.billService.request.BillRequest;
import com.web.app.backend_netflix.billService.service.BillService;
import com.web.app.backend_netflix.email.httpResponse.HttpResponse;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/bill")
@RequiredArgsConstructor
@Tag(name = "Bill_Controller")
public class BillController {


    private final BillService billService;


    // POST /api/v1/bills/save
    @PostMapping("/save")
    public ResponseEntity<HttpResponse> saveBill(
            @RequestBody @Valid BillRequest billRequest) {

        BillResponse saved = billService.saveBill(billRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .message("Bill created successfully")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .data(Map.of("bill", saved))
                        .build());
    }

    // GET /api/v1/bills/{id}
    @GetMapping("/{id}")
    public ResponseEntity<HttpResponse> getBillById(
            @PathVariable Long id) {

        BillResponse bill = billService.getBillById(id);
        return ResponseEntity.ok(HttpResponse.builder()
                .timeStamp(LocalDateTime.now().toString())
                .message("Bill fetched successfully")
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .data(Map.of("bill", bill))
                .build());
    }

    // GET /api/v1/bills/all
    @GetMapping("/all")
    public ResponseEntity<HttpResponse> getAllBills() {

        List<BillRequest> bills = billService.getAllBills();
        return ResponseEntity.ok(HttpResponse.builder()
                .timeStamp(LocalDateTime.now().toString())
                .message("All bills fetched. Count: " + bills.size())
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .data(Map.of("bills", bills))
                .build());
    }

    // GET /api/v1/bills/order/{orderId}
    @GetMapping("/order/{orderId}")
    public ResponseEntity<HttpResponse> getBillsByOrder(
            @PathVariable Integer orderId) {

        List<BillRequest> bills = billService.getBillsByOrderId(orderId);
        return ResponseEntity.ok(HttpResponse.builder()
                .timeStamp(LocalDateTime.now().toString())
                .message("Bills for orderId: " + orderId)
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .data(Map.of("bills", bills))
                .build());
    }

    // PUT /api/v1/bills/update/{id}
    @PutMapping("/update/{id}")
    public ResponseEntity<HttpResponse> updateBill(
            @PathVariable Long id,
            @RequestBody @Valid BillRequest billRequest) {

        BillRequest updated = billService.updateBill(id, billRequest);
        return ResponseEntity.ok(HttpResponse.builder()
                .timeStamp(LocalDateTime.now().toString())
                .message("Bill updated successfully")
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .data(Map.of("bill", updated))
                .build());
    }

    // DELETE /api/v1/bills/delete/{id}
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpResponse> deleteBill(
            @PathVariable Long id) {

        billService.deleteBill(id);
        return ResponseEntity.ok(HttpResponse.builder()
                .timeStamp(LocalDateTime.now().toString())
                .message("Bill deleted successfully")
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .data(Map.of("deleted", true))
                .build());
    }
}
