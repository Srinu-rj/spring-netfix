package com.web.app.backend_netflix.categoryService.service;

import com.web.app.backend_netflix.categoryService.request.CategoryRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {
    CategoryRequest save(@Valid CategoryRequest categoryRequest);

    CategoryRequest getCategoryById(Long categoryId);

    CategoryRequest deleteCategoryById(Long categoryId);

    CategoryRequest updateCategoryById(Long categoryId);
}
