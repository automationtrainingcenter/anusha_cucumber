package org.example;

import org.openqa.selenium.By;
import utilities.BrowserHelper;

public class RoleDetailsPage extends BrowserHelper {

    private By btnNewRole = By.id("btnRoles");

    public void clickNewRole(){
        click(btnNewRole, "New Role Button");
    }

    public Boolean verifyRoleDetailsPage(){
        return isElementDisplayed(btnNewRole, "New Branch Button");
    }
}
