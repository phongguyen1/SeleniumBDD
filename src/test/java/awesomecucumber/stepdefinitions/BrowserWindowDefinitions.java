package awesomecucumber.stepdefinitions;

import awesomecucumber.context.TestContext;
import awesomecucumber.factory.PageFactoryManager;
import awesomecucumber.pages.BrokenLinksPage;
import awesomecucumber.pages.BrowserWindowsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class BrowserWindowDefinitions {
    private final TestContext context;
    private final BrowserWindowsPage browserWindowsPage;
    public BrowserWindowDefinitions(TestContext context) {
        this.context = context;
        this.browserWindowsPage = PageFactoryManager.getBrowserWindowsPage(context.driver);
    }
    @Given("go to Browser Window")
    public void goToBrowserWindow() {
        this.browserWindowsPage.load("browser-windows");
    }

    @When("click \"New Tab\" button")
    public void clickNewTabButton() {
    }
    @When("click \"New Window\" button")
    public void clickNewWindowButton() {
        this.browserWindowsPage.windowButtonBtnClick();
    }
    @When("click \"New Window Message\" button")
    public void clickNewMessageWindowButton() {
    }

    @Then("New tab is presented")
    public void newTabIsPresented() {
        Assert.assertTrue(browserWindowsPage.isNewTabPresented());
    }

    @Then("New window is presented")
    public void newWindowIsPresented() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertTrue(browserWindowsPage.isNewWindowPresented());
    }

    @Then("New window message is presented")
    public void newWindowMessageIsPresented() {
    }
}
