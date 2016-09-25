package com.odde.bbuddy.acceptancetest.steps;

import com.odde.bbuddy.acceptancetest.driver.UiDriver;
import com.odde.bbuddy.acceptancetest.pages.SignInPage;
import com.odde.bbuddy.user.domain.User;
import com.odde.bbuddy.user.repo.UserRepo;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import sun.security.util.PendingException;

/**
 * Created by zbcjackson on 9/25/16.
 */
public class AccountSteps {
    @Autowired
    UiDriver driver;

    @When("^add an account with name \"([^\"]*)\" and balance (\\d+)$")
    public void add_an_account_with_name_and_balance(String name, int balance) throws Throwable {
        driver.navigateTo("/accounts/new");
        driver.findElementByName("name").sendKeys(name);
        driver.findElementByName("balance").sendKeys(String.valueOf(balance));
        driver.findElementByName("name").submit();
    }

    @Then("^I have an account with name \"([^\"]*)\" and balance (\\d+)$")
    public void i_have_an_account_with_name_and_balance(String arg1, int arg2) throws Throwable {
    }

}
