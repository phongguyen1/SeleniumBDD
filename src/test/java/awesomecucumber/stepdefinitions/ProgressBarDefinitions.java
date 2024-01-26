package awesomecucumber.stepdefinitions;

import awesomecucumber.context.TestContext;
import awesomecucumber.factory.PageFactoryManager;
import awesomecucumber.pages.ProgressBarPage;
import awesomecucumber.pages.RadioBtnPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ProgressBarDefinitions {
    private final TestContext context;
    private final ProgressBarPage progressBarPage;
    public ProgressBarDefinitions(TestContext context) {
        this.context = context;
        this.progressBarPage = PageFactoryManager.getProgressBarPage(context.driver);
    }
    @Given("go to Progress Bar page")
    public void goToProgressBarPage() {
        progressBarPage.load("progress-bar");
    }
    @When("click start button")
    public void clickStartButton() {
        progressBarPage.clickStartButton();
    }
    @And("wait until Reset button appeared")
    public void waitUntilResetButtonAppeared() {
        progressBarPage.waitToSeeResetButton();
    }
    @Then("Progress Bar is 100%")
    public void progressBarIs100() {
        Assert.assertEquals(progressBarPage.getProgressBarText(), "100%");
    }
}
