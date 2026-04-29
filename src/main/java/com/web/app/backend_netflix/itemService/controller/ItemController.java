package com.web.app.backend_netflix.itemService.controller;

import com.web.app.backend_netflix.customerService.request.CustomerRequest;
import com.web.app.backend_netflix.email.httpResponse.HttpResponse;
import com.web.app.backend_netflix.itemService.request.ItemRequest;
import com.web.app.backend_netflix.itemService.service.ItemService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RequestMapping("/api/v1/item")
@RestController
@RequiredArgsConstructor
@Tag(name = "customer")
@Validated
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/save")
    public ResponseEntity<HttpResponse> saveItem(@RequestBody @Valid ItemRequest itemRequest){

        ItemRequest itemReq=itemService.save(itemRequest);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Success")
                        .data(Map.of("Created",itemReq))
                        .build()
        );
    }

    @GetMapping("/get/{itemId}")
    public ResponseEntity<HttpResponse>getItem(@PathVariable Long itemId){

        ItemRequest getItems=itemService.getItemId(itemId);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .message("Success")
                        .data(Map.of("Created",getItems))
                        .build()
        );
    }

    @DeleteMapping("/delete/{itemId}")
    public ResponseEntity<HttpResponse>deleteItem(@PathVariable Long itemId){

        ItemRequest deleteItemById =itemService.deleteItem(itemId);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .message("Success")
                        .data(Map.of("Created", deleteItemById))
                        .build()
        );
    }
    @PutMapping("/update/{itemId}")
    public ResponseEntity<HttpResponse>updateItem(@PathVariable Long itemId){

        ItemRequest updateItem=itemService.updateItemById(itemId);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .message("Success")
                        .data(Map.of("Created",updateItem))
                        .build()
        );
    }



}
