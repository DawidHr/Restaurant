package com.dawidhr.restaurant.dto;

import java.util.List;

public class OrderDto {
    private long tableId;
    private List<Integer> foodIds;

    public OrderDto(long tableId, List<Integer> foodIds) {
        this.tableId = tableId;
        this.foodIds = foodIds;
    }

    public long getTableId() {
        return tableId;
    }

    public void setTableId(long tableId) {
        this.tableId = tableId;
    }

    public List<Integer> getFoodIds() {
        return foodIds;
    }

    public void setFoodIds(List<Integer> foodIds) {
        this.foodIds = foodIds;
    }

    public static boolean isValid(OrderDto orderDto) {
        if (orderDto == null)
            return false;

        return  orderDto.getFoodIds() != null && !orderDto.getFoodIds().isEmpty();
    }
}
