package com.odde.bbuddy.acceptancetest.steps;

import com.odde.bbuddy.acceptancetest.pages.CommonPage;
import com.odde.bbuddy.acceptancetest.pages.NewAccountPage;
import com.odde.bbuddy.account.domain.Account;
import com.odde.bbuddy.account.repo.AccountRepository;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by zbcjackson on 9/25/16.
 */
public class AccountSteps {
    @Autowired
    NewAccountPage newAccountPage;

    @Autowired
    CommonPage accountListPage;

    @Autowired
    AccountRepository accountRepository;


    @When("^add an account with name \"([^\"]*)\" and balance (\\d+)$")
    public void add_an_account_with_name_and_balance(String name, int balance) throws Throwable {

        newAccountPage.addAccount(name, balance);
    }

    @Then("^I have an account with name \"([^\"]*)\" and balance (\\d+)$")
    public void i_have_an_account_with_name_and_balance(String name, int balance) throws Throwable {
        assertThat(accountListPage.getAllText())
                .contains(name)
                .contains(String.valueOf(balance));
    }

    @Given("^exists account with name \"([^\"]*)\" and balance (\\d+)$")
    public void exists_account_with_name_and_balance(String name, int balance) throws Throwable {
        Account account = new Account();
        account.setName(name);
        account.setBalance(balance);
        accountRepository.save(account);
    }

    @Then("^we should see a tip with \"([^\"]*)\"$")
    public void we_should_see_a_tip_with(String message) throws Throwable {
        assertThat(accountListPage.getAllText()).contains(message);
    }

    @Then("^\"([^\"]*)\" account only one and its balance (\\d+)$")
    public void account_only_one_and_its_balance(String name, int balance) throws Throwable {
        Account account = accountRepository.findByName(name);
        assertThat(account.getBalance()).isEqualTo(balance);
    }
}
