package com.store.demo.service.impl;

import com.store.demo.dao.RoleDAO;
import com.store.demo.entity.Role;
import com.store.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDAO roleDAO;

    @Override
    public List<Role> findAll() {
        return roleDAO.findAll();
    }
}
