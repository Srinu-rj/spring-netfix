package com.web.app.backend_netflix.restaurantService.controller;

import com.web.app.backend_netflix.addressService.request.AddressRequest;
import com.web.app.backend_netflix.email.httpResponse.HttpResponse;
import com.web.app.backend_netflix.restaurantService.request.RestaurantRequest;
import com.web.app.backend_netflix.restaurantService.service.RestaurantService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RequestMapping("/api/v1/restaurant")
@RestController
@RequiredArgsConstructor
@Tag(name = "restaurant")
@Validated
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping("/save")
    public ResponseEntity<HttpResponse> createRestaurant(@RequestBody @Valid RestaurantRequest restaurantRequest) {

        RestaurantRequest request = restaurantService.createRestaurant(restaurantRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Address created successfully")
                        .data(Map.of("address", request))
                        .build()
        );
    }
    @GetMapping("get/{restaurantId}")
    public ResponseEntity<HttpResponse> getById(@PathVariable Long restaurantId) {

        RestaurantRequest restaurantGetReq = restaurantService.getRestaurantById(restaurantId);
        return ResponseEntity.ok(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .message("Address fetched successfully")
                        .data(Map.of("address", restaurantGetReq))
                        .build()
        );
    }

    @DeleteMapping("restaurant/{restaurantId}")
    public ResponseEntity<HttpResponse> deleteRestaurant(@PathVariable Long restaurantId) {

        restaurantService.deleteRestaurant(restaurantId);
        return ResponseEntity.ok(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .status(HttpStatus.OK) // or NO_CONTENT without body
                        .statusCode(HttpStatus.OK.value())
                        .message("Address deleted successfully")
                        .build()
        );
    }

    @PutMapping("restaurant/{restaurantId}")
    public ResponseEntity<HttpResponse> updateRestaurant(@PathVariable Long restaurantId,
                                               @RequestBody @Valid RestaurantRequest updateRequest) {

        RestaurantRequest updated = restaurantService.updateRestaurant(restaurantId, updateRequest);
        return ResponseEntity.ok(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .message("Address updated successfully")
                        .data(Map.of("address", updated))
                        .build()
        );
    }


}
