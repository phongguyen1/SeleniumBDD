package awesomecucumber.stepdefinitions;

import awesomecucumber.context.TestContext;
import awesomecucumber.factory.PageFactoryManager;
import awesomecucumber.pages.TextBoxPage;
import awesomecucumber.pages.ToolTipsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ToolTipsDefinitions {
    private final TestContext context;
    private final ToolTipsPage toolTipsPage;
    public ToolTipsDefinitions(TestContext context) {
        this.context = context;
        this.toolTipsPage = PageFactoryManager.getToolTipsPage(context.driver);
    }
    @Given("go to Tool Tips page")
    public void goToToolTipsPage() {
        toolTipsPage.load("tool-tips");
    }
    @When("hover Btn")
    public void hoverBtn() {
        toolTipsPage.hoverButton();
    }
    @Then("Tool tip appeared")
    public void tooltipAppeared() {
        Assert.assertTrue(toolTipsPage.isToolTipAppeared());
    }
}
