package com.odde.bbuddy.account.domain;

import com.odde.bbuddy.account.repo.AccountRepository;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by zbcjackson on 9/25/16.
 */
public class AccountServiceTest {
    @Test
    public void create_account_successfully() throws Exception {
        AccountRepository accountRepository = mock(AccountRepository.class);
        AccountService service = new AccountService(accountRepository);
        Account account = new Account();
        account.setName("Cash");
        account.setBalance(100);
        service.createAccount(account);
        verify(accountRepository).save(account);
    }
}