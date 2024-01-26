package awesomecucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TabsPage extends BasePage {
    @FindBy(css = "a#demo-tab-origin")
    private WebElement tabOriginLink;
    @FindBy(css = "#demo-tabpane-origin")
    private WebElement tabpaneOriginContent;
    public TabsPage(WebDriver driver) {
        super(driver);
    }
    public void clickOriginTabLink() {
        click(tabOriginLink);
    }
    public String getOriginTabContentClass() {
        return tabpaneOriginContent.getAttribute("class");
    }
}
