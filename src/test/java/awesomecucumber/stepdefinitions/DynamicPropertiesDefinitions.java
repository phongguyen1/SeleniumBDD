package awesomecucumber.stepdefinitions;

import awesomecucumber.context.TestContext;
import awesomecucumber.factory.PageFactoryManager;
import awesomecucumber.pages.BrokenLinksPage;
import awesomecucumber.pages.DynamicPropertiesPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class DynamicPropertiesDefinitions {
    private final TestContext context;
    private final DynamicPropertiesPage dynamicPropertiesPage;
    public DynamicPropertiesDefinitions(TestContext context) {
        this.context = context;
        this.dynamicPropertiesPage = PageFactoryManager.getDynamicPropertiesPage(context.driver);
    }
    @Given("Go to dynamic properties page")
    public void goToDynamicPropertiesPage() {
        this.dynamicPropertiesPage.load("dynamic-properties");
    }

    @When("wait for 5s")
    public void waitForS() throws InterruptedException {
        Thread.sleep(5000);
    }

    @Then("check text random Id")
    public void checkTextRandomId() {
        Assert.assertEquals(dynamicPropertiesPage.getPText(), "This text has random Id");
    }

    @And("1st button enabled")
    public void stButtonEnabled() {
        Assert.assertTrue(dynamicPropertiesPage.isButtonEnabled());
    }

    @And("2nd button change color")
    public void ndButtonChangeColor() {
        Assert.assertTrue(dynamicPropertiesPage.getButtonColor().equalsIgnoreCase("rgba(220, 53, 69, 1)"));
    }

    @And("3rd button appear")
    public void rdButtonAppear() {
        Assert.assertTrue(dynamicPropertiesPage.isButtonVisible());
    }
}
