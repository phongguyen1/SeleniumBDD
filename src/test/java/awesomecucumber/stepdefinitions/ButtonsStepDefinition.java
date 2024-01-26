package awesomecucumber.stepdefinitions;

import awesomecucumber.context.TestContext;
import awesomecucumber.factory.PageFactoryManager;
import awesomecucumber.pages.ButtonsPage;
import awesomecucumber.pages.WebTablesPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ButtonsStepDefinition {
    private final TestContext context;
    private final ButtonsPage buttonsPage;
    public ButtonsStepDefinition(TestContext context) {
        this.context = context;
        this.buttonsPage = PageFactoryManager.getButtonsPage(context.driver);
    }
    @Given("Go to Buttons page")
    public void goToButtonPage() {
        buttonsPage.load("buttons");
    }

    @When("I click \"double click me\" button")
    public void doubleClickBtn() {
        this.buttonsPage.doubleClickOnBtn();
    }
    @When("I click \"right click me\" button")
    public void rightClickBtn() {
        this.buttonsPage.rightClickOnBtn();
    }
    @When("I click \"Click me\" button")
    public void clickMeBtn() {
        this.buttonsPage.clickOnBtn();
    }
    @Then("Check Click Mess content")
    public void checkMessContent() {
        Assert.assertEquals(buttonsPage.getDoubleClickMess(), "You have done a double click");
        Assert.assertEquals(buttonsPage.getRightClickMess(),"You have done a right click");
        Assert.assertEquals(buttonsPage.getDynamicClickMess(),"You have done a dynamic click");
    }
}
