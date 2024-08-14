package com.store.demo.dao;

import com.store.demo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDAO extends JpaRepository<Role, String> {
}
