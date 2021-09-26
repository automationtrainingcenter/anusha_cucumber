package stepdefinitions;

import actions.BrowserName;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.AdminHomePage;
import org.example.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserHelper;

import java.io.IOException;
import java.util.Locale;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;
    AdminHomePage adminHomePage;

    // hooks
    // before hook will execute before executing first step of first scenario
    @Before
    public void launch(){
    }
    // after hook will execute after executing all the scenarios
    @After
    public void tearDown(){
        driver.close();
    }


    @Given("user is in home page")
    public void user_is_in_home_page() {
        driver = BrowserHelper.launchBrowser(BrowserName.CHROME, "http://primusbank.qedgetech.com/");
        loginPage = new LoginPage();
    }

    @When("user enters valid username")
    public void user_enters_valid_username() {
        loginPage.fillUserName("Admin");
    }
    @When("user enters valid password")
    public void user_enters_valid_password() {
        loginPage.fillPassword("Admin");
    }
    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        loginPage.clickLogin();
    }
    @Then("user can see logout link")
    public void user_can_see_logout_link() {
        adminHomePage = new AdminHomePage();
        Assert.assertTrue(adminHomePage.isLogoutDisplayed());
    }
    @Then("user can see welcome to Admin message")
    public void user_can_see_welcome_to_admin_message() {
        Assert.assertTrue(adminHomePage.verifyWelcomeMessage("welcome to admin"));
    }

    /*
    AfterStep hook will execute after completion of every step
    BeforeStep hook will execute before starting the execution of every step
     */
    @AfterStep
    public void addScreenshot(Scenario scenario) throws IOException {
        if(scenario.isFailed()) {
            scenario.attach(BrowserHelper.getScreenShotAsFile(scenario.getName()), "image/jpeg", scenario.getName());
        }
    }




}

