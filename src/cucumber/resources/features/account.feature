@user @wip
Feature: Account

  Scenario: Add account successfully
    When add an account with name "Cash" and balance 100
    Then I have an account with name "Cash" and balance 100
