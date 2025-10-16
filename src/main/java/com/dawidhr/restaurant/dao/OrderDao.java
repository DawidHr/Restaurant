package com.dawidhr.restaurant.dao;

import com.dawidhr.restaurant.repository.OrderRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderDao {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    EntityManager entityManager;

}
