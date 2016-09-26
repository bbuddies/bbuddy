package com.odde.bbuddy.account.controller;

import com.odde.bbuddy.account.domain.Account;
import com.odde.bbuddy.account.domain.Accounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by zbcjackson on 9/25/16.
 */
@Controller
@RequestMapping("accounts")
public class AccountController {
    private Accounts accounts;

    @Autowired
    public AccountController(Accounts accounts) {
        this.accounts = accounts;
    }

    @RequestMapping("new")
    public String newAccount(){
        return "account/new";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String createAccount(@ModelAttribute Account account){
        if (account.getName().equals(null) || account.getName().isEmpty()) {
            return "/account/new";
        }

        accounts.createAccount(account);
        return "redirect:/accounts";
    }

    @RequestMapping()
    public String list(Model model){

        model.addAttribute("accounts", accounts.getList());

        return "account/list";
    }
}
