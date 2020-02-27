package com.zerobank.stepdefinitions;

import com.zerobank.pages.BasePage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepsDefs {


    @Given("the user is in the login page")
    public void the_user_is_in_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("the authorized user enter valid credentials {string} and {string}")
    public void the_authorized_user_enter_valid_credentials_and(String username, String password) {
        LoginPage loginPage=new LoginPage();
        loginPage.login(ConfigurationReader.get("username"),ConfigurationReader.get("password"));
    }

    @Then("{string} should be displayed")
    public void should_be_displayed(String Page) {
        int i=0;
        switch(Page){
            case "Account Summary": i=0; break;
            case "Account Activity": i=1; break;
            case "Transfer Funds": i=2; break;
            case "Pay Bills": i=3; break;
            case "My Money Map": i=4; break;
            default: i=5; break;
        }
        Assert.assertEquals(Page, (new BasePage()).NavigationTabs.get(0).getText());
    }

    @When("the users enter wrong credentials")
    public void the_users_enter_wrong_credentials() {
        LoginPage loginPage=new LoginPage();
        loginPage.login(ConfigurationReader.get("wrongusername"),ConfigurationReader.get("wrongpassword"));
    }

    @Then("error message should displayed {string}")
    public void error_message_should_displayed(String errorMessage) {
         errorMessage="Login and/or password are wrong.";
        LoginPage loginPage=new LoginPage();
       String actual =loginPage.Error.getText();
       Assert.assertEquals(actual,errorMessage);
    }

    @When("users logs in with username {string} or password {string}")
    public void users_logs_in_with_username_or_password(String string, String string2) {
        LoginPage loginPage=new LoginPage();
        loginPage.login(ConfigurationReader.get("blankusername"),ConfigurationReader.get("blankpassword"));
    }





}
