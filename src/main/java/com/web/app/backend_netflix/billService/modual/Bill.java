package com.web.app.backend_netflix.billService.modual;

import com.web.app.backend_netflix.orderDeatilesService.modual.OrderDetails;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@DynamicInsert
@DynamicUpdate
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long billId;
    @DateTimeFormat
    public LocalDateTime billDate;
    public Double totalCost;
    public int totalItem;

    @OneToOne(cascade ={
            CascadeType.PERSIST,
            CascadeType.MERGE,
    })
    private OrderDetails order;
}