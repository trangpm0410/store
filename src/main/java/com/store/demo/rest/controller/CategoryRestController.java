package com.store.demo.rest.controller;

import com.store.demo.entity.Category;
import com.store.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/categories")
public class CategoryRestController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public List<Category> getAll(){
        return categoryService.findAll();
    }
}
