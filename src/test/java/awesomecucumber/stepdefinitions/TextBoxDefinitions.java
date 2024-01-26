package awesomecucumber.stepdefinitions;

import awesomecucumber.constants.FrameworkConstants;
import awesomecucumber.context.TestContext;
import awesomecucumber.factory.PageFactoryManager;
import awesomecucumber.pages.TextBoxPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.io.IOException;

public class TextBoxDefinitions {

    private final TestContext context;
    private final TextBoxPage textBoxPage;
    public TextBoxDefinitions(TestContext context) {
        this.context = context;
        this.textBoxPage = PageFactoryManager.getTextboxPage(context.driver);
    }

    @Given("Go to Text Box Page")
    public void goToTextBoxPage() {
        this.textBoxPage.load("text-box");
    }

    @When("I Fill Text Box Form")
    public void fillTextBoxForm() {
        this.textBoxPage.fillTextBoxForm();
    }

    @Then("Data visible under the form")
    public void compareText() {
        String expectation = "Name:Nguyen Dinh Phong\n" +
                "Email:phong@gmail.com\n" +
                "Current Address :Hanoi\n" +
                "permanent Address :Vietnam";
        Assert.assertEquals(textBoxPage.getOutput(), expectation);
    }

    @When("I read data from {string} file: {string}")
    public void iGetDataFromCsvFile(String fileType, String filePath) throws IOException {
        textBoxPage.readDataFromFile(fileType, filePath);
    }

    @Then("Data should contains {string}")
    public void dataShouldContains(String firstName) {
        Assert.assertTrue(textBoxPage.getDataFromPDFFile().contains(firstName));
    }

    @And("Fill csv data to form")
    public void fillCsvDataToForm() {
        textBoxPage.fillCsvDataToForm();
    }

    @Then("Data from csv visible under the form")
    public void dataFromCsvVisibleUnderTheForm() {
        String pdfContent = textBoxPage.getOutput();
        Assert.assertTrue(pdfContent.contains("test current Address 8743"));
    }

    @And("Submit Text Box Form")
    public void submitTextBoxForm() {
        textBoxPage.clickSubmit();
    }

    @And("Fill excel data to form")
    public void fillExcelDataToForm() {
        textBoxPage.fillXlsxDataToForm();
    }
}
