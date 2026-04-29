package com.web.app.backend_netflix.foodCardService.request;


import com.web.app.backend_netflix.itemService.request.ItemRequest;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FoodCartRequest {

    private Integer cartId;

    @NotBlank(message = "Cart name should not be empty")
    private String cartName;

    // ✅ Reference instead of full entity
    private Long customerId;

    // ✅ Nested DTO list
    private List<ItemRequest> items;
}
