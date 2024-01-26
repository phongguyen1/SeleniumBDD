package awesomecucumber.stepdefinitions;

import awesomecucumber.context.TestContext;
import awesomecucumber.factory.PageFactoryManager;
import awesomecucumber.pages.AccordianPage;
import awesomecucumber.pages.DatePickerPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class DatePickerDefinitions {
    private final TestContext context;
    private final DatePickerPage datePickerPage;
    public DatePickerDefinitions(TestContext context) {
        this.context = context;
        datePickerPage = PageFactoryManager.getDatePickerPage(context.driver);
    }
    @Given("go to date picker page")
    public void goToDatePickerPage() {
        datePickerPage.load("date-picker");
    }
    @When("Fill date picker input")
    public void fillDatePickerInput() {
        datePickerPage.fillDatePickerInput();
    }
    @Then("input is correct")
    public void inputIsCorrect() {
        Assert.assertEquals(datePickerPage.getDatePickerInputValue(), "01/04/2018");
    }
}
