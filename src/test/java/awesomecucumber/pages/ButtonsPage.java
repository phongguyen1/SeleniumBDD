package awesomecucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ButtonsPage extends BasePage {
    @FindBy(css = "button#doubleClickBtn")
    private WebElement doubleClickMeBtn;
    @FindBy(css = "button#rightClickBtn")
    private WebElement rightClickMeBtn;
    @FindBy(css = ".mt-4:not(.col-12):nth-child(3) button")
    private WebElement clickMeBtn;
    @FindBy(css = "p#doubleClickMessage")
    private WebElement doubleClickMessElm;
    @FindBy(css = "p#rightClickMessage")
    private WebElement rightClickMessElm;
    @FindBy(css = "p#dynamicClickMessage")
    private WebElement clickMeMessElm;
    public ButtonsPage(WebDriver driver) {
        super(driver);
    }
    public void doubleClickOnBtn() {
        doubleClick(doubleClickMeBtn);
    }
    public void rightClickOnBtn() {
        rightClick(rightClickMeBtn);
    }
    public void clickOnBtn() {
        clickMeBtn.click();
    }
    public String getDoubleClickMess() {
        return getElementText(doubleClickMessElm);
    }
    public String getRightClickMess() {
        return getElementText(rightClickMessElm);
    }
    public String getDynamicClickMess() {
        return getElementText(clickMeMessElm);
    }
}
