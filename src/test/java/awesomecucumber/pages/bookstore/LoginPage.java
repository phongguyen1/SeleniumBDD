package awesomecucumber.pages.bookstore;

import awesomecucumber.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.profiler.model.Profile;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    @FindBy(css = "#login")
    private WebElement loginBtn;
    @FindBy(css = "input#userName")
    private WebElement userNameInput;
    @FindBy(css = "input#password")
    private WebElement passwordInput;
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void fillUserNameAndPassWord(String userName, String passWord) {
        clearAndSendKeys(userNameInput, userName);
        clearAndSendKeys(passwordInput, passWord);
    }
    public void clickLoginButton() {
        click(loginBtn);
    }
    public boolean isLoginSuccessful() {
        wait.until(ExpectedConditions.urlContains("profile"));
        return driver.getCurrentUrl().contains("profile");
    }
}
