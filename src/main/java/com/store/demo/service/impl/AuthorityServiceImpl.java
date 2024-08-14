package com.store.demo.service.impl;

import com.store.demo.dao.AccountDAO;
import com.store.demo.dao.AuthorityDAO;
import com.store.demo.entity.Account;
import com.store.demo.entity.Authority;
import com.store.demo.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    AuthorityDAO authorityDAO;

    @Autowired
    AccountDAO accountDAO;

    @Override
    public List<Authority> findAll() {
        return authorityDAO.findAll();
    }

    @Override
    public List<Authority> findAuthoritiesOfAdministrators() {
        List<Account> accounts = accountDAO.getAdminstrators();
        return authorityDAO.authoritiesOf(accounts);
    }

    @Override
    public Authority store(Authority authority) {
        return authorityDAO.save(authority);
    }

    @Override
    public void deleteById(Integer id) {
        authorityDAO.deleteById(id);
    }

}
