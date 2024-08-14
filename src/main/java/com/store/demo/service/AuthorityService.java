package com.store.demo.service;

import com.store.demo.entity.Authority;

import java.util.List;

public interface AuthorityService {

    List<Authority> findAll();

    List<Authority> findAuthoritiesOfAdministrators();

    Authority store(Authority authority);

    void deleteById(Integer id);
}
