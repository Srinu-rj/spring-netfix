package com.web.app.backend_netflix.foodCardService.controller;


import com.web.app.backend_netflix.customerService.request.CustomerRequest;
import com.web.app.backend_netflix.email.httpResponse.HttpResponse;
import com.web.app.backend_netflix.foodCardService.request.FoodCartRequest;
import com.web.app.backend_netflix.foodCardService.service.FoodCardService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/foodCard")
@AllArgsConstructor
@Tag(name = "FoodCard")
public class FoodCardController {

    private final FoodCardService foodCardService;


    @PostMapping("/save")
    public ResponseEntity<HttpResponse> saveFoodCard(@RequestBody @Valid FoodCartRequest foodCartRequest){

        FoodCartRequest foodCardRequest=foodCardService.save(foodCartRequest);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Success")
                        .data(Map.of("Created",foodCardRequest))
                        .build()
        );
    }

    @GetMapping("/get/{foodCardId}")
    public ResponseEntity<HttpResponse>getCustomer(@PathVariable Long foodCardId){

        FoodCartRequest getFoodCard=foodCardService.getFoodCard(foodCardId);

        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .message("Success")
                        .data(Map.of("Created",getFoodCard))
                        .build()
        );
    }

    @DeleteMapping("/delete/{foodCardId}")
    public ResponseEntity<HttpResponse>deleteFoodCard(@PathVariable Long foodCardId){

        FoodCartRequest deleteFoodCard =foodCardService.deleteCustomerId(foodCardId);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .message("Success")
                        .data(Map.of("Created", deleteFoodCard))
                        .build()
        );
    }

    @PutMapping("/update/{foodCardId}")
    public ResponseEntity<HttpResponse>updateCustomer(@PathVariable Long foodCardId){

        FoodCartRequest updateFoodCard=foodCardService.updateFoodCardById(foodCardId);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .message("Success")
                        .data(Map.of("Created",updateFoodCard))
                        .build()
        );
    }


}
