package com.store.demo.dao;

import com.store.demo.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountDAO extends JpaRepository<Account, String> {

    @Query(value = "SELECT DISTINCT a.account FROM Authority a WHERE a.role.id IN ('DIRE', 'STAF')")
    List<Account> getAdminstrators();
}
