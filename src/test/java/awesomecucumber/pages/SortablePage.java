package awesomecucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SortablePage extends BasePage {
    @FindBy(css = "#demo-tabpane-list")
    private WebElement tabpaneList;
    @FindBy(css = "#demo-tabpane-list .list-group-item:first-child")
    private WebElement oneElm;
    @FindBy(css = "#demo-tabpane-list .list-group-item:nth-child(3)")
    private WebElement threeElm;
    @FindBy(css = "#demo-tabpane-list .list-group-item:nth-child(4)")
    private WebElement fourElm;

    @FindBy(css = "#demo-tabpane-grid")
    private WebElement tabpaneGrid;
    @FindBy(css = "#demo-tabpane-grid .list-group-item:first-child")
    private WebElement oneGridElm;
    @FindBy(css = "#demo-tabpane-grid .list-group-item:nth-child(3)")
    private WebElement threeGridElm;
    @FindBy(css = "#demo-tabpane-grid .list-group-item:nth-child(4)")
    private WebElement fourGridElm;

    @FindBy(css = "#demo-tab-grid")
    private WebElement gridButton;
    public SortablePage(WebDriver driver) {
        super(driver);
    }
    public void clickGridButton() {
        click(gridButton);
    }
    public void moveOneToAfterThree(String type) {
        Actions actions = new Actions(driver);
        WebElement one = type.equals("list") ? oneElm : oneGridElm;
        WebElement four = type.equals("list") ? fourElm : fourGridElm;
        actions.clickAndHold(one).moveToElement(four).release().perform();
    }
    public String getOrderText(String type) {
        WebElement tabpane = type.equals("list") ? tabpaneList : tabpaneGrid;
        return getElementText(tabpane).replaceAll("\\n", "");
    }
}
