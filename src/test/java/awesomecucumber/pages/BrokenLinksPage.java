package awesomecucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BrokenLinksPage extends BasePage{
    @FindBy(css = "img[src=\"/images/Toolsqa.jpg\"]")
    private WebElement validImage;
    @FindBy(css = "img[src=\"/images/Toolsqa_1.jpg\"]")
    private WebElement inValidImage;
    @FindBy(css = "a[href=\"http://demoqa.com\"]")
    private WebElement validLink;
    @FindBy(css = "a[href=\"http://the-internet.herokuapp.com/status_codes/500\"]")
    private WebElement inValidLink;
    public BrokenLinksPage(WebDriver driver) {
        super(driver);
    }
    public boolean isValidImageValid() {
        return isImageValid(validImage);
    }
    public boolean isInValidImageValid() {
        return isImageValid(inValidImage);
    }
    public boolean isValidLinkValid() {
        return isLinkValid(validLink);
    }
    public boolean isInValidLinkInValid() {
        return !isLinkValid(inValidLink);
    }

}
