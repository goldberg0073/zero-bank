package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }


     @FindBy(id="user_login")
    public WebElement username;

    @FindBy(id="user_password")
    public WebElement password;

    @FindBy(name="submit")
    public WebElement SignIn;

    public void login(String userNameStr,String PasswordStr){
        username.sendKeys(userNameStr);
        password.sendKeys(PasswordStr);
        SignIn.click();
    }

}
