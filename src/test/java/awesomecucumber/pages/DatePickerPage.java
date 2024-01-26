package awesomecucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DatePickerPage extends BasePage {
    @FindBy(css = "input#datePickerMonthYearInput")
    private WebElement datePickerInput;
    public DatePickerPage(WebDriver driver) {
        super(driver);
    }
    public void fillDatePickerInput() {
        datePickerInput.click();
        WebElement monthInput = driver.findElement(By.cssSelector("select.react-datepicker__month-select"));
        monthInput.click();
        monthInput.sendKeys("0");

        WebElement yearInput = driver.findElement(By.cssSelector("select.react-datepicker__year-select"));
        yearInput.click();
        yearInput.sendKeys("2018");

        driver.findElement(By.cssSelector(".react-datepicker__day.react-datepicker__day--004")).click();
    }

    public String getDatePickerInputValue() {
        return datePickerInput.getAttribute("value");
    }
}
