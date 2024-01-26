package awesomecucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NestedFramesPage extends BasePage {
    @FindBy(css = "iframe#frame1")
    private WebElement parentFrame;

    public String getParentFrameText() {
        return parentFrameText;
    }

    public void setParentFrameText(String parentFrameText) {
        this.parentFrameText = parentFrameText;
    }

    public String getChildFrameText() {
        return childFrameText;
    }

    public void setChildFrameText(String childFrameText) {
        this.childFrameText = childFrameText;
    }

    private String parentFrameText;
    private String childFrameText;
    public NestedFramesPage(WebDriver driver) {
        super(driver);
    }
    public void checkParentIframeText() {
        driver.switchTo().frame(parentFrame);
        WebElement body = driver.findElement(By.cssSelector("body"));
        this.setParentFrameText(getElementText(body));
    }
    public void checkChildIframeText() {
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe")));
        WebElement pElm = driver.findElement(By.cssSelector("p"));
        this.setChildFrameText(getElementText(pElm));
    }
}
