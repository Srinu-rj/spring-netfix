package com.web.app.backend_netflix.customerService.controller;


import com.web.app.backend_netflix.customerService.request.CustomerRequest;
import com.web.app.backend_netflix.customerService.service.CustomerService;
import com.web.app.backend_netflix.email.httpResponse.HttpResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RequestMapping("/api/v1/customer")
@RestController
@RequiredArgsConstructor
@Tag(name = "customer")
@Validated
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/save")
    public ResponseEntity<HttpResponse> saveCustomer(@RequestBody @Valid CustomerRequest categoryRequest){

        CustomerRequest request=customerService.save(categoryRequest);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Success")
                        .data(Map.of("Created",request))
                        .build()
        );
    }

    @GetMapping("/get/{customerId}")
    public ResponseEntity<HttpResponse>getCustomer(@PathVariable Long customerId){

        CustomerRequest getCustomerId=customerService.getCustomerID(customerId);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .message("Success")
                        .data(Map.of("Created",getCustomerId))
                        .build()
        );
    }
    @DeleteMapping("/delete/{customerId}")
    public ResponseEntity<HttpResponse>deleteCustomer(@PathVariable Long customerId){

        CustomerRequest deleteCustomerID =customerService.deleteCustomerId(customerId);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .message("Success")
                        .data(Map.of("Created", deleteCustomerID))
                        .build()
        );
    }

    @PatchMapping("/update/{customerId}")
    public ResponseEntity<HttpResponse>updateCustomer(@PathVariable Long customerId){

        CustomerRequest updateCustomer=customerService.updateCategoryById(customerId);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .message("Success")
                        .data(Map.of("Created",updateCustomer))
                        .build()
        );
    }

}
