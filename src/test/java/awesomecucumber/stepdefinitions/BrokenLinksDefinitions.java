package awesomecucumber.stepdefinitions;

import awesomecucumber.context.TestContext;
import awesomecucumber.factory.PageFactoryManager;
import awesomecucumber.pages.BrokenLinksPage;
import awesomecucumber.pages.ButtonsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class BrokenLinksDefinitions {
    private final TestContext context;
    private final BrokenLinksPage brokenLinksPage;
    public BrokenLinksDefinitions(TestContext context) {
        this.context = context;
        this.brokenLinksPage = PageFactoryManager.getBrokenLinksPage(context.driver);
    }
    @Given("Go to Broken Links - Images")
    public void goToBrokenLinksImages() {
        this.brokenLinksPage.load("broken");
    }

    @Then("validImage is valid")
    public void validImageIsValid() {
        Assert.assertTrue(this.brokenLinksPage.isValidImageValid());
    }

    @And("inValidImage is inValid")
    public void invalidImageIsInValid() {
        Assert.assertFalse(this.brokenLinksPage.isInValidImageValid());
    }

    @And("validLink is valid")
    public void validLinkIsValid() {
        Assert.assertTrue(this.brokenLinksPage.isValidLinkValid());
    }

    @And("inValidLink is inValid")
    public void invalidLinkIsInValid() {
        Assert.assertTrue(this.brokenLinksPage.isInValidLinkInValid());
    }
}
