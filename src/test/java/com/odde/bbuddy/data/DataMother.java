package com.odde.bbuddy.data;

import com.odde.bbuddy.account.domain.Account;

import java.util.List;

import static java.util.Arrays.asList;

public class DataMother {
    public DataMother() {
    }

    public Account getAccount() {
        Account account = new Account();
        account.setName("Cash");
        account.setBalance(100);
        return account;
    }

    public List<Account> getAccounts() {
        return asList(getAccount());
    }
}