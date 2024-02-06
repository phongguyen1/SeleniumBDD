package awesomecucumber.pages.concurrentWeb;

import awesomecucumber.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FirstPage extends BasePage {
    @FindBy(css = "label[for='yesRadio']")
    private WebElement YesLabel;
    @FindBy(css = "label[for='impressiveRadio']")
    private WebElement ImpressiveLabel;
    @FindBy(css = "p.mt-3")
    private WebElement selectedText;
    public FirstPage(WebDriver driver) {
        super(driver);
    }
    public WebElement getRadioButton(String radioBtnName) {
        if (radioBtnName.equals("yes")) {
            return this.YesLabel;
        } else {
            return this.ImpressiveLabel;
        }
    }
    public String getSelectedText() {
        return this.selectedText.getText();
    }
}
