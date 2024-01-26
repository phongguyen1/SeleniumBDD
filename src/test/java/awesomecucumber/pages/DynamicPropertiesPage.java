package awesomecucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicPropertiesPage extends BasePage {
    @FindBy(css = ".playgound-body p")
    private WebElement pWithRandomId;
    @FindBy(css = "button#enableAfter")
    private WebElement enableButton;
    @FindBy(css = "button#colorChange")
    private WebElement colorButton;
    @FindBy(css = "button#visibleAfter")
    private WebElement visibleButton;
    public DynamicPropertiesPage(WebDriver driver) {
        super(driver);
    }
    public String getPText() {
        return getElementText(pWithRandomId);
    }
    public boolean isButtonEnabled() {
        return enableButton.isEnabled();
    }
    public String getButtonColor() {
        return colorButton.getCssValue("color");
    }
    public boolean isButtonVisible() {
        return visibleButton.isDisplayed();
    }
}
