package com.odde.bbuddy.account.domain;

import com.odde.bbuddy.account.repo.AccountRepository;
import com.odde.bbuddy.data.DataMother;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * Created by zbcjackson on 9/25/16.
 */
public class AccountsTest {
    AccountRepository accountRepository = mock(AccountRepository.class);
    DataMother dataMother = new DataMother();
    Accounts service = new Accounts(accountRepository);

    @Test
    public void create_account_successfully() throws Exception {
        Runnable success = mock(Runnable.class);
        Account account = dataMother.getAccount();

        service.createAccount(account, success, null);

        verify(accountRepository).save(account);
        verify(success).run();
    }

    @Test
    public void name_duplicated_account_is_not_allowed() throws Exception {
        Runnable failure = mock(Runnable.class);
        Account account = dataMother.getAccount();
        when(accountRepository.findByName(account.getName())).thenReturn(account);

        service.createAccount(account, null, failure);

        verify(accountRepository, never()).save(account);
        verify(failure).run();
    }

    @Test
    public void get_account_list() throws Exception {
        List<Account> accounts = dataMother.getAccounts();
        thereIsAccounts(accounts);

        assertThat(service.getList()).isEqualTo(accounts);
    }


    private void thereIsAccounts(List<Account> accounts) {
        when(accountRepository.findAll()).thenReturn(accounts);
    }
}