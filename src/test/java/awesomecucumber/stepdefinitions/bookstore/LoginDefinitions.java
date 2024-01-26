package awesomecucumber.stepdefinitions.bookstore;

import awesomecucumber.context.TestContext;
import awesomecucumber.factory.PageFactoryManager;
import awesomecucumber.pages.AccordianPage;
import awesomecucumber.pages.bookstore.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginDefinitions {
    private final TestContext context;
    private final LoginPage loginPage;
    public LoginDefinitions(TestContext context) {
        this.context = context;
        loginPage = PageFactoryManager.getLoginPage(context.driver);
    }
    @Given("Go to Login Page")
    public void goToLoginPage() {
        loginPage.load("login");
    }
    @When("fill UserName {string} and password {string}")
    public void fillLoginForm(String username, String password) {
        loginPage.fillUserNameAndPassWord(username, password);
    }
    @And("click Login button")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }
    @Then("Login successful")
    public void loginSuccessful() {
        Assert.assertTrue(loginPage.isLoginSuccessful());
    }
}
