package awesomecucumber.pages;

import org.apache.commons.math3.analysis.function.Exp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProgressBarPage extends BasePage {
    @FindBy(css = "#startStopButton")
    private WebElement startStopButton;
    @FindBy(css = ".progress-bar")
    private WebElement progressBar;
    public ProgressBarPage(WebDriver driver) {
        super(driver);
    }
    public void clickStartButton() {
        click(startStopButton);
    }
    public void waitToSeeResetButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Boolean textIsPresent = wait.until(ExpectedConditions.textToBePresentInElement(progressBar, "100%"));
        System.out.println(textIsPresent);
    }
    public String getProgressBarText() {
        return getElementText(progressBar);
    }
}
