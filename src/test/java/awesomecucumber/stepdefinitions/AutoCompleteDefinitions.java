package awesomecucumber.stepdefinitions;

import awesomecucumber.context.TestContext;
import awesomecucumber.factory.PageFactoryManager;
import awesomecucumber.pages.AccordianPage;
import awesomecucumber.pages.AutoCompletePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class AutoCompleteDefinitions {
    private final TestContext context;
    private final AutoCompletePage autoCompletePage;
    public AutoCompleteDefinitions(TestContext context) {
        this.context = context;
        autoCompletePage = PageFactoryManager.getAutoCompletePage(context.driver);
    }
    @Given("go to auto complete page")
    public void goToAutoCompletePage() {
        autoCompletePage.load("auto-complete");
    }

    @When("Add Black And Aqua value on multiple input")
    public void addValueToInput() {
        autoCompletePage.fillMultipleInput();
    }

    @Then("input value have Black And Aqua")
    public void assertInputValue() {
        String text = autoCompletePage.getMultiInputText();
        System.out.println(text);
        Assert.assertTrue(text.contains("Black"));
        Assert.assertTrue(text.contains("Aqua"));
    }
}
