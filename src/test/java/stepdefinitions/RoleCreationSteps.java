package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.example.AdminHomePage;
import org.example.RoleCreationPage;
import org.example.RoleDetailsPage;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class RoleCreationSteps {

    @Given("user clicks roles button")
    public void user_clicks_roles_button() {
        AdminHomePage adminHomePage = new AdminHomePage();
        adminHomePage.clickRoles();
    }

    @Given("user clicks new role button")
    public void user_clicks_new_role_button() {
        new RoleDetailsPage().clickNewRole();
    }
    @When("user clicks reset button by filling role name and role type")
    public void user_clicks_reset_button_by_filling_role_name_and_role_type(DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        RoleCreationPage roleCreationPage = new RoleCreationPage();
        List<Map<String, String>> rows = dataTable.asMaps();
        for(Map<String, String> row : rows) {
            roleCreationPage.fillRoleName(row.get("roleName"));
            roleCreationPage.selectRoleType(row.get("roleType"));
            roleCreationPage.clickReset();
            Assert.assertTrue(roleCreationPage.isFormReset());
        }
    }

    @When("user clicks submit button by filling role name and role type")
    public void user_clicks_submit_button_by_filling_role_name_and_role_type(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        RoleCreationPage roleCreationPage = new RoleCreationPage();
        roleCreationPage.fillRoleName(data.get("roleName"));
        roleCreationPage.selectRoleType(data.get("roleType"));
        roleCreationPage.clickSubmit();
    }

    @When("user clicks cancel button by filling role name and role type")
    public void user_clicks_cancel_button_by_filling_role_name_and_role_type(io.cucumber.datatable.DataTable dataTable) {
        RoleCreationPage roleCreationPage = new RoleCreationPage();
        List<List<String>> rows = dataTable.asLists();
        for(List<String> row : rows) {
            roleCreationPage.fillRoleName(row.get(0));
            roleCreationPage.selectRoleType(row.get(1));
            roleCreationPage.clickCancel();
        }
    }

}
