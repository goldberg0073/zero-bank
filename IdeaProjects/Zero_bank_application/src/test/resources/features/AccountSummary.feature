Feature:Account summary page


  Background:
    Given the user is in the login page
      When the authorized user enter valid credentials "username" and "password"

  Scenario: Account summery page title
    Then the Account Summary title should be "Zero-account Summary"


    Scenario: Account types

      Then users should see following options
      |Cash Accounts|Investment Account|Credit Accounts|Loan Accounts|


     Scenario: Credit Accounts table

       Then The Credit Account Table should have
       |Account|Credit Card|balance|

