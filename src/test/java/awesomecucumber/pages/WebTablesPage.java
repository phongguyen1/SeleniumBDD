package awesomecucumber.pages;

import awesomecucumber.domainobjects.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebTablesPage extends BasePage {
    @FindBy(css = "button#addNewRecordButton")
    private WebElement addButton;
    @FindBy(css = "button#submit")
    private WebElement submitBtn;
    @FindBy(css = "input#firstName")
    private WebElement firstNameInput;
    @FindBy(css = "input#lastName")
    private WebElement lastNameInput;
    @FindBy(css = "input#userEmail")
    private WebElement userEmailInput;
    @FindBy(css = "input#age")
    private WebElement ageInput;
    @FindBy(css = "input#salary")
    private WebElement salaryInput;
    @FindBy(css = "input#department")
    private WebElement departmentInput;
    @FindBy(css = "div.rt-tr-group:nth-child(4)")
    private WebElement forthRow;
    public WebTablesPage(WebDriver driver) {
        super(driver);
    }
    public void clickAddButton() {
        this.addButton.click();
    }
    public void fillRegisterForm(User user) {
        clearAndSendKeys(firstNameInput, user.getFirstName());
        clearAndSendKeys(lastNameInput, user.getLastName());
        clearAndSendKeys(userEmailInput, user.getEmail());
        clearAndSendKeys(ageInput, user.getAge().toString());
        clearAndSendKeys(salaryInput, user.getSalary().toString());
        clearAndSendKeys(departmentInput, user.getDepartment());
    }
    public void submitForm() {
        this.submitBtn.click();
    }
    public String getForthRowText() {
        return this.forthRow.getText();
    }
}
