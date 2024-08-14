package com.store.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class ShoppingCartController {

    @GetMapping("/view")
    public String list(){
        return "cart/view";
    }


}
