package com.store.demo.rest.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.store.demo.entity.Product;
import com.store.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/products")
public class ProductRestController {

    @Autowired
    ProductService productService;

    @GetMapping()
    public List<Product> getAll(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product getOne(@PathVariable Integer id){
        return productService.findById(id);
    }

    @PostMapping
    public Product store(@RequestBody Product data){
        return productService.store(data);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Integer id,
                          @RequestBody Product product){
        return productService.update(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        productService.deleteById(id);
    }
}
