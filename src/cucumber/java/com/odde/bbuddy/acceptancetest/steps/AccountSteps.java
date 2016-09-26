package com.odde.bbuddy.acceptancetest.steps;

import com.odde.bbuddy.acceptancetest.pages.CommonPage;
import com.odde.bbuddy.acceptancetest.pages.NewAccountPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by zbcjackson on 9/25/16.
 */
public class AccountSteps {
    @Autowired
    NewAccountPage newAccountPage;

    @Autowired
    CommonPage accountListPage;

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

}
