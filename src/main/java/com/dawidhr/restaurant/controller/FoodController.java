package com.dawidhr.restaurant.controller;

import com.dawidhr.restaurant.dto.FoodDto;
import com.dawidhr.restaurant.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/food")
public class FoodController {
    @Autowired
    FoodService foodService;

    @GetMapping
    public ResponseEntity<List<FoodDto>> getList() {
        List<FoodDto> response = foodService.getList();
        return ResponseEntity.ok(response);
    }
}
