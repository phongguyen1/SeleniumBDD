package awesomecucumber.stepdefinitions;

import awesomecucumber.context.TestContext;
import awesomecucumber.factory.PageFactoryManager;
import awesomecucumber.pages.LinksPage;
import awesomecucumber.pages.StorePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LinksStepDefinition {
    private final TestContext context;
    private final LinksPage linksPage;
    public LinksStepDefinition(TestContext context) {
        this.context = context;
        linksPage = PageFactoryManager.getLinksPage(context.driver);
    }
    @Given("Go to Links page")
    public void goToLinksPage() {
        this.linksPage.load("links");
    }
    @When("I click \"Home\" Link")
    public void clickHomeLink() {
        this.linksPage.clickHomeLink();
    }
    @When("I click \"Created\" link")
    public void clickCreatedLink() {
        this.linksPage.clickCreatedLink();
    }
    @When("I click \"Bad request\" link")
    public void clickBadRequestLink() {
        this.linksPage.clickBadRequestLink();
    }
    @Then("Browser create a new tab url")
    public void createNewTab() {
        String newTabUrl = this.linksPage.getNewTabUrl();
        this.linksPage.deleteNewTabAndReturnToLinksPage();
        Assert.assertEquals(newTabUrl, "https://demoqa.com/");
    }

    @Then("I got status 201")
    public void assertClickCreatedLink() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(this.linksPage.getLinkResponseText().contains("201"));
    }
    @Then("I got status 400")
    public void assertClickBadRequestLink() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(this.linksPage.getLinkResponseText().contains("400"));
    }
}
