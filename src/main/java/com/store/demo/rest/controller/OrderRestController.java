package com.store.demo.rest.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.store.demo.entity.Order;
import com.store.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/orders")
public class OrderRestController {

    @Autowired
    OrderService orderService;

    @PostMapping
    public Order store(@RequestBody JsonNode orderData){
        return orderService.store(orderData);
    }
}
