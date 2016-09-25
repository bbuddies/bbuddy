package com.odde.bbuddy.account.controller;

import com.odde.bbuddy.account.domain.Account;
import com.odde.bbuddy.account.domain.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by zbcjackson on 9/25/16.
 */
@Controller
@RequestMapping("accounts")
public class AccountController {
    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping("new")
    public String newAccount(){
        return "account/new";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String createAccount(@ModelAttribute Account account){
        accountService.createAccount(account);
        return "account/list";
    }
}
