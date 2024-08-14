package com.store.demo.service;

import com.store.demo.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> findAll();

    Product findById(Integer id);

    List<Product> findProductByCategoryId(String cid);

    Product store(Product data);

    Product update(Product product);

    void deleteById(Integer id);
}
