package com.odde.bbuddy.account.controller;

import com.odde.bbuddy.account.domain.Account;
import com.odde.bbuddy.account.domain.AccountService;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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
}