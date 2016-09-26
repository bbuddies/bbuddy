package com.odde.bbuddy.account.controller;

import com.odde.bbuddy.account.domain.Account;
import com.odde.bbuddy.account.domain.Accounts;
import com.odde.bbuddy.data.DataMother;
import org.junit.Test;
import org.springframework.ui.Model;

import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created by zbcjackson on 9/25/16.
 */
public class AccountControllerTest {
    private final DataMother dataMother = new DataMother();
    Accounts accounts = mock(Accounts.class);
        AccountController controller = new AccountController(accounts);

    @Test
    public void create_account_successfully() throws Exception {
        Account account = dataMother.getAccount();

        controller.createAccount(account, mock(Model.class));

        verify(accounts).createAccount(account);
    }

    @Test
    public void create_account_with_blank_name_unsuccessfully() throws Exception {
        Account account = dataMother.getAccountWithBlankName();

        controller.createAccount(account);

        verify(accounts, never()).createAccount(account);
    }

    @Test
    public void display_account_list() {
        Model model = mock(Model.class);
        List<Account> accounts = dataMother.getAccounts();
        when(this.accounts.getList()).thenReturn(accounts);

        controller.list(model);

        verify(model).addAttribute("accounts", accounts);

    }

}