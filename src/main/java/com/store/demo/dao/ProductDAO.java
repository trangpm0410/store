package com.store.demo.dao;

import com.store.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface ProductDAO extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT * FROM Products WHERE CategoryId = ?1", nativeQuery = true)
    List<Product> findByCategoryId(@RequestParam("CategoryId") String id);
}
