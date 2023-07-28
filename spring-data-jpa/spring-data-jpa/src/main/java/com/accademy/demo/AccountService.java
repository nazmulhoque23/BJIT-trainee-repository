package com.accademy.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;


    public Account findById(long id){
        return accountRepository.findByAccountId(id);
    }


    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    public void deleteAccount(Account account) {
         accountRepository.delete(account);
    }


}
