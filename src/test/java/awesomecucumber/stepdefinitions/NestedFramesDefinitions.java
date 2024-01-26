package awesomecucumber.stepdefinitions;

import awesomecucumber.context.TestContext;
import awesomecucumber.factory.PageFactoryManager;
import awesomecucumber.pages.NestedFramesPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class NestedFramesDefinitions {
    private final TestContext context;
    private final NestedFramesPage nestedFramesPage;
    public NestedFramesDefinitions(TestContext context) {
        this.context = context;
        this.nestedFramesPage = PageFactoryManager.getNestedFramesPage(context.driver);
    }
    @Given("go to Nested Frame page")
    public void goToNestedFramePage() {
        nestedFramesPage.load("nestedframes");
    }

    @Then("parent frame text should be: {string}")
    public void parentFrameTextShouldBe(String text) {
        Assert.assertEquals(text, nestedFramesPage.getParentFrameText());
    }

    @And("child frame text should be: {string}")
    public void childFrameTextShouldBe(String text) {
        Assert.assertEquals(text, nestedFramesPage.getChildFrameText());
    }

    @When("check parent Iframe")
    public void checkParentIframe() {
        nestedFramesPage.checkParentIframeText();
    }

    @And("check child Iframe")
    public void checkChildIframe() {
        nestedFramesPage.checkChildIframeText();
    }
}
