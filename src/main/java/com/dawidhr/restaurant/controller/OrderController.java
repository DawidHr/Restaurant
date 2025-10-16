package com.dawidhr.restaurant.controller;

import com.dawidhr.restaurant.dto.OrderDto;
import com.dawidhr.restaurant.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping
    public void createOrder(@RequestBody OrderDto orderDto) {
        orderService.createOrder(orderDto);
    }
}
