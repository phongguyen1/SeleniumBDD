package awesomecucumber.stepdefinitions;

import awesomecucumber.context.TestContext;
import awesomecucumber.factory.PageFactoryManager;
import awesomecucumber.pages.DraggablePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class DraggableDefinitions {
    private final TestContext context;
    private final DraggablePage draggablePage;
    public DraggableDefinitions(TestContext context) {
        this.context = context;
        draggablePage = PageFactoryManager.getDraggablePage(context.driver);
    }
    @Given("go to draggable Page")
    public void goToDraggablePage() {
        draggablePage.load("dragabble");
    }

    @When("Drag element to offsetX: \"{int}\", offsetY: \"{int}\"")
    public void dragElement(int x, int y) {
        draggablePage.drag(x, y);
    }
    @Then("Element is Drag successfully offsetX: \"{int}\", offsetY: \"{int}\"")
    public void dragSuccessfully(int x, int y) {
        Assert.assertTrue(draggablePage.dragSuccessfully(x, y));
    }
}
