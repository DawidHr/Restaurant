package com.dawidhr.restaurant.repository;

import com.dawidhr.restaurant.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Long, Food> {
}
