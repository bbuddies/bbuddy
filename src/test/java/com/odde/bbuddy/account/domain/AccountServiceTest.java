package com.odde.bbuddy.account.domain;

import com.odde.bbuddy.account.repo.AccountRepository;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

    @Test
    public void get_account_list() throws Exception {
        AccountRepository accountRepository = mock(AccountRepository.class);
        List<Account> accounts = new ArrayList<>();
        Account cashAccount = new Account();
        cashAccount.setName("Cash");
        cashAccount.setBalance(100);
        accounts.add(cashAccount);
        when(accountRepository.findAll()).thenReturn(accounts);
        AccountService service = new AccountService(accountRepository);
        assertThat(service.getList()).isEqualTo(accounts);
    }
}