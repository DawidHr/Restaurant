package com.dawidhr.restaurant.service;

import com.dawidhr.restaurant.dao.FoodDao;
import com.dawidhr.restaurant.dto.FoodDto;
import com.dawidhr.restaurant.model.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    FoodDao foodDao;

    public List<FoodDto> getList() {
        List<Food> food = foodDao.getFoodList();
        List<FoodDto> results = food.stream().map(FoodDto::create).toList();
        return results;
    }
}
