package org.example;

import org.openqa.selenium.By;
import utilities.BrowserHelper;

public class AdminHomePage extends BrowserHelper {

    private By btnLogout = By.cssSelector("a[href *= 'qedgetech']");
    private By msgWelcome = By.cssSelector(".headings strong font[size='3']");

    private By lnkBranches = By.cssSelector("img[src *= 'Branches']");
    private By lnkRoles = By.cssSelector("img[src *= 'Roles']");

    public boolean isLogoutDisplayed(){
        return getElement(btnLogout, "Logout button").isDisplayed();
    }

    public boolean verifyWelcomeMessage(String expWelcomeMsg) {
        return getElement(msgWelcome, "Welcome text").getText().toLowerCase().contains(expWelcomeMsg);
    }

    public void clickBranches(){
        click(lnkBranches, "Branches Link");
    }

    public void clickRoles(){
        click(lnkRoles, "Roles Link");
    }

}
