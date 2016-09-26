@user
Feature: Account

  Scenario: Add account successfully
    When add an account with name "Cash" and balance 100
    Then I have an account with name "Cash" and balance 100

  @wip
  Scenario: Add account with blank name unsuccessfully
    When add an account with name "" and balance 100
    Then there is an error message for null name

  Scenario: account name not duplicate
    Given exists account with name "Cash" and balance 200
    When add an account with name "Cash" and balance 100
    Then we should see a tip with "Cash account exist"
    And "Cash" account only one and its balance 200
