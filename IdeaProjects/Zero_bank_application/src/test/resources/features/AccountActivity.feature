Feature: Account Activity
  Background:
    Given the user is in the login page
    When the authorized user enter valid credentials "username" and "password"





  Scenario: Account Activity title
    And the user goes from "Account Summary" to "Account Activity"
    Then the Account Activity title should be "Zero-Account Activity"


  Scenario: Account drop down
    And the user goes from "Account Summary" to "Account Activity"
    And the user goes to "Saving" drop down default option
    Then Account drop down should have the fallowing options
      | Saving      |
      | Checking    |
      | Loan        |
      | Credit Card |
      | Brokerage   |


    Scenario: Transactions table
      Then Transactions table should have column names
      |Date|
      |Description|
      |Deposit|
      |Withdrawal|