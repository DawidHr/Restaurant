package com.dawidhr.restaurant.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class OrderDto {
    private long tableId;
    private List<Long> foodIds;

    public static boolean isValid(OrderDto orderDto) {
        if (orderDto == null)
            return false;

        return  orderDto.getFoodIds() != null && !orderDto.getFoodIds().isEmpty();
    }
}
