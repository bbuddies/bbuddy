package com.odde.bbuddy.account.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zbcjackson on 9/25/16.
 */
@Controller
@RequestMapping("accounts")
public class AccountController {
    @RequestMapping("new")
    public String newAccount(){
        return "account/new";
    }
}
