package awesomecucumber.stepdefinitions;

import awesomecucumber.context.TestContext;
import awesomecucumber.factory.PageFactoryManager;
import awesomecucumber.pages.SliderPage;
import awesomecucumber.pages.SortablePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class SortableDefinitions {
    private final TestContext context;
    private final SortablePage sortablePage;
    public SortableDefinitions(TestContext context) {
        this.context = context;
        this.sortablePage = PageFactoryManager.getSortablePage(context.driver);
    }
    @Given("go to Sortable Page")
    public void goToSortablePage() {
        sortablePage.load("sortable");
    }
    @When("move One to between three and four {string}")
    public void moveOneToBetweenThreeAndFour(String type) {
        sortablePage.moveOneToAfterThree(type);
    }
    @Then("the order should be start with two three four one {string}")
    public void theOrderShouldBeStartWithTwoThreeFourOne(String type) {
        Assert.assertTrue(sortablePage.getOrderText(type).startsWith("TwoThreeFourOne"));
    }
    @When("click to grid button")
    public void clickToGridButton() {
        sortablePage.clickGridButton();
    }
}
