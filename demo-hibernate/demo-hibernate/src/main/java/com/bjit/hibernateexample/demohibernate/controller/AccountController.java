package com.bjit.hibernateexample.demohibernate.controller;

import com.bjit.hibernateexample.demohibernate.model.Account;
import com.bjit.hibernateexample.demohibernate.model.TransferMoneyForm;
import com.bjit.hibernateexample.demohibernate.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @GetMapping("/get-all")
    public List<Account> getAllAccount(){
        return accountService.getAllAccount();
    }
    @PostMapping("/new-account")
    public void createAccount(@RequestBody Account account){
        accountService.createAccount(account);
        //ResponseEntity<Object> responseEntity = new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/get-single-account/{id}")
    public Account getAccountById(@PathVariable Long id){
        return accountService.getAccountById(id);
    }

    @GetMapping("/get-account-name/{name}")
    public List<Account> getAccountByName(@PathVariable String name){
        return accountService.getAccountByName(name);
    }
    @PostMapping("/transfer-money")
    public String transferMoney(@RequestBody TransferMoneyForm transferMoneyForm) throws Exception{
        accountService.transferMoney(transferMoneyForm);
        return "Money transfer successful";
    }

}
