package com.web.app.backend_netflix.orderDeatilesService.controller;

import com.web.app.backend_netflix.customerService.request.CustomerRequest;
import com.web.app.backend_netflix.email.httpResponse.HttpResponse;
import com.web.app.backend_netflix.orderDeatilesService.OrderService;
import com.web.app.backend_netflix.orderDeatilesService.request.OrderDetailsRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RequestMapping("/api/v1/order")
@RestController
@RequiredArgsConstructor
@Tag(name = "customer")
@Validated
public class OrderDetailsController {

    private final OrderService orderService;

    @PostMapping("/save")
    public ResponseEntity<HttpResponse> saveOrder(@RequestBody @Valid OrderDetailsRequest orderDetailsRequest){

        OrderDetailsRequest saveOrder=orderService.save(orderDetailsRequest);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Success")
                        .data(Map.of("Created",saveOrder))
                        .build()
        );
    }

    @GetMapping("/get/{orderId}")
    public ResponseEntity<HttpResponse>getOrder(@PathVariable Long orderId){

        OrderDetailsRequest getOrders=orderService.getOrderId(orderId);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .message("Success")
                        .data(Map.of("Created",getOrders))
                        .build()
        );
    }

    @DeleteMapping("/delete/{orderId}")
    public ResponseEntity<HttpResponse>deleteOrder(@PathVariable Long orderId){

        OrderDetailsRequest deleteOrder =orderService.deleteOrder(orderId);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .message("Success")
                        .data(Map.of("Created", deleteOrder))
                        .build()
        );
    }

    @PutMapping("/update/{orderId}")
    public ResponseEntity<HttpResponse>updateOrder(@PathVariable Long orderId){

        CustomerRequest updateOrder=orderService.updateCategoryById(orderId);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .message("Success")
                        .data(Map.of("Created",updateOrder))
                        .build()
        );
    }

}
