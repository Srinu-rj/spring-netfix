package com.web.app.backend_netflix.addressService.controller;

import com.web.app.backend_netflix.addressService.modual.Address;
import com.web.app.backend_netflix.addressService.request.AddressRequest;
import com.web.app.backend_netflix.addressService.service.AddressService;
import com.web.app.backend_netflix.email.httpResponse.HttpResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/address")
@Validated
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @PostMapping("/save")
    public ResponseEntity<HttpResponse> create(@RequestBody @Valid AddressRequest request) {

        AddressRequest response = addressService.createAddress(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Address created successfully")
                        .data(Map.of("address", response))
                        .build()
        );
    }

    @GetMapping("/getAll")
    public ResponseEntity<HttpResponse> getAll() {

        List<AddressRequest> list = addressService.getAllAddresses();
        return ResponseEntity.ok(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .message("Addresses fetched successfully")
                        .data(Map.of("addresses", list))
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<HttpResponse> getById(@PathVariable Long id) {

        AddressRequest address = addressService.getAddressById(id);
        return ResponseEntity.ok(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .message("Address fetched successfully")
                        .data(Map.of("address", address))
                        .build()
        );
    }

    @PatchMapping("/{id}")
    public ResponseEntity<HttpResponse> update(@PathVariable long id,
                                               @RequestBody @Valid AddressRequest request) {

        AddressRequest updated = addressService.updateAddress(id, request);
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

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpResponse> delete(@PathVariable Long id) {

        addressService.deleteAddress(id);
        return ResponseEntity.ok(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .status(HttpStatus.OK) // or NO_CONTENT without body
                        .statusCode(HttpStatus.OK.value())
                        .message("Address deleted successfully")
                        .build()
        );
    }


}
