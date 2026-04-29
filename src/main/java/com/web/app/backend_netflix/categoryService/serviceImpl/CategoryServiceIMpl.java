package com.web.app.backend_netflix.categoryService.serviceImpl;

import com.web.app.backend_netflix.categoryService.modual.Category;
import com.web.app.backend_netflix.categoryService.request.CategoryRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceIMpl {


    private Category mapToEntity(CategoryRequest dto) {
        Category category = new Category();
        category.setCategoryName(dto.getCategoryName());
        return category;
    }

    private CategoryRequest mapToDto(Category category) {
        return CategoryRequest.builder()
                .categoryId(category.getCategoryId())
                .categoryName(category.getCategoryName())
                .build();
    }
}
