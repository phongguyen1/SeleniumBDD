package awesomecucumber.stepdefinitions;

import awesomecucumber.context.TestContext;
import awesomecucumber.factory.PageFactoryManager;
import awesomecucumber.pages.RadioBtnPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
//import org.testng.Assert;

public class RadioButtonDefinitions {
    private final TestContext context;
    private final RadioBtnPage radioBtnPage;
    public RadioButtonDefinitions(TestContext context) {
        this.context = context;
        this.radioBtnPage = PageFactoryManager.getRadioBtnPage(context.driver);
    }

    @Given("Go to Radio Button Page")
    public void goToRadioButtonPage() {
        this.radioBtnPage.load("radio-button");
    }

    @When("Click {string}")
    public void clickRadioBtn(String radioBtnName) {
        WebElement radioBtnEl = radioBtnPage.getRadioButton(radioBtnName);
        radioBtnEl.click();
    }

    @Then("the text should be: You have selected {string}")
    public void theTextShouldBeYouHaveSelected(String radioBtnName) {
        String selectedText = radioBtnPage.getSelectedText();
        System.out.println("selectedText: " + selectedText);
        Assert.assertEquals(selectedText.toLowerCase(), ("You have selected " + radioBtnName).toLowerCase());
    }
}
