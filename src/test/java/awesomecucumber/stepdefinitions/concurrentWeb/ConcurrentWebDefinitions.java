package awesomecucumber.stepdefinitions.concurrentWeb;

import awesomecucumber.context.TestContext;
import awesomecucumber.factory.PageFactoryManager;
import awesomecucumber.hooks.MyHooks;
import awesomecucumber.pages.RadioBtnPage;
import awesomecucumber.pages.concurrentWeb.FirstPage;
import awesomecucumber.pages.concurrentWeb.SecondPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ConcurrentWebDefinitions {
    private final TestContext context;
    private final RadioBtnPage firstPage;
    private final RadioBtnPage secondPage;
    public ConcurrentWebDefinitions(TestContext context) {
        new MyHooks(context, 2);

        this.context = context;

        firstPage = PageFactoryManager.getRadioBtnPage(context.webDriverList.get(0));
        secondPage = PageFactoryManager.getRadioBtnPage(context.webDriverList.get(1));

    }
    @Given("run 2 browsers")
    public void run2browsers() {
        firstPage.load("radio-button");
        secondPage.load("radio-button");
    }

    @When("click \"Yes\" to browser 1")
    public void clickYesBrowser1() {
        WebElement radioBtnEl = firstPage.getRadioButton("yes");
        radioBtnEl.click();
    }

    @When("click \"Impressive\" to browser 2")
    public void clickImpressiveBrowser2() {
        WebElement radioBtnEl = secondPage.getRadioButton("impressive");
        radioBtnEl.click();
    }

    @Then("the text show successfully")
    public void theTextShouldBeYouHaveSelected() {
        String selectedText1 = firstPage.getSelectedText();
        String selectedText2 = secondPage.getSelectedText();
        System.out.println("selectedText1: " + selectedText1);
        System.out.println("selectedText2: " + selectedText2);
        Assert.assertEquals(selectedText1, ("You have selected Yes"));
        Assert.assertEquals(selectedText2, ("You have selected Impressive"));
    }
}
