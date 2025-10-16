package com.dawidhr.restaurant.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

    private String foodName;
    private double price;


    public static OrderItem create(Food food) {
        return OrderItem.builder()
                .food(food)
                .foodName(food.getName())
                .price(food.getPrice())
                .build();
    }

}
