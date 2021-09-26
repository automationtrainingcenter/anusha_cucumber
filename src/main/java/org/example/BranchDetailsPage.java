package org.example;

import org.openqa.selenium.By;
import utilities.BrowserHelper;

public class BranchDetailsPage extends BrowserHelper {

    private By btnNewBranch = By.id("BtnNewBR");

    public void clickNewBranch(){
        click(btnNewBranch, "New Branch Button");
    }

    public Boolean verifyBranchDetailsPage(){
        return isElementDisplayed(btnNewBranch, "New Branch Button");
    }
}
