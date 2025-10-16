package com.dawidhr.restaurant.dto;

import java.util.List;

public class OrderDto {
    private long tableId;
    private List<Long> foodIds;

    public OrderDto(long tableId, List<Long> foodIds) {
        this.tableId = tableId;
        this.foodIds = foodIds;
    }

    public long getTableId() {
        return tableId;
    }

    public void setTableId(long tableId) {
        this.tableId = tableId;
    }

    public List<Long> getFoodIds() {
        return foodIds;
    }

    public void setFoodIds(List<Long> foodIds) {
        this.foodIds = foodIds;
    }

    public static boolean isValid(OrderDto orderDto) {
        if (orderDto == null)
            return false;

        return  orderDto.getFoodIds() != null && !orderDto.getFoodIds().isEmpty();
    }
}
