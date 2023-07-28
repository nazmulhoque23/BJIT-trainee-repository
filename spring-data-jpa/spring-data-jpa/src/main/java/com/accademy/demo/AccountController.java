package com.accademy.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController()
@RequestMapping("/account")
public class AccountController {


    @Autowired
    AccountService accountService;

    @GetMapping("/detail")
    public Account detail(@RequestParam long accountId) {
        return accountService.findById(accountId);
    }

    @PostMapping("/new")
    public Account newAccount(@RequestBody Account account) {
         return accountService.saveAccount(account);
    }

    /*  @PutMapping
    String updateAccount(@RequestBody Account account) {
        return accountService.update(account);
    }

  @DeleteMapping("/{id}")
    void deleteEmployee(@PathVariable Long id) {
        accountRepository.delete(id);
    }

    @GetMapping()
    public List allAccount() {
        return accountRepository.getAllAccounts();
    }

    @PostMapping("/save")
    public String saveAccounts(@RequestBody AccountLIst list) {
        return accountRepository.saveBatch(list.getAccounts());
    }*/

}
