package com.web.app.backend_netflix.foodCardService.repository;

import com.web.app.backend_netflix.foodCardService.modual.FoodCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodCardRepository extends JpaRepository<FoodCart,Long> {
}
