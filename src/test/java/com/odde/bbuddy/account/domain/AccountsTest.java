package com.odde.bbuddy.account.domain;

import com.odde.bbuddy.account.repo.AccountRepository;
import com.odde.bbuddy.data.DataMother;
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
public class AccountsTest {
    AccountRepository accountRepository = mock(AccountRepository.class);
    DataMother dataMother = new DataMother();
    Accounts service = new Accounts(accountRepository);

    @Test
    public void create_account_successfully() throws Exception {
        Account account = dataMother.getAccount();

        service.createAccount(account, null, null);

        verify(accountRepository).save(account);
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