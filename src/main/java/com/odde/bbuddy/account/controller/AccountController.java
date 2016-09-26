package com.odde.bbuddy.account.controller;

import com.odde.bbuddy.account.domain.Account;
import com.odde.bbuddy.account.domain.Accounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zbcjackson on 9/25/16.
 */
@Controller
@RequestMapping("accounts")
public class AccountController {
    private Accounts accounts;

    static List<Account> accountList=new ArrayList<>();


    @Autowired
    public AccountController(Accounts accounts) {
        this.accounts = accounts;
    }

    @RequestMapping("new")
    public String newAccount(){
        return "account/new";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
<<<<<<< Updated upstream
    public String createAccount(@ModelAttribute Account account){
        if (account.getName().equals(null) || account.getName().isEmpty()) {
            return "/account/new";
        }

=======
    public String createAccount(@ModelAttribute Account account, Model model){
        if(accountList.size()>0 && accountList.get(0).getName()==account.getName()){
            model.addAttribute("errMessage", "Cash account exist");
            return "account/new";
        }

        accountList.add(account);

>>>>>>> Stashed changes
        accounts.createAccount(account);
        return "redirect:/accounts";
    }

    @RequestMapping()
    public String list(Model model){

        model.addAttribute("accounts", accounts.getList());

        return "account/list";
    }
}
