package com.accademy.demo;

import java.util.List;

public class AccountLIst {

    List <Account> accounts;

    public AccountLIst() {

    }

    public AccountLIst(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
