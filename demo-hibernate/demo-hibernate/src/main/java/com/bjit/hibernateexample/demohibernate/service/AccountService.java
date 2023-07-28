package com.bjit.hibernateexample.demohibernate.service;

import com.bjit.hibernateexample.demohibernate.dao.AccountDao;
import com.bjit.hibernateexample.demohibernate.exception.AccountNotFoundException;
import com.bjit.hibernateexample.demohibernate.exception.InsufficientBalanceException;
import com.bjit.hibernateexample.demohibernate.model.Account;
import com.bjit.hibernateexample.demohibernate.model.TransferMoneyForm;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountDao accountDao;

    public List<Account> getAllAccount(){
        return accountDao.findAll();
    }

    public void createAccount(Account account){
        accountDao.save(account);
    }

    public Account getAccountById(Long id) {
        return accountDao.findById(id);
    }

    public List<Account> getAccountByName(String name) {
        return accountDao.findByFirstName(name);
    }

    public Account decrementBalance(Account account, Long id, Long amount){
        account = accountDao.findById(id);
        if(account.getId() != null){
            Long newAmount = account.getBalance() - amount;
            account.setBalance(newAmount);
        }
        return account;
    }

    public Account addBalance(Account account, Long id, Long amount){
        account = accountDao.findById(id);
        if(account.getId()!=null){
            Long newAmount = account.getBalance() +amount;
            account.setBalance(newAmount);
        }
        return account;
    }
    @Transactional
    public void transferMoney(TransferMoneyForm transferMoneyForm) throws Exception {
        Account senderAccount = accountDao.findById(transferMoneyForm.getSenderId());
        Account receiverAccount = accountDao.findById(transferMoneyForm.getReceiverId());

        Long amount = transferMoneyForm.getAmount();

        if(senderAccount == null || receiverAccount == null){
            throw new AccountNotFoundException("Invalid account");
        }
        if(amount>senderAccount.getBalance()){
            throw new InsufficientBalanceException("Cannot send money");
        }
//        Long newSenderBalance = senderAccount.getBalance()-amount;
//        Long newReceiverBalance = receiverAccount.getBalance()+amount;

//        senderAccount.setBalance(newSenderBalance);
//        receiverAccount.setBalance(newReceiverBalance);

        decrementBalance(senderAccount, senderAccount.getId(), amount);
        addBalance(receiverAccount, receiverAccount.getId(), amount);
    }
}
