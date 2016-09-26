@user
Feature: Account
  Scenario: Add account successfully
    When add an account with name "Cash" and balance 100
    Then I have an account with name "Cash" and balance 100

  @wip
  Scenario: Add account with blank name unsuccessfully
    When add an account
      | name    | balance             |
      |         | 100                 |
    Then there is an error message for null name
