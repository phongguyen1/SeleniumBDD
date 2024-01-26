package awesomecucumber.stepdefinitions;

import awesomecucumber.context.TestContext;
import awesomecucumber.factory.PageFactoryManager;
import awesomecucumber.pages.LinksPage;
import awesomecucumber.pages.MenuPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class MenuDefinitions {
    private final TestContext context;
    private final MenuPage menuPage;
    public MenuDefinitions(TestContext context) {
        this.context = context;
        menuPage = PageFactoryManager.getMenuPage(context.driver);
    }
    @Given("go to Menu page")
    public void goToMenuPage() {
        menuPage.load("menu");
    }
    @When("hover Main item 2")
    public void hoverMainItem2() {
        menuPage.hoverMainItem2();
    }

    @And("hover sub sub list")
    public void hoverSubSubList() {
        menuPage.hoverSubSubList();
    }

    @Then("Sub sub item appeared")
    public void subSubItemAppeared() {
        Assert.assertTrue(menuPage.isSubSubItemAppeared());
    }
}
