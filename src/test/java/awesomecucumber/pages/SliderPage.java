package awesomecucumber.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SliderPage extends BasePage {
    @FindBy(css = "input[type='range']")
    private WebElement rangeInput;
    @FindBy(css = "input#sliderValue")
    private WebElement textInput;
    public SliderPage(WebDriver driver) {
        super(driver);
    }
    public void dragRangeInputToValue(int value) {
//        rangeInput.sendKeys();
//        Actions move = new Actions(driver);
//        move.dragAndDropBy(rangeInput, value, 0).build().perform();
        int currentValue = Integer.parseInt(rangeInput.getAttribute("value"));
        do {
            currentValue = currentValue < value ? currentValue + 1 : currentValue - 1;
            rangeInput.sendKeys(currentValue < value ? Keys.RIGHT : Keys.LEFT);
        } while (currentValue != value);
    }
    public String getTextInputValue() {
        return textInput.getAttribute("value");
    }
}
