package awesomecucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class LinksPage extends BasePage{
    @FindBy(css = "a#simpleLink")
    private WebElement homeLink;
    @FindBy(css = "a#created")
    private WebElement createdLink;
    @FindBy(css = "a#bad-request")
    private WebElement badRequestLink;
    @FindBy(css = "p#linkResponse")
    private WebElement linkResponseElm;
    public LinksPage(WebDriver driver) {
        super(driver);
    }
    public void clickHomeLink() {
        this.homeLink.click();
    }
    public void clickCreatedLink() {
        this.createdLink.click();
    }
    public void clickBadRequestLink() {
        this.badRequestLink.click();
    }
    public String getNewTabUrl() {
        System.out.println(driver.getWindowHandles());
        List<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(1));
        return driver.getCurrentUrl();
    }
    public void deleteNewTabAndReturnToLinksPage() {
        driver.close();
        List<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(0));
    }
    public String getLinkResponseText() {
        return getElementText(this.linkResponseElm);
    }
}
