package com.store.demo.dao;

import com.store.demo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface OrderDAO extends JpaRepository<Order, Long> {

    @Query(value = "SELECT * FROM Orders WHERE username = ?1", nativeQuery = true)
    List<Order> findByUsername(@RequestParam String username);
}
