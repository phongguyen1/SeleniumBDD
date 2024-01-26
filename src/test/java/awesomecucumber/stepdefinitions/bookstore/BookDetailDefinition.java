package awesomecucumber.stepdefinitions.bookstore;

import awesomecucumber.context.TestContext;
import awesomecucumber.factory.PageFactoryManager;
import awesomecucumber.pages.bookstore.BookDetailPage;
import awesomecucumber.pages.bookstore.BooksPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class BookDetailDefinition {
    private final TestContext context;
    private final BookDetailPage bookDetailPage;
    public BookDetailDefinition(TestContext context) {
        this.context = context;
        bookDetailPage = PageFactoryManager.getBookDetailPage(context.driver);
    }

    @Then("Book detail page Appeared")
    public void bookDetailPageAppeared() {
        Assert.assertTrue(bookDetailPage.isBookDetailPageAppeared());
    }
    @And("click \"Add to your collection\" button")
    public void clickAddToYourCollectionButton() {
        bookDetailPage.clickAddToYourCollectionButton();
    }
    @And("click ok on Alert popup")
    public void clickOkOnAlertPopup() {
        bookDetailPage.clickOkOnAlertPopup();
    }

    @And("click on Profile Link")
    public void clickOnProfileLink() {
        bookDetailPage.clickOnProfileLink();
    }
}
