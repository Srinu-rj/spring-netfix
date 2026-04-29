package com.web.app.backend_netflix.categoryService.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryRequest {

    private Integer categoryId;

    @NotBlank(message = "Category name should not be empty")
    private String categoryName;
}