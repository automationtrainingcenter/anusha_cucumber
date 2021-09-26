package org.example;

import org.openqa.selenium.By;
import utilities.BrowserHelper;

public class LoginPage extends BrowserHelper {

    // page object model
    // username
    private By txtUserName = By.id("txtuId");
    // password
    private By txtPassword = By.id("txtPword");
    // login button
    private By btnLogin = By.id("login");

    // fill username
    public void fillUserName(String username) {
        enterText(txtUserName, username, "username");
    }

    // fill password
    public void fillPassword(String password) {
        enterText(txtPassword, password, "password");
    }

    // click login
    public void clickLogin() {
       click(btnLogin, "Login button");
    }

}
