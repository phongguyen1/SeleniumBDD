package awesomecucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MenuPage extends BasePage {
    @FindBy(css = "ul#nav > li:nth-child(2)")
    private WebElement mainItem2;
    private Actions action = new Actions(driver);
    public MenuPage(WebDriver driver) {
        super(driver);
    }
    public void hoverMainItem2() {
        action.moveToElement(mainItem2).perform();
    }
    public void hoverSubSubList() {
        WebElement subSubListItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul#nav > li:nth-child(2) > ul > li:nth-child(3)")));
        action.moveToElement(subSubListItem).perform();
    }
    public boolean isSubSubItemAppeared() {
        WebElement subSubItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul#nav > li:nth-child(2) > ul > li:nth-child(3) ul")));
        return subSubItem.isDisplayed();
    }
}
