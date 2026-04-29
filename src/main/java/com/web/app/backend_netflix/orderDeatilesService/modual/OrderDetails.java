package com.web.app.backend_netflix.orderDeatilesService.modual;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.web.app.backend_netflix.foodCardService.modual.FoodCart;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
@DynamicInsert
@DynamicUpdate
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private LocalDateTime orderDate;
    private String orderStatus;

    
    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private FoodCart cart;

//    @OneToOne(cascade = CascadeType.ALL)
////    @JsonIgnore
//    private Bill bill;
}