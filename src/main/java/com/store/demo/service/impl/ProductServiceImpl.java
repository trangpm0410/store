package com.store.demo.service.impl;

import com.store.demo.dao.ProductDAO;
import com.store.demo.entity.Product;
import com.store.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDAO productDAO;

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productDAO.findById(id).get();
    }

    @Override
    public List<Product> findProductByCategoryId(String cid) {
        return productDAO.findByCategoryId(cid);
    }

    @Override
    public Product store(Product data) {
        return productDAO.save(data);
    }

    @Override
    public Product update(Product product) {
        return productDAO.save(product);
    }

    @Override
    public void deleteById(Integer id) {
        productDAO.deleteById(id);
    }
}
