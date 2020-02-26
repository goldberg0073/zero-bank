Feature: Pay Bills


  Background:
    Given the user is in the log in page
    When the authorized user enter valid credentials "username" and "password"
    And the user goes from "Account Summary" to "Pay Bills"



    Scenario: Pay Bills page Title
      Then the Pay Bills page title should be "Zero-Pay Bills"


      Scenario: successful Pay operation
        When the user enter correct "amount" and "date"
        Then the message "The payment was successfully submitted" should be displayed


        Scenario: Unsuccessful pay operation
          When the user does not enter the "amount' or "date"
          Then the message "Please fill out this field message!" should be displayed

