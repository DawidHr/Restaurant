package com.dawidhr.restaurant.controller;

import com.dawidhr.restaurant.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/food")
public class FoodController {
    @Autowired
    FoodService foodService;

    @GetMapping
    public void getList() {
        foodService.getList();
    }
}
