package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

public class AccountActivityPage {
    public AccountActivityPage(){
        PageFactory.initElements(Driver.get(),this);
    }


    @FindBy(css = "#aa_accountId")
    public WebElement accountDropDown;

    @FindBy(css = "#aa_accountId>option")
    public List<WebElement> accountDropDownOptions;

    public boolean isSelected(String accountType){
        Select select = new Select(accountDropDown);
        System.out.println(select.getFirstSelectedOption().getText());
        return select.getFirstSelectedOption().getText().equals(accountType);
    }


}
