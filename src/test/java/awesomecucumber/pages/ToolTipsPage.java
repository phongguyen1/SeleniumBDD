package awesomecucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ToolTipsPage extends BasePage {
    @FindBy(css = "#toolTipButton")
    private WebElement toolTipButton;
    public ToolTipsPage(WebDriver driver) {
        super(driver);
    }
    public void hoverButton() {
        Actions actions = new Actions(driver);
        actions.moveToElement(toolTipButton).perform();
    }
    public boolean isToolTipAppeared() {
        WebElement toolTip = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#buttonToolTip")));
        return toolTip != null;
    }
}
