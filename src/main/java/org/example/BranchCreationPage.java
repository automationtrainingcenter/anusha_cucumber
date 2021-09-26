package org.example;

import io.cucumber.java.Scenario;
import io.cucumber.messages.Messages;
import org.openqa.selenium.By;
import utilities.BrowserHelper;

public class BranchCreationPage extends BrowserHelper {

    private By txtBranchName = By.id("txtbName");
    private By txtAdd1 = By.id("txtAdd1");
    private By txtZip = By.id("txtZip");
    private By drpdwnCountry = By.id("lst_counrtyU");
    private By drpdwnState = By.id("lst_stateI");
    private By drpdwnCity = By.id("lst_cityI");
    private By btnSubmit = By.id("btn_insert");
    private By btnReset = By.id("Btn_Reset");
    private By btnCancel = By.id("Btn_cancel");

    public void fillBranchName(String branchName) {
        enterText(txtBranchName, branchName, "Branch Name");
    }

    public void fillAddress1(String address1) {
        enterText(txtAdd1, address1, "Address1");
    }

    public void fillZipcode(String zipcode){
        enterText(txtZip, zipcode, "ZipCode");
    }

    public void selectCountry(String country) {
        selectOption(drpdwnCountry, country, "Country");
    }

    public void selectState(String state) {
        selectOption(drpdwnState, state, "State");
    }

    public void selectCity(String city) {
        selectOption(drpdwnCity, city, "City");
    }

    public void clickSubmit(){
        click(btnSubmit, "Submit");
    }

    public void clickReset(){
        click(btnReset, "Reset");
    }

    public void clickCancel(){
        click(btnCancel, "Cancel");
    }

    public String verifyBranchCreated(){
        return acceptAlert();
    }

}
