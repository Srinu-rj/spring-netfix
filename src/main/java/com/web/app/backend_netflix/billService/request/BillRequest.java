package com.web.app.backend_netflix.billService.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BillRequest {

    private Long billId;
    private LocalDateTime billDate;
    private Double totalCost;
    private int totalItem;

    // Expose only orderId — never expose full entity in response
    private Integer orderId;

}
