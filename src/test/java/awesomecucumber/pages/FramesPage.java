package awesomecucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramesPage extends BasePage {
    @FindBy(css = "iframe#frame1")
    private WebElement iframeElm;
    public FramesPage(WebDriver driver) {
        super(driver);
    }
    public String getIframeText() {
        driver.switchTo().frame(iframeElm);
        WebElement h1Text = driver.findElement(By.cssSelector("h1#sampleHeading"));
        return getElementText(h1Text);
    }
}
