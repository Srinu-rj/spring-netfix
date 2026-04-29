package com.web.app.backend_netflix.categoryService.controller;

import com.web.app.backend_netflix.categoryService.request.CategoryRequest;
import com.web.app.backend_netflix.categoryService.service.CategoryService;
import com.web.app.backend_netflix.email.httpResponse.HttpResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RequestMapping("/api/v1/category")
@RestController
@RequiredArgsConstructor
@Tag(name = "Category")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/save")
    public ResponseEntity<HttpResponse>saveCategory(@RequestBody @Valid CategoryRequest categoryRequest){
        CategoryRequest request=categoryService.save(categoryRequest);

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
    @GetMapping("/get/{categoryId}")
    public ResponseEntity<HttpResponse>getCategory(@PathVariable Long categoryId){
        CategoryRequest getCategoryRequest=categoryService.getCategoryById(categoryId);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .message("Success")
                        .data(Map.of("Created",getCategoryRequest))
                        .build()
        );
    }
    @DeleteMapping("/delete/{categoryId}")
    public ResponseEntity<HttpResponse>deleteCategory(@PathVariable Long categoryId){
        CategoryRequest deleteCategoryRequest=categoryService.deleteCategoryById(categoryId);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .message("Success")
                        .data(Map.of("Created",deleteCategoryRequest))
                        .build()
        );
    }

    @PutMapping("/update/{categoryId}")
    public ResponseEntity<HttpResponse>updateCategory(@PathVariable Long categoryId){
        CategoryRequest updateCategoryRequest=categoryService.updateCategoryById(categoryId);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .message("Success")
                        .data(Map.of("Created",updateCategoryRequest))
                        .build()
        );
    }


}
