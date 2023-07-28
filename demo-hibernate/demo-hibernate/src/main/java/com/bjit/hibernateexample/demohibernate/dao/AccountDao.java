package com.bjit.hibernateexample.demohibernate.dao;

import com.bjit.hibernateexample.demohibernate.model.Account;

import java.util.List;

public interface AccountDao {
    List<Account> findAll();

    void save(Account account);

    Account findById(Long id);

//    Account updateBalance(Account account, Long id);

    List<Account> findByFirstName(String name);
}
