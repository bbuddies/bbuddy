package com.odde.bbuddy.account.controller;

import com.odde.bbuddy.account.domain.Account;
import com.odde.bbuddy.account.domain.Accounts;
import com.odde.bbuddy.data.DataMother;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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

        controller.createAccount(account);

        verify(accounts).createAccount(eq(account), any(Runnable.class), any(Runnable.class));
    }

    @Test
    public void create_account_with_blank_name_unsuccessfully() throws Exception {
        Account account = dataMother.getAccountWithBlankName();

        controller.createAccount(account);

        verify(accounts, never()).createAccount(account, null, null);
    }

    @Test
    public void display_account_list() {
        Model model = mock(Model.class);
        List<Account> accounts = dataMother.getAccounts();
        when(this.accounts.getList()).thenReturn(accounts);

        controller.list(model);

        verify(model).addAttribute("accounts", accounts);
    }

    @Test
    public void duplicated_account_name() throws Exception {
        doAnswer(invocation -> {
            invocation.getArgumentAt(2, Runnable.class).run();
            return null;
        }).when(accounts).createAccount(eq(dataMother.getAccount()), any(Runnable.class), any(Runnable.class));

        ModelAndView result = controller.createAccount(dataMother.getAccount());

        assertThat(result.getModel()).containsEntry("errorMessage", "Account exists");
    }
}