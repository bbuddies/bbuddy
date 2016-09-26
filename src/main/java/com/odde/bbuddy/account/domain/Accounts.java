package com.odde.bbuddy.account.domain;

import com.odde.bbuddy.account.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zbcjackson on 9/25/16.
 */
@Service
public class Accounts {
    private AccountRepository accountRepository;

    @Autowired
    public Accounts(AccountRepository accountRepository) {

        this.accountRepository = accountRepository;
    }

    public boolean createAccount(Account account, Runnable success, Runnable failure) {
        if(accountRepository.findByName(account.getName()) != null){
            failure.run();
            return false;
        }
        accountRepository.save(account);
        success.run();
        return true;
    }

    public List<Account> getList() {
        return accountRepository.findAll();
    }

    public boolean isExisting(Account account) {
        return false;
    }


}
