package com.dawidhr.restaurant.service;


import com.dawidhr.restaurant.dao.OrderDao;
import com.dawidhr.restaurant.dto.OrderDto;
import com.dawidhr.restaurant.model.Food;
import com.dawidhr.restaurant.model.Order;
import com.dawidhr.restaurant.model.OrderItem;
import com.dawidhr.restaurant.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    FoodRepository foodRepository;

    @Autowired
    OrderDao orderDao;

    public void createOrder(OrderDto orderDto) {
            if(!OrderDto.isValid(orderDto))
                return;

        Order order = Order.create(orderDto);
        assignOrderItems(order, orderDto);
        orderDao.save(order);
    }

    private void assignOrderItems(Order order, OrderDto orderDto)  {
        for(Long foodId: orderDto.getFoodIds()) {
            Optional<Food> food = foodRepository.findById(foodId);
            if(!food.isPresent())
                throw new RuntimeException("Food not exists");

            OrderItem orderItem = OrderItem.create(food.get());
            order.addItem(orderItem);
        }

    }
}
