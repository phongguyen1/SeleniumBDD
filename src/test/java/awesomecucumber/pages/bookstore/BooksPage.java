package awesomecucumber.pages.bookstore;

import awesomecucumber.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BooksPage extends BasePage {
    public BooksPage(WebDriver driver) {
        super(driver);
    }
    public void clickOnBookName(String bookName) {
        WebElement bookLinkElm = driver.findElement(By.cssSelector("span[id$=\"" + bookName + "\"]"));
        click(bookLinkElm);

    }
    public void waitToLoadBookDetailPage() {
        wait.until(ExpectedConditions.elementToBeClickable(BookDetailPage.getAddToYourCollectionButton()));
    }
    public boolean isBookAppearedOnProfilePage(String bookName) {
//        driver.findElements(By.cssSelector("span[id^='see-book-'] a"))
        List<WebElement> links = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("span[id^='see-book-'] a")));
        boolean found = false;
        for (WebElement link : links) {
            if (getElementText(link).contains(bookName)) {
                found = true;
                break;
            }
        }
        return found;
    }
}

