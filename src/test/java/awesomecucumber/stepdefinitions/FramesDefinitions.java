package awesomecucumber.stepdefinitions;

import awesomecucumber.context.TestContext;
import awesomecucumber.factory.PageFactoryManager;
import awesomecucumber.pages.FramesPage;
import awesomecucumber.pages.TextBoxPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class FramesDefinitions {
    private final TestContext context;
    private final FramesPage framesPage;
    public FramesDefinitions(TestContext context) {
        this.context = context;
        this.framesPage = PageFactoryManager.getFramesPage(context.driver);
    }
    @Given("go to Frames page")
    public void goToFramesPage() {
        framesPage.load("frames");
    }

    @Then("the text should be: {string}")
    public void theTextShouldBe(String testText) {
        Assert.assertEquals(testText, framesPage.getIframeText());
    }
}
