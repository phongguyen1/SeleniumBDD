package awesomecucumber.stepdefinitions;

import awesomecucumber.context.TestContext;
import awesomecucumber.factory.PageFactoryManager;
import awesomecucumber.pages.ResizablePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ResizableDefinitions {
    private final TestContext context;
    private final ResizablePage resizablePage;
    public ResizableDefinitions(TestContext context) {
        this.context = context;
        this.resizablePage = PageFactoryManager.getResizablePage(context.driver);
    }
    @Given("go to resizable Page")
    public void goToResizablePage() {
        resizablePage.load("resizable");
    }
    @When("Resize element width: \"{int}\", height: \"{int}\"")
    public void resizeElement(int width, int height) {
        resizablePage.resizeElement(width, height);
    }
    @Then("Element is resized")
    public void elementIsResized() {
        Assert.assertTrue(resizablePage.isElementResized());
    }
}
