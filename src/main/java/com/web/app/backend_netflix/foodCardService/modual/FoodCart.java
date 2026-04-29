package com.web.app.backend_netflix.foodCardService.modual;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.web.app.backend_netflix.customerService.modual.Customer;
import com.web.app.backend_netflix.itemService.modual.Item;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "foodCart")
public class FoodCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;
    private String cartName;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Customer customer;
    @OneToMany(targetEntity = Item.class, cascade = CascadeType.ALL)
    private List<Item> itemList;
}
