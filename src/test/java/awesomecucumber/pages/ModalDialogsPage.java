package awesomecucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ModalDialogsPage extends BasePage {
    @FindBy(css = "button#showSmallModal")
    private WebElement smallModalBtn;
    public ModalDialogsPage(WebDriver driver) {
        super(driver);
    }
    public void clickSmallModalBtn() {
        click(smallModalBtn);
    }
    public boolean isModalAppread() {
        WebElement smallModal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal")));
        return smallModal != null;
    }
}
