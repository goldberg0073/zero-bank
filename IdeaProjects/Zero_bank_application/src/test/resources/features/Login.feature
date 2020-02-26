@smoke_test
Feature:Login functionality
    @login
    Scenario: Authorized users
     Given the user is in the login page
      When the authorized user enter valid credentials "username" and "password"
      Then "Account Summary" should be displayed


    Scenario: unauthorized users
      Given the user is in the login page
      When the users enter wrong credentials
      Then error message should displayed "Login and/or password are wrong"

     Scenario: trying to login with blank username or password
      Given the user is in the login page
       When users logs in with username "" or password ""
       Then error message should displayed "Login and/or password are wrong"




