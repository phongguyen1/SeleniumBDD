package awesomecucumber.stepdefinitions;

import awesomecucumber.context.TestContext;
import awesomecucumber.factory.PageFactoryManager;
import awesomecucumber.pages.RadioBtnPage;
import awesomecucumber.pages.SliderPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class SliderDefinitions {
    private final TestContext context;
    private final SliderPage sliderPage;
    public SliderDefinitions(TestContext context) {
        this.context = context;
        this.sliderPage = PageFactoryManager.getSliderPage(context.driver);
    }
    @Given("go to Slider page")
    public void goToSliderPage() {
        this.sliderPage.load("slider");
    }
    @When("drag input to value {int}")
    public void dragInputToValue(int value) {
        sliderPage.dragRangeInputToValue(value);
    }
    @Then("input Value is {int}")
    public void inputValueIs(int value) {
        Assert.assertEquals(value, Integer.parseInt(sliderPage.getTextInputValue()));
    }
}
