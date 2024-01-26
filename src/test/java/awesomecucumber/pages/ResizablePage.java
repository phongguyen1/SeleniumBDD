package awesomecucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ResizablePage extends BasePage {
    @FindBy(css = "#resizableBoxWithRestriction")
    private WebElement resizableBoxWithRestriction;
    @FindBy(css = "#resizableBoxWithRestriction span")
    private WebElement resizableHandleWithRestriction;
    private int initialWidth;
    private int initialHeight;
    private Actions actions = new Actions(driver);
    public ResizablePage(WebDriver driver) {
        super(driver);
    }
    public void resizeElement(int width, int height) {
        initialHeight = resizableBoxWithRestriction.getSize().getHeight();
        initialWidth = resizableBoxWithRestriction.getSize().getWidth();

        int xOffset = width - resizableBoxWithRestriction.getSize().getWidth();
        int yOffset = height - resizableBoxWithRestriction.getSize().getHeight();

        actions.clickAndHold(resizableHandleWithRestriction).moveByOffset(xOffset, yOffset).release().perform();
    }
    public boolean isElementResized() {
        System.out.println("resizableBoxWithRestriction.getSize().getHeight()" + resizableBoxWithRestriction.getSize().getHeight());
        System.out.println("resizableBoxWithRestriction.getSize().getWidth()" + resizableBoxWithRestriction.getSize().getWidth());
        System.out.println("initialHeight" + initialHeight);
        System.out.println("initialWidth" + initialWidth);
        return  resizableBoxWithRestriction.getSize().getHeight() != initialHeight ||
                resizableBoxWithRestriction.getSize().getWidth() != initialWidth;
    }
}
