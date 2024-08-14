package com.store.demo.service;

import com.store.demo.entity.Account;

import java.util.List;

public interface AccountService{

    Account findById(String username);

    List<Account> findAll();

    List<Account> getAdminstrators();
}
