package awesomecucumber.stepdefinitions;

import awesomecucumber.context.TestContext;
import awesomecucumber.factory.PageFactoryManager;
import awesomecucumber.pages.LinksPage;
import awesomecucumber.pages.ModalDialogsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ModalDialogsDefinitions {
    private final TestContext context;
    private final ModalDialogsPage modalDialogsPage;
    public ModalDialogsDefinitions(TestContext context) {
        this.context = context;
        modalDialogsPage = PageFactoryManager.getModalDialogsPage(context.driver);
    }
    @Given("Go to modal dialogs page")
    public void goToModalDialogsPage() {
        modalDialogsPage.load("modal-dialogs");
    }

    @When("click on button")
    public void clickOnButton() {
        modalDialogsPage.clickSmallModalBtn();
    }

    @Then("modal dialogs appeared")
    public void modalDialogsAppeared() {
        Assert.assertTrue(modalDialogsPage.isModalAppread());
    }
}
