package awesomecucumber.stepdefinitions.bookstore;

import awesomecucumber.context.TestContext;
import awesomecucumber.factory.PageFactoryManager;
import awesomecucumber.pages.bookstore.BookDetailPage;
import awesomecucumber.pages.bookstore.BooksPage;
import awesomecucumber.pages.bookstore.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class BooksDefinitions {
    private final TestContext context;
    private final BooksPage booksPage;
    public BooksDefinitions(TestContext context) {
        this.context = context;
        booksPage = PageFactoryManager.getBooksPage(context.driver);
    }
    @Given("Go to books list Page")
    public void goToBooksPage() {
        booksPage.load("books");
    }
    @When("click on {string}")
    public void clickOnBook(String bookName) {
        booksPage.clickOnBookName(bookName);
    }
    @And("wait to load book detail page")
    public void waitToLoadBookDetailPage() {
        booksPage.waitToLoadBookDetailPage();
    }
    @Then("{string} appeared on profile Page")
    public void bookAppearedOnProfilePage(String bookName) {
        Assert.assertTrue(booksPage.isBookAppearedOnProfilePage(bookName));
    }
//    @And("click \"Add to your collection\" button")
}
