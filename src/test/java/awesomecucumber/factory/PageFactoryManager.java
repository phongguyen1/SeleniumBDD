/**
 * @author Rajat Verma
 * https://www.linkedin.com/in/rajat-v-3b0685128/
 * https://github.com/rajatt95
 * https://rajatt95.github.io/
 *
 * Course: Cucumber BDD Masterclass with Selenium 4 & Java + Framework (https://www.udemy.com/course/cucumber-bdd-masterclass/)
 * Tutor: Omprakash Chavan (https://www.udemy.com/user/omprakash-chavan/)
 */

/***************************************************/

package awesomecucumber.factory;

import awesomecucumber.pages.*;
import awesomecucumber.pages.bookstore.BookDetailPage;
import awesomecucumber.pages.bookstore.BooksPage;
import awesomecucumber.pages.bookstore.LoginPage;
import org.openqa.selenium.WebDriver;

import java.util.Date;

public class PageFactoryManager {

    private static StorePage storePage;
    private static CartPage cartPage;
    private static CheckoutPage checkoutPage;
    private static ProductPage productPage;
	private static TextBoxPage TextBoxPage;
	private static CheckboxPage CheckboxPage;
	private static RadioBtnPage radioBtnPage;
	private static WebTablesPage webTablesPage;
	private static ButtonsPage buttonsPage;
	private static LinksPage linksPage;
	private static BrokenLinksPage brokenLinksPage;
	private static UploadDownloadPage uploadDownloadPage;
	private static DynamicPropertiesPage dynamicPropertiesPage;
	private static PracticeFormPage practiceFormPage;
	private static BrowserWindowsPage browserWindowsPage;
	private static AlertsPage alertsPage;
	private static FramesPage framesPage;
	private static NestedFramesPage nestedFramesPage;
	private static ModalDialogsPage modalDialogsPage;
	private static AccordianPage accordianPage;
	private static AutoCompletePage autoCompletePage;
	private static DatePickerPage datePickerPage;
	private static SliderPage sliderPage;
	private static ProgressBarPage progressBarPage;
	private static TabsPage tabsPage;
	private static ToolTipsPage toolTipsPage;
	private static MenuPage menuPage;
	private static SortablePage sortablePage;
	private static ResizablePage resizablePage;
	private static DroppablePage droppablePage;
	private static DraggablePage draggablePage;
	private static LoginPage loginPage;
	private static BooksPage booksPage;
	private static BookDetailPage bookDetailPage;
	public static BookDetailPage getBookDetailPage(WebDriver driver) {
		return bookDetailPage == null ? new BookDetailPage(driver) : bookDetailPage;
	}
	public static BooksPage getBooksPage(WebDriver driver) {
		return booksPage == null ? new BooksPage(driver) : booksPage;
	}
	public static LoginPage getLoginPage(WebDriver driver) {
		return loginPage == null ? new LoginPage(driver) : loginPage;
	}
	public static DraggablePage getDraggablePage(WebDriver driver) {
		return draggablePage == null ? new DraggablePage(driver) : draggablePage;
	}
	public static DroppablePage getDroppablePage(WebDriver driver) {
		return droppablePage == null ? new DroppablePage(driver) : droppablePage;
	}
	public static ResizablePage getResizablePage(WebDriver driver) {
		return resizablePage == null ? new ResizablePage(driver) : resizablePage;
	}
	public static SortablePage getSortablePage(WebDriver driver) {
		return sortablePage == null ? new SortablePage(driver) : sortablePage;
	}
	public static MenuPage getMenuPage(WebDriver driver) {
		return menuPage == null ? new MenuPage(driver) : menuPage;
	}
	public static ToolTipsPage getToolTipsPage(WebDriver driver) {
		return toolTipsPage == null ? new ToolTipsPage(driver) : toolTipsPage;
	}
	public static TabsPage getTabsPage(WebDriver driver) {
		return tabsPage == null ? new TabsPage(driver) : tabsPage;
	}
	public static ProgressBarPage getProgressBarPage(WebDriver driver) {
		return progressBarPage == null ? new ProgressBarPage(driver) : progressBarPage;
	}
	public static SliderPage getSliderPage(WebDriver driver) {
		return sliderPage == null ? new SliderPage(driver) : sliderPage;
	}
	public static DatePickerPage getDatePickerPage(WebDriver driver) {
		return datePickerPage == null ? new DatePickerPage(driver) : datePickerPage;
	}
	public static AutoCompletePage getAutoCompletePage(WebDriver driver) {
		return autoCompletePage == null ? new AutoCompletePage(driver) : autoCompletePage;
	}
	public static AccordianPage getAccordianPage(WebDriver driver) {
		return accordianPage == null ? new AccordianPage(driver) : accordianPage;
	}
	public static ModalDialogsPage getModalDialogsPage(WebDriver driver) {
		return modalDialogsPage == null ? new ModalDialogsPage(driver) : modalDialogsPage;
	}
	public static NestedFramesPage getNestedFramesPage(WebDriver driver) {
		return nestedFramesPage == null ? new NestedFramesPage(driver) : nestedFramesPage;
	}
	public static FramesPage getFramesPage(WebDriver driver) {
		return framesPage == null ? new FramesPage(driver) : framesPage;
	}
	public static AlertsPage getAlertsPage(WebDriver driver) {
		return alertsPage == null ? new AlertsPage(driver) : alertsPage;
	}
	public static BrowserWindowsPage getBrowserWindowsPage(WebDriver driver) {
		return browserWindowsPage == null ? new BrowserWindowsPage(driver) : browserWindowsPage;
	}
	public static PracticeFormPage getPracticeFormPage(WebDriver driver) {
		return practiceFormPage == null ? new PracticeFormPage(driver) : practiceFormPage;
	}
	public static DynamicPropertiesPage getDynamicPropertiesPage(WebDriver driver) {
		return dynamicPropertiesPage == null ? new DynamicPropertiesPage(driver) : dynamicPropertiesPage;
	}
	public static UploadDownloadPage getUploadDownloadPage(WebDriver driver) {
		return uploadDownloadPage == null ? new UploadDownloadPage(driver) : uploadDownloadPage;
	}
	public static BrokenLinksPage getBrokenLinksPage(WebDriver driver) {
		return brokenLinksPage == null ? new BrokenLinksPage(driver) : brokenLinksPage;
	}
	public static LinksPage getLinksPage(WebDriver driver) {
		return linksPage == null ? new LinksPage(driver) : linksPage;
	}
	public static ButtonsPage getButtonsPage(WebDriver driver) {
		return buttonsPage == null ? new ButtonsPage(driver) : buttonsPage;
	}
	public static WebTablesPage getWebTablesPage(WebDriver driver) {
		return webTablesPage == null ? new WebTablesPage(driver) : webTablesPage;
	}
	public static TextBoxPage getTextboxPage(WebDriver driver) {
		return TextBoxPage == null ? new TextBoxPage(driver) : TextBoxPage;
	}
	public static CheckboxPage getCheckboxPage(WebDriver driver) {
		return CheckboxPage == null ? new CheckboxPage(driver) : CheckboxPage;
	}
	public static RadioBtnPage getRadioBtnPage(WebDriver driver) {
		return radioBtnPage == null ? new RadioBtnPage(driver) : radioBtnPage;
	}

	public static StorePage getStorePage(WebDriver driver) {
		/**
		 * Using Ternary Operator: Checking for storePage as null.
		 * 
		 * If it is null, then, create new object and return
		 *
		 * If it is not null, then, return storePage
		 */
		return storePage == null ? new StorePage(driver) : storePage;
	}

	public static CartPage getCartPage(WebDriver driver) {
		return cartPage == null ? new CartPage(driver) : cartPage;
	}

	public static CheckoutPage getCheckoutPage(WebDriver driver) {
		return checkoutPage == null ? new CheckoutPage(driver) : checkoutPage;
	}

	public static ProductPage getProductPage(WebDriver driver) {
		return productPage == null ? new ProductPage(driver) : productPage;
	}
}
