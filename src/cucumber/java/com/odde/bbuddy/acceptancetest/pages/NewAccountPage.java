package com.odde.bbuddy.acceptancetest.pages;

import com.odde.bbuddy.acceptancetest.driver.UiDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("cucumber-glue")
public class NewAccountPage {
    @Autowired
    public UiDriver driver;

    public void addAccount(String name, int balance) {
        driver.navigateTo("/accounts/new");
        driver.findElementByName("name").sendKeys(name);
        driver.findElementByName("balance").sendKeys(String.valueOf(balance));
        driver.findElementByName("name").submit();
    }

    public String getErrorMessage(){
        return driver.findElementByName("errMessage").getText();
    }
}