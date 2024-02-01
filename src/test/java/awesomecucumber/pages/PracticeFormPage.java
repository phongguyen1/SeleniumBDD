package awesomecucumber.pages;

import awesomecucumber.domainobjects.Student;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.*;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Arrays;

public class PracticeFormPage extends BasePage {
    @FindBy(css = ".modal")
    private WebElement modalConfirm;
    @FindBy(css = "form#userForm")
    private WebElement userForm;
    @FindBy(css = "#firstName")
    private WebElement firstNameInput;
    @FindBy(css = "#lastName")
    private WebElement lastNameInput;
    @FindBy(css = "#userEmail")
    private WebElement emailInput;
    @FindBy(css = "input[name=\"gender\"]")
    private WebElement genderInput;
    @FindBy(css = "input#userNumber")
    private WebElement mobileInput;
    @FindBy(css = "input#uploadPicture")
    private WebElement uploadPictureInput;
    @FindBy(css = "input#dateOfBirthInput")
    private WebElement dateOfBirthInput;
    @FindBy(css = "input#subjectsInput")
    private WebElement subjectsInput;
    @FindBy(css = "input[id^=\"hobbies-checkbox-\"]")
    private WebElement hobbiesInput;
    @FindBy(css = "textarea#currentAddress")
    private WebElement currentAddressTextarea;
    @FindBy(css = "#state input")
    private WebElement stateInput;
    @FindBy(css = "#city input")
    private WebElement cityInput;
    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    public void fillForm(Student student) throws InterruptedException {
        clearAndSendKeys(firstNameInput, student.getFirstName());
        clearAndSendKeys(lastNameInput, student.getLastName());
        clearAndSendKeys(emailInput, student.getEmail());
        fillGender(student);
        clearAndSendKeys(mobileInput, student.getMobile());
        fillDateOfBirth(student);
        fillSubjects(student);
        fillHobbies(student);
        uploadPictureInput.sendKeys(student.getPicture());
        clearAndSendKeys(currentAddressTextarea, student.getCurrentAddress());
        fillState(student);
        fillCity(student);
    }
    public void clickSubmit() {
        firstNameInput.sendKeys(Keys.ENTER);
    }

    private void fillCity(Student student) {
        String city = student.getCity();
        cityInput.sendKeys(city);
        cityInput.sendKeys(Keys.TAB);
    }

    private void fillState(Student student) {
        String state = student.getState();
        stateInput.sendKeys(state);
        stateInput.sendKeys(Keys.TAB);

    }


    public void fillSubjects(Student student) {
        String subjects = student.getSubjects();
        String[] subjectsArray = subjects.split(",\\s*");
        for (String subject : subjectsArray) {
            clearAndSendKeys(subjectsInput, subject);
            subjectsInput.sendKeys(Keys.TAB);
        }
    }
    public void fillHobbies(Student student) {
        String subjects = student.getHobbies();
        String[] valuesArray = subjects.split(",\\s*");
        for (String value : valuesArray) {
            List<WebElement> labels = driver.findElements(By.cssSelector("label[for^='hobbies-checkbox']"));
            for (WebElement label : labels) {
                if (getElementText(label).equalsIgnoreCase(value)) {
                    label.click();
                }
            }
        }
    }
    public void fillGender(Student student) throws InterruptedException {
        String gender = student.getGender();
        WebElement genderInput = driver.findElement(By.cssSelector("input[name='gender'][value='" + gender + "'] + label"));
        click(genderInput);
    }
    public void fillDateOfBirth(Student student) {
        String dateOfBirth = student.getDataOfBirth();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        LocalDate date = LocalDate.parse(dateOfBirth, formatter);

        int day = date.getDayOfMonth();
        int month = date.getMonthValue();
        String year = Integer.toString(date.getYear());

        WebElement adsElement = driver.findElement(By.cssSelector("img[src=\"https://ad.plus/adplus-advertising.svg]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("return arguments[0].remove();", adsElement);

        dateOfBirthInput.click();
        WebElement selectedYear = driver.findElement(By.cssSelector("select.react-datepicker__year-select"));
        selectedYear.click();
        selectedYear.sendKeys(year);

        WebElement selectedMonth = driver.findElement(By.cssSelector("select.react-datepicker__month-select"));
        selectedMonth.click();
        selectedMonth.sendKeys(Integer.toString(month - 1));

        String __day = day < 10 ? "0" + day : Integer.toString(day);
        WebElement selectedDay = driver.findElement(By.cssSelector(".react-datepicker__day--0" + __day + ":not(.react-datepicker__day--outside-month)"));
        selectedDay.click();
    }
    public boolean isShowModal() {
        return driver.findElement(By.cssSelector(".modal")) != null;
    }
    public boolean checkDataInModal(Student student) {
        WebElement table = driver.findElement(By.cssSelector(".modal table"));
        return getElementText(table).contains(student.getFirstName());
    }
}
