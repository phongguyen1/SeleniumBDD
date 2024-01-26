package awesomecucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DraggablePage extends BasePage {
    @FindBy(css = "#dragBox")
    private WebElement dragBox;
    private final Actions actions = new Actions(driver);
    public DraggablePage(WebDriver driver) {
        super(driver);
    }
    public void drag(int xOffset, int yOffset) {
        int dragBoxXOffset = dragBox.getLocation().getX();
        int dragBoxYOffset = dragBox.getLocation().getY();
        System.out.println("dragBoxXOffset" + dragBoxXOffset);
        System.out.println("dragBoxYOffset" + dragBoxYOffset);
        actions.dragAndDropBy(dragBox, xOffset, yOffset).perform();
    }
    public boolean dragSuccessfully(int xOffset, int yOffset) {
        int dragBoxXOffset = dragBox.getLocation().getX();
        int dragBoxYOffset = dragBox.getLocation().getY();
        return dragBoxXOffset != xOffset || dragBoxYOffset != yOffset;
    }
}
