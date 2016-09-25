package com.odde.bbuddy.account.controller;

import com.odde.bbuddy.account.domain.Account;
import com.odde.bbuddy.account.domain.AccountService;
import org.apache.xpath.operations.Mod;
import org.junit.Test;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by zbcjackson on 9/25/16.
 */
public class AccountControllerTest {

    @Test
    public void create_account_successfully() throws Exception {
        AccountService accountService = mock(AccountService.class);
        AccountController controller = new AccountController(accountService);
        Account account = new Account();
        account.setName("Cash");
        account.setBalance(100);

        controller.createAccount(account);

        verify(accountService).createAccount(account);
    }

    @Test
    public void display_account_list() {
        Model model = mock(Model.class);
        AccountService accountService = mock(AccountService.class);
        List<Account> accounts = new ArrayList<>();
        Account cashAccount = new Account();
        cashAccount.setName("Cash");
        cashAccount.setBalance(100);
        accounts.add(cashAccount);
        when(accountService.getList()).thenReturn(accounts);
        AccountController controller = new AccountController(accountService);

        controller.list(model);

        verify(model).addAttribute("accounts", accounts);

    }
}