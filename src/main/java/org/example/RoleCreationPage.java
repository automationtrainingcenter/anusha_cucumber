package org.example;

import org.openqa.selenium.By;
import utilities.BrowserHelper;

public class RoleCreationPage extends BrowserHelper {

    private By txtRoleName = By.id("txtRname");
    private By drpdwnRoleType = By.id("lstRtypeN");
    private By btnReset = By.id("Btn_Reset");
    private By btnSubmit = By.id("btninsert");
    private By btnCancel = By.id("Btn_cancel");

    public void fillRoleName(String roleName) {
        enterText(txtRoleName, roleName,"Role Name");
    }

    public void selectRoleType(String roleType) {
        selectOption(drpdwnRoleType, roleType, "Role type");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickReset() {
        click(btnReset, "Reset button");
    }

    public boolean isFormReset() {
       return getAttributeValue(txtRoleName, "value", "Role Name").isEmpty();
    }

    public void clickSubmit(){
        click(btnSubmit, "Submit Button");
    }

    public void clickCancel(){
        click(btnCancel, "Cancel Button");
    }


}
