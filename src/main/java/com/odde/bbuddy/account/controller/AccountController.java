package com.odde.bbuddy.account.controller;

import com.odde.bbuddy.account.domain.Account;
import com.odde.bbuddy.account.domain.Accounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
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
    public ModelAndView createAccount(
            @ModelAttribute @Valid Account account,
            BindingResult bindingResult){
        ModelAndView result = new ModelAndView();
        if (bindingResult.hasFieldErrors()) {
            result.setViewName("account/new");
        } else {
            accounts.createAccount(account,
                    () -> result.setViewName("redirect:/accounts"),
                    () -> {
                        result.addObject("errorMessage", "Account exists");
                        result.setViewName("account/new");
                    });
        }

        return result;
    }

    @RequestMapping()
    public String list(Model model){
        model.addAttribute("accounts", accounts.getList());

        return "account/list";
    }
}
