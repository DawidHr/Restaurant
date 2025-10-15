package com.dawidhr.restaurant.service;

import com.dawidhr.restaurant.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodService {

    @Autowired
    FoodRepository foodRepository;

    public void getList() {
    }
}
