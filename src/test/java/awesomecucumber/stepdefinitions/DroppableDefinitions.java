package awesomecucumber.stepdefinitions;

import awesomecucumber.context.TestContext;
import awesomecucumber.factory.PageFactoryManager;
import awesomecucumber.pages.DatePickerPage;
import awesomecucumber.pages.DroppablePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class DroppableDefinitions {
    private final TestContext context;
    private final DroppablePage droppablePage;
    public DroppableDefinitions(TestContext context) {
        this.context = context;
        droppablePage = PageFactoryManager.getDroppablePage(context.driver);
    }
    @Given("go to Droppable Page")
    public void goToDroppablePage() {
        droppablePage.load("droppable");
    }
    @When("Drag element to Drop element")
    public void dragElementToDropElement() {
        droppablePage.dragIntoDropElm();
    }
    @Then("Element is drop successfully")
    public void elementIsDropSuccessfully() {
        Assert.assertEquals(droppablePage.getDragAndDropSuccessMess(), "Dropped!");
    }
}
