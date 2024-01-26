package awesomecucumber.stepdefinitions;

import awesomecucumber.context.TestContext;
import awesomecucumber.factory.PageFactoryManager;
import awesomecucumber.pages.CheckboxPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class CheckboxDefinitions {
    private final TestContext context;
    private final CheckboxPage checkboxPage;
    public CheckboxDefinitions(TestContext context) {
        this.context = context;
        this.checkboxPage = PageFactoryManager.getCheckboxPage(context.driver);
    }

    @Given("Go to Check box Page")
    public void goToCheckboxPage() {
        this.checkboxPage.load("checkbox");
    }

    @When("I Click React Checkbox")
    public void clickReactCheckBox() {
        this.checkboxPage.ClickReactCheckbox();
    }

    @And("I Click Expand All Btn")
    public void clickExpandAllBtn() {
        this.checkboxPage.ClickExpandAllBtn();
    }

    @Then("Corresponding input is Checked Or Half-checked")
    public  void checkCheckedHalfChecked() {
        Assert.assertTrue(checkboxPage.ReactCheckboxClicked());
    }
}
