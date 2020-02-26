package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSummaryPage {

    public AccountSummaryPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[href='/bank/account-activity.html?accountId=1']")
    public WebElement savingsLink;

    @FindBy(xpath = "//a[contains(text(),'Brokerage')]")
    public WebElement BrokerageLink;

    @FindBy(xpath = "//a[contains(text(),'Checking')]")
    public WebElement checkingLink;

    @FindBy(xpath = "//a[contains(text(),'Credit Card')]")
    public WebElement creditCardLink;

    @FindBy(xpath = "//a[contains(text(),'Loan')]")
    public WebElement loanLink;


    public void clickLink(String str) {
        switch (str) {
            case "Brokerage":
                BrokerageLink.click();
                break;
            case "Savings":
                savingsLink.click();
                break;
            case "Checking":
                checkingLink.click();
                break;
            case "Credit Card":
                creditCardLink.click();
                break;
            case "Loan":
                loanLink.click();
                break;
            default:
                throw new RuntimeException("No Such Account Type!");
        }

    }
}