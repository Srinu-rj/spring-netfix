package com.web.app.backend_netflix.restaurantService.service;

import com.web.app.backend_netflix.restaurantService.request.RestaurantRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public interface RestaurantService{

    RestaurantRequest createRestaurant(@Valid RestaurantRequest restaurantRequest);
    RestaurantRequest getRestaurantById(Long restaurantId);
    void deleteRestaurant(Long restaurantId);
    RestaurantRequest updateRestaurant(Long restaurantId, @Valid RestaurantRequest updateRequest);

}
