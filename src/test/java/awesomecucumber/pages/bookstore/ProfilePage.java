package awesomecucumber.pages.bookstore;

import awesomecucumber.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage {
    @FindBy(css = "#login")
    private static WebElement logoutBtn;
    public ProfilePage(WebDriver driver) {
        super(driver);
    }
    public static WebElement getLogoutButton() {
        return logoutBtn;
    }
}
