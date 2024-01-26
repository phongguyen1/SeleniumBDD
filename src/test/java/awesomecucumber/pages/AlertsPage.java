package awesomecucumber.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertsPage extends BasePage {
    @FindBy(css = "button#alertButton")
    private WebElement alertButton;
    @FindBy(css = "button#confirmButton")
    private WebElement confirmButton;
    @FindBy(css = "button#promtButton")
    private WebElement promptButton;
    public AlertsPage(WebDriver driver) {
        super(driver);
    }
    public void clickAlertButton() {
        click(alertButton);
    }
    public void clickConfirmButton() {
        click(confirmButton);
    }
    public void clickPromptButton() {
        click(promptButton);
    }
    public boolean isAlertAppeared() throws InterruptedException {
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println(alertText);
        return alertText.equalsIgnoreCase("You clicked a button");
    }
    public String confirmResultText() throws InterruptedException {
        Thread.sleep(1000);
        Alert confirmBox = driver.switchTo().alert();
        confirmBox.accept();
        WebElement selectedText = driver.findElement(By.cssSelector("span#confirmResult"));

        return getElementText(selectedText);
    }
    public void fillPromptInput(String testName) throws InterruptedException {
        Thread.sleep(1000);
        Alert promptBox = driver.switchTo().alert();
        promptBox.sendKeys(testName);
        promptBox.accept();
    }
    public String promptResultText()  {
        WebElement selectedText = driver.findElement(By.cssSelector("span#promptResult"));
        return getElementText(selectedText);
    }
}
