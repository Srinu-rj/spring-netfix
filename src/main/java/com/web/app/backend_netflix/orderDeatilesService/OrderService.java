package com.web.app.backend_netflix.orderDeatilesService;

import com.web.app.backend_netflix.customerService.request.CustomerRequest;
import com.web.app.backend_netflix.orderDeatilesService.request.OrderDetailsRequest;
import jakarta.validation.Valid;

public interface OrderService {

    OrderDetailsRequest save(@Valid OrderDetailsRequest orderDetailsRequest);
    OrderDetailsRequest getOrderId(Long orderId);
    OrderDetailsRequest deleteOrder(Long orderId);
    CustomerRequest updateCategoryById(Long orderId);

}
