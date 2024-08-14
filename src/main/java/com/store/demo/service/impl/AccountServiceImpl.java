package com.store.demo.service.impl;

import com.store.demo.dao.AccountDAO;
import com.store.demo.entity.Account;
import com.store.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDAO accountDAO;

    @Override
    public Account findById(String username) {
        return accountDAO.findById(username).get();
    }

    @Override
    public List<Account> findAll() {
        return accountDAO.findAll();
    }

    @Override
    public List<Account> getAdminstrators() {
        return accountDAO.getAdminstrators();
    }
}
