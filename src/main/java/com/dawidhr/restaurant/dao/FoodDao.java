package com.dawidhr.restaurant.dao;

import com.dawidhr.restaurant.model.Food;
import com.dawidhr.restaurant.repository.FoodRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FoodDao {
    @Autowired
    FoodRepository foodRepository;
    @Autowired
    EntityManager entityManager;

    public List<Food> getFoodList() {
        TypedQuery<Food> query = entityManager.createQuery("SELECT u FROM Food u WHERE u.active = :active", Food.class);
        query.setParameter("active", true);
        return query.getResultList().isEmpty() ? new ArrayList<>() : query.getResultList();
    }
}
