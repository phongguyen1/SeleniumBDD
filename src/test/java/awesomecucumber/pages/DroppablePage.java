package awesomecucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DroppablePage extends BasePage {
    @FindBy(css = "#draggable")
    private WebElement draggableElm;
    @FindBy(css = "#droppable")
    private WebElement droppableElm;
    private final Actions actions = new Actions(driver);
    public DroppablePage(WebDriver driver) {
        super(driver);
    }
    public void dragIntoDropElm() {
        actions.dragAndDrop(draggableElm, droppableElm).perform();
        boolean result = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("#droppable"), "Dropped!"));
        System.out.println(result);
    }
    public String getDragAndDropSuccessMess() {
        return getElementText(driver.findElement(By.cssSelector("#droppable")));
    }
}
