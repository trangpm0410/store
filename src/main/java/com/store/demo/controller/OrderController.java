package com.store.demo.controller;

import com.store.demo.entity.Order;
import com.store.demo.service.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/checkout")
    public String checkout(){
        return "order/checkout";
    }

    @GetMapping("/list")
    public String list(Model model,
                       HttpServletRequest request){
        String username = request.getRemoteUser();
        List<Order> list = orderService.findByUsername(username);
        model.addAttribute("orders", list);
        return "order/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id,
                         Model model){
        Order order = orderService.findById(id);
        model.addAttribute("order", order);
        return "order/detail";
    }


}
