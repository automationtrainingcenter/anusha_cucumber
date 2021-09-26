package stepdefinitions;

import actions.BrowserName;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserHelper;

import java.io.IOException;
import java.util.Locale;

public class LoginStepsWithOutPageObjects {
//    WebDriver driver;
//    @Given("user is in home page")
//    public void user_is_in_home_page() {
//        driver = BrowserHelper.launchBrowser(BrowserName.CHROME, "http://primusbank.qedgetech.com/");
//    }
//
//    @When("user enters valid username")
//    public void user_enters_valid_username() {
//        BrowserHelper.enterText(By.id("txtuId"), "Admin", "username");
//    }
//    @When("user enters valid password")
//    public void user_enters_valid_password() {
//        BrowserHelper.enterText(By.id("txtPword"), "Admin", "password");
//    }
//    @When("user clicks on login button")
//    public void user_clicks_on_login_button() {
//        BrowserHelper.click(By.id("login"), "login button");
//    }
//    @Then("user can see logout link")
//    public void user_can_see_logout_link() {
//        WebElement logout_link = BrowserHelper.getElement(By.cssSelector("a[href *= 'qedgetech123']"), "logout link");
//        Assert.assertTrue(logout_link.isDisplayed());
//    }
//    @Then("user can see welcome to Admin message")
//    public void user_can_see_welcome_to_admin_message() {
//        String welcome_message = BrowserHelper.getElement(By.cssSelector(".headings strong font[size='3']"), "welcome message").getText().toLowerCase(Locale.ROOT);
//        Assert.assertTrue(welcome_message.contains("welcome to admin"));
//    }
//
//    @AfterStep
//    public void addScreenshot(Scenario scenario) throws IOException {
//        if(scenario.isFailed()) {
//            scenario.attach(BrowserHelper.getScreenShotAsFile(scenario.getName()), "image/jpeg", scenario.getName());
//        }
//    }
//
//
//
//    // hooks
//    // before hook will execute before executing first step of first scenario
//    @Before
//    public void launch(){
//
//    }
//    // after hook will execute after executing all the scenarios
//    @After
//    public void tearDown(){
//        driver.close();
//    }
}
