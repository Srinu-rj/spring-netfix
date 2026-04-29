package com.web.app.backend_netflix.categoryService.repository;

import com.web.app.backend_netflix.categoryService.modual.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Integer> {
}
