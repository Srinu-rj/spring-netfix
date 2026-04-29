package com.web.app.backend_netflix.orderDeatilesService.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDetailsRequest {

    private Long orderId;
    private LocalDateTime orderDate;
    private String orderStatus;

    private int foodCard;
}
