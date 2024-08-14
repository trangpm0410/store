package com.store.demo.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.store.demo.entity.Order;

import java.util.List;

public interface OrderService {

    Order store(JsonNode orderData);

    Order findById(Long id);

    List<Order> findByUsername(String username);
}
