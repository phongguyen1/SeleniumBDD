package awesomecucumber.pages.bookstore;

import awesomecucumber.pages.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BookDetailPage extends BasePage {
    @FindBy(css = ".text-right #addNewRecordButton")
    private static WebElement addNewRecordButton;
    @FindBy(css = ".element-group:nth-child(6) li#item-3")
    private static WebElement profileLink;
    public BookDetailPage(WebDriver driver) {
        super(driver);
    }
    public static WebElement getAddToYourCollectionButton() {
        return addNewRecordButton;
    }
    public boolean isBookDetailPageAppeared() {
        return driver.getCurrentUrl().contains("book=");
    }
    public void clickAddToYourCollectionButton() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", addNewRecordButton);
    }
    public void clickOkOnAlertPopup() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    public void clickOnProfileLink() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", profileLink);
    }
}
