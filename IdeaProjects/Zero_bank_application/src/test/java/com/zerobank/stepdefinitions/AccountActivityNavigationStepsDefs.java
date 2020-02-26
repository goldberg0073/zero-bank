package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AccountActivityNavigationStepsDefs {

    AccountActivityPage accountActivityPage=new AccountActivityPage();

    @When("the user clicks on Savings link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page() {
        AccountSummaryPage accountSummaryPage=new AccountSummaryPage();
        accountSummaryPage.savingsLink.click();
    }


    @Then("the Account Activity page should be displayed")
    public void the_Account_Activity_page_should_be_displayed() {

        String ActualTitle=Driver.get().getTitle();
        String ExpectedTitle="Zero - Account Activity";
        System.out.println("ExpectedTitle = " + ExpectedTitle);
        System.out.println("ActualTitle = " + ActualTitle);
        Assert.assertEquals(ExpectedTitle,ActualTitle);
    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String String) {

        BrowserUtils.waitForPageToLoad(3);
        Assert.assertTrue(accountActivityPage.isSelected(String));

    }

    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_account_Summary_page(String accounttype) {

        BrowserUtils.waitForPageToLoad(2);
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        accountSummaryPage.clickLink(accounttype);

    }
}