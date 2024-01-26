package awesomecucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AutoCompletePage extends BasePage {
    @FindBy(css = "input#autoCompleteMultipleInput")
    private WebElement multipleInput;
    public AutoCompletePage(WebDriver driver) {
        super(driver);
    }
    public void fillMultipleInput() {
        clearAndSendKeys(multipleInput, "Black");
        multipleInput.sendKeys(Keys.TAB);
        multipleInput.sendKeys("Aqua");
        multipleInput.sendKeys(Keys.TAB);
    }
    public String getMultiInputText() {
        return getElementText(driver.findElement(By.cssSelector(".auto-complete__value-container--is-multi")));
    }
}
