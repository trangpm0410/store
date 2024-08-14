package com.store.demo.controller;

import com.store.demo.entity.Product;
import com.store.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/list")
    public String list(Model model,
                       @RequestParam("cid") Optional<String> cid){
        List<Product> list = new ArrayList<>();
        if(cid.isPresent()){
            list = productService.findProductByCategoryId(cid.get());
        }else {
            list = productService.findAll();
        }
        model.addAttribute("items", list);
        return "product/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Integer id,
                         Model model){
        Product product = productService.findById(id);
        model.addAttribute("item", product);
        return "product/detail";
    }

}
