package awesomecucumber.stepdefinitions;

import awesomecucumber.context.TestContext;
import awesomecucumber.domainobjects.Student;
import awesomecucumber.factory.PageFactoryManager;
import awesomecucumber.pages.BrokenLinksPage;
import awesomecucumber.pages.PracticeFormPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class PracticeFormDefinitions {
    private final TestContext context;
    private final PracticeFormPage practiceFormPage;
    public PracticeFormDefinitions(TestContext context) {
        this.context = context;
        this.practiceFormPage = PageFactoryManager.getPracticeFormPage(context.driver);
    }
    @Given("Go to Practice form page")
    public void goToPracticeFormPage() {
        this.practiceFormPage.load("automation-practice-form");
    }

    @When("I fill student registration form")
    public void iFillStudentRegistrationForm(DataTable table) throws InterruptedException {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        for (Map<String, String> columns: rows) {
            this.context.student = new Student(
                    columns.get("firstName"),
                    columns.get("lastName"),
                    columns.get("email"),
                    columns.get("gender"),
                    columns.get("mobile"),
                    columns.get("dateOfBirth"),
                    columns.get("subjects"),
                    columns.get("hobbies"),
                    columns.get("picture"),
                    columns.get("currentAddress"),
                    columns.get("state"),
                    columns.get("city")
            );
        }
        practiceFormPage.fillForm(this.context.student);
    }

    @And("I Click submit")
    public void iClickSubmit() {
        practiceFormPage.clickSubmit();
    }

    @Then("Show modal")
    public void showModal() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(practiceFormPage.isShowModal());
        Thread.sleep(2000);
    }

    @And("Data is correct")
    public void dataIsCorrect() {
        Assert.assertTrue(practiceFormPage.checkDataInModal(this.context.student));
    }
}
