package awesomecucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserWindowsPage extends BasePage {
    @FindBy(css = "button#tabButton")
    private WebElement newTabBtn;
    @FindBy(css = "button#windowButton")
    private WebElement windowButtonBtn;
    @FindBy(css = "button#messageWindowButton")
    private WebElement messageWindowButtonBtn;
    private String mainWindowHandle;

    public BrowserWindowsPage(WebDriver driver) {
        super(driver);
    }
    public void newTabBtnClick() {
        click(newTabBtn);
    }
    public boolean isNewTabPresented() {
        boolean result = false;
        List<String> browserTabs = new ArrayList<>(driver.getWindowHandles());

        return browserTabs.get(1) != null;
    }

    public void windowButtonBtnClick() {
        mainWindowHandle = driver.getWindowHandle();
        click(windowButtonBtn);
    }
    public boolean isNewWindowPresented() {
        boolean result = false;
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(mainWindowHandle)) {
                result = true;
                break;
            }
        }
        return result;
    }
    public void messageWindowButtonBtnClick() {
        click(messageWindowButtonBtn);
    }

}
