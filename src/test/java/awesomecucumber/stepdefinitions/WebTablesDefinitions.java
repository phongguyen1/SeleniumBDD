package awesomecucumber.stepdefinitions;

import awesomecucumber.context.TestContext;
import awesomecucumber.domainobjects.User;
import awesomecucumber.factory.PageFactoryManager;
import awesomecucumber.pages.RadioBtnPage;
import awesomecucumber.pages.WebTablesPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class WebTablesDefinitions {
    private final TestContext context;
    private final WebTablesPage webTablesPage;
    public WebTablesDefinitions(TestContext context) {
        this.context = context;
        this.webTablesPage = PageFactoryManager.getWebTablesPage(context.driver);
    }
    @Given("Go to Web tables page")
    public void gotoWebTablesPage () {
        this.webTablesPage.load("webtables");
    }

    @Given("I Click Add Button")
    public void clickAddButton() {
        this.webTablesPage.clickAddButton();
    }

    @And("my new user is")
    public void myNewUserIs(DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        for (Map<String, String> columns: rows) {
            this.context.user = new User(
                    columns.get("firstName"),
                    columns.get("lastName"),
                    columns.get("email"),
                    Integer.parseInt(columns.get("age")),
                    Integer.parseInt(columns.get("salary")),
                    columns.get("department"),
                    "abc",
                    "abc");
        }
        System.out.println(this.context.user.getFirstName());
    }

    @And("I fill the form")
    public void iFillTheForm() {
        this.context.user = new User("testFirstName", "testLastName", "test@gmail.com", 35, 123456, "testDepartment", "abc", "abc");
        this.webTablesPage.fillRegisterForm(this.context.user);
    }

    @And("I click submit")
    public void iClickSubmit() {
        this.webTablesPage.submitForm();
    }

    @Then("Tables has new data")
    public void tablesHasNewData() {
        String newDataText = this.webTablesPage.getForthRowText();
        boolean isContainUser = newDataText.contains(this.context.user.getFirstName())
                                && newDataText.contains(this.context.user.getLastName())
                                && newDataText.contains(this.context.user.getAge().toString())
                                && newDataText.contains(this.context.user.getEmail())
                                && newDataText.contains(this.context.user.getSalary().toString())
                                && newDataText.contains(this.context.user.getDepartment());
        Assert.assertTrue(isContainUser);
    }
}
