package com.web.app.backend_netflix.foodCardService.service;

import com.web.app.backend_netflix.foodCardService.request.FoodCartRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public interface FoodCardService {

    FoodCartRequest save(@Valid FoodCartRequest foodCartRequest);
    FoodCartRequest getFoodCard(Long foodCardId);
    FoodCartRequest deleteCustomerId(Long foodCardId);
    FoodCartRequest updateFoodCardById(Long foodCardId);

}
