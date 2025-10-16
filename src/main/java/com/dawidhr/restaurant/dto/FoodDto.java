package com.dawidhr.restaurant.dto;

import com.dawidhr.restaurant.model.Food;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class FoodDto {
    private long id;
    private String name;
    private String description;
    private String imgPath;
    private Double price;

    public static FoodDto create(Food food) {
        return FoodDto.builder()
                .id(food.getId())
                .name(food.getName())
                .description(food.getDescription())
                .price(food.getPrice())
                .imgPath(food.getImgPath())
                .build();
    }
}
