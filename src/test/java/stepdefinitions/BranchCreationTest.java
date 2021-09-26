package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.AdminHomePage;
import org.example.BranchCreationPage;
import org.example.BranchDetailsPage;
import org.example.LoginPage;
import org.junit.Assert;
import io.cucumber.datatable.DataTable;

import java.util.List;
import java.util.Locale;

public class BranchCreationTest {
    private LoginPage loginPage;
    private AdminHomePage adminHomePage;
    private BranchCreationPage branchCreationPage;
    private Scenario scenario;

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }


    @Given("user did login with valid credentials username as {string} and password as {string}")
    public void user_did_login_with_valid_credentials_username_as_and_password_as(String username, String password) {
        loginPage = new LoginPage();
        loginPage.fillUserName(username);
        loginPage.fillPassword(password);
        loginPage.clickLogin();
        adminHomePage = new AdminHomePage();
        Assert.assertTrue(adminHomePage.verifyWelcomeMessage("welcome to admin"));
    }

    @Given("user did login with valid credentials")
    public void user_did_login_with_valid_credentials(DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        List<String> data = dataTable.asList();
        loginPage = new LoginPage();
        loginPage.fillUserName(data.get(0));
        loginPage.fillPassword(data.get(1));
        loginPage.clickLogin();
        adminHomePage = new AdminHomePage();
        Assert.assertTrue(adminHomePage.verifyWelcomeMessage("welcome to admin"));
    }


    @When("user clicks branches button")
    public void user_clicks_branches_button() {
        adminHomePage.clickBranches();
    }
    @When("user clicks new branch button")
    public void user_clicks_new_branch_button() {
        new BranchDetailsPage().clickNewBranch();
        branchCreationPage = new BranchCreationPage();
    }
    @When("user fills branch name as {string}")
    public void user_fills_branch_name_as(String string) {
        branchCreationPage.fillBranchName(string);
    }
    @When("user fills address1 as {string}")
    public void user_fills_address1_as(String string) {
        branchCreationPage.fillAddress1(string);
    }
    @When("user fills zipcode as {string}")
    public void user_fills_zipcode_as(String string) {
       branchCreationPage.fillZipcode(string);
    }
    @When("user selects country as {string}")
    public void user_selects_country_as(String string) {
        branchCreationPage.selectCountry(string);
    }
    @When("user selects state as {string}")
    public void user_selects_state_as(String string) {
        branchCreationPage.selectState(string);
    }
    @When("user selects city as {string}")
    public void user_selects_city_as(String string) {
       branchCreationPage.selectCity(string);
    }
    @When("user clicks on submit button")
    public void user_clicks_on_submit_button() {
        branchCreationPage.clickSubmit();
    }
    @Then("user can see an alert with branch with some id created {string}")
    public void user_can_see_an_alert_with_branch_with_some_id_created_successfully(String msg) {
        String text = branchCreationPage.verifyBranchCreated();
        scenario.log("Alert text "+text);
        Assert.assertTrue(text.toLowerCase().contains(msg.toLowerCase()));
    }
}
