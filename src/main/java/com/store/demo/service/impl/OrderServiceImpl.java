package com.store.demo.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.store.demo.dao.OrderDAO;
import com.store.demo.dao.OrderDetailDAO;
import com.store.demo.entity.Order;
import com.store.demo.entity.OrderDetail;
import com.store.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDAO orderDAO;

    @Autowired
    OrderDetailDAO orderDetailDAO;

    @Override
    public Order store(JsonNode orderData) {
        ObjectMapper mapper = new ObjectMapper();

        Order order = mapper.convertValue(orderData, Order.class);
        orderDAO.save(order);

        TypeReference<List<OrderDetail>> typeReference = new TypeReference<List<OrderDetail>>() {};
        List<OrderDetail> details = mapper.convertValue(orderData.get("orderDetails"), typeReference)
                .stream().peek(d -> d.setOrder(order)).collect(Collectors.toList());
        orderDetailDAO.saveAll(details);

        return order;
    }

    @Override
    public Order findById(Long id) {
        return orderDAO.findById(id).get();
    }

    @Override
    public List<Order> findByUsername(String username) {
        return orderDAO.findByUsername(username);
    }
}
