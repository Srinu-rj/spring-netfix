package com.web.app.backend_netflix.restaurantService.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RestaurantRequest {

    private int restaurantId;
    private String restaurantName;
    private String managerName;
    private String contactNumber;
    private int addressId;

    private List<Integer> foodCartId;
}
