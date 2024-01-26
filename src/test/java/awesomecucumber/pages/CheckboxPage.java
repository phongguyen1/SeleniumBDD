package awesomecucumber.pages;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckboxPage extends BasePage {
    @FindBy(css = "label[for='tree-node-react']")
    private WebElement ReactCheckbox;
    @FindBy(css = "label[for='tree-node-react'] .rct-checkbox svg")
    private WebElement ReactSVG;
    @FindBy(css = "input#tree-node-workspace")
    private WebElement WorkspaceCheckbox;
    @FindBy(css = "label[for='tree-node-workspace'] .rct-checkbox svg")
    private WebElement WorkspaceSVG;
    @FindBy(css = "input#tree-node-documents")
    private WebElement DocumentsCheckbox;
    @FindBy(css = "label[for='tree-node-documents'] .rct-checkbox svg")
    private WebElement DocumentsSVG;
    @FindBy(css = "input#tree-node-home")
    private WebElement HomeCheckbox;
    @FindBy(css = "label[for='tree-node-home'] .rct-checkbox svg")
    private WebElement HomeCheckSVG;

    @FindBy(css = "button[title='Expand all']")
    private WebElement ExpandAllBtn;
    public CheckboxPage(WebDriver driver) {
        super(driver);
    }
    public void ClickReactCheckbox() {

        WebElement element = waitForElementVisibility(ReactCheckbox);
        click(element);
    }
    public void ClickExpandAllBtn() {
        click(this.ExpandAllBtn);
    }
    private Boolean ElementHasClass(@NotNull WebElement element, String targetClass) {
        String elementClass = element.getAttribute("class");
        return elementClass.contains(targetClass);
    }
    public Boolean ReactCheckboxClicked() {
        return  ElementHasClass(HomeCheckSVG, "rct-icon-half-check") &&
                ElementHasClass(DocumentsSVG, "rct-icon-half-check") &&
                ElementHasClass(WorkspaceSVG, "rct-icon-half-check") &&
                ElementHasClass(ReactSVG, "rct-icon-check");
    }
}
