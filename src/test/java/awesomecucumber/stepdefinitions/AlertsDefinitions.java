package awesomecucumber.stepdefinitions;

import awesomecucumber.context.TestContext;
import awesomecucumber.factory.PageFactoryManager;
import awesomecucumber.pages.AlertsPage;
import awesomecucumber.pages.BrokenLinksPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class AlertsDefinitions {
    private final TestContext context;
    private final AlertsPage alertsPage;
    public AlertsDefinitions(TestContext context) {
        this.context = context;
        this.alertsPage = PageFactoryManager.getAlertsPage(context.driver);
    }
    @Given("go to Alert Page")
    public void goToAlertPage() {
        this.alertsPage.load("alerts");
    }

    @When("click Button to see alert")
    public void clickButtonToSeeAlert() {
        alertsPage.clickAlertButton();
    }

    @Then("Alert's appeared")
    public void alertSAppeared() throws InterruptedException {
        Assert.assertTrue(alertsPage.isAlertAppeared());
    }

    @When("click Button to see confirm box")
    public void clickButtonToSeeConfirmBox() {
        alertsPage.clickConfirmButton();
    }

    @Then("text confirm box show correctly")
    public void textConfirmBoxShowCorrectly() throws InterruptedException {
        Assert.assertEquals(alertsPage.confirmResultText(), "You selected Ok");
    }

    @When("click Button to see prompt box")
    public void clickButtonToSeePromptBox() {
        alertsPage.clickPromptButton();
    }
    @And("fill the input {string}")
    public void fillTheInput(String testName) throws InterruptedException {
        alertsPage.fillPromptInput(testName);
    }
    @Then("text prompt box show correctly {string}")
    public void textPromptBoxShowCorrectly(String testName) {
        Assert.assertEquals(alertsPage.promptResultText(), "You entered " + testName);
    }


}
