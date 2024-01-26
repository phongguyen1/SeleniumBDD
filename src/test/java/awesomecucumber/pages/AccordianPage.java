package awesomecucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccordianPage extends BasePage {
    @FindBy(css = "#section2Heading")
    private WebElement section2Heading;
    public AccordianPage(WebDriver driver) {
        super(driver);
    }
    public void clickSection2Heading() {
        click(section2Heading);
    }
    public String getSection2ContentText() {
        WebElement section2Content = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section2Content")));
        return getElementText(section2Content);
    }
}
