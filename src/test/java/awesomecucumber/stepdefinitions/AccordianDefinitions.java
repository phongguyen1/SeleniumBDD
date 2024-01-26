package awesomecucumber.stepdefinitions;

import awesomecucumber.context.TestContext;
import awesomecucumber.factory.PageFactoryManager;
import awesomecucumber.pages.AccordianPage;
import awesomecucumber.pages.ModalDialogsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class AccordianDefinitions {
    private final TestContext context;
    private final AccordianPage accordianPage;
    public AccordianDefinitions(TestContext context) {
        this.context = context;
        accordianPage = PageFactoryManager.getAccordianPage(context.driver);
    }
    @Given("go to accordian page")
    public void goToAccordianPage() {
        accordianPage.load("accordian");
    }

    @When("click on 2nd accordian title")
    public void clickOn2NdAccordianTitle() {
        accordianPage.clickSection2Heading();
    }

    @Then("accordian 2nd content appreared")
    public void accordian2NdContentAppreared() {
        Assert.assertTrue(accordianPage.getSection2ContentText().contains("Contrary to popular belief"));
    }
}
