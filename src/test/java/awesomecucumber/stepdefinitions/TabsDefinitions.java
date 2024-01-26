package awesomecucumber.stepdefinitions;

import awesomecucumber.context.TestContext;
import awesomecucumber.factory.PageFactoryManager;
import awesomecucumber.pages.SliderPage;
import awesomecucumber.pages.TabsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class TabsDefinitions {
    private final TestContext context;
    private final TabsPage tabsPage;
    public TabsDefinitions(TestContext context) {
        this.context = context;
        this.tabsPage = PageFactoryManager.getTabsPage(context.driver);
    }
    @Given("go to Tabs Page")
    public void goToTabsPage() {
        tabsPage.load("tabs");
    }
    @When("click Origin Tab Link")
    public  void clickOriginTabLink() {
        tabsPage.clickOriginTabLink();
    }
    @Then("Origin Tab Content has class active")
    public void originTabContentHasClassActive() {
        Assert.assertTrue(tabsPage.getOriginTabContentClass().contains("active"));
    }
}
