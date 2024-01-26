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

package awesomecucumber.pages;

import awesomecucumber.utils.ConfigLoader;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static awesomecucumber.constants.FrameworkConstants.ATTRIBUTE_VALUE;
import static awesomecucumber.constants.FrameworkConstants.EXPLICIT_WAIT;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class BasePage {
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected Actions action;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.action = new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		PageFactory.initElements(driver, this);
	}

	public void load(String endPoint) {
		driver.get(ConfigLoader.getInstance().getBaseUrl() + endPoint);
	}

	public void waitForOverlaysToDisappear(By overlay) {
		List<WebElement> overlays = driver.findElements(overlay);
		System.out.println("OVERLAY SIZE" + overlays.size());
		if (overlays.size() > 0) {
			wait.until(ExpectedConditions.invisibilityOfAllElements(overlays));
			System.out.println("OVERLAYS INVISIBLE");
		} else {
			System.out.println("OVERLAY NOT FOUND");
		}
	}

	public void clearAndSendKeys(WebElement element, String value) {
		element = waitForElementVisibility(element);
		element.clear();
		element.sendKeys(value);
	}
	public boolean isImageValid(@NotNull WebElement image) {
		String naturalWidth = image.getAttribute("naturalWidth");
//		System.out.println("naturalWidth " + naturalWidth);
		return !naturalWidth.equals("0");
	}
	private static int getResponseCode(String urlString) {
		try {
			URL u = new URL(urlString);
			HttpURLConnection h =  (HttpURLConnection) u.openConnection();
			h.setRequestMethod("GET");
			h.connect();
			return h.getResponseCode();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return -1;
	}

	public boolean isLinkValid(@NotNull WebElement link) {
		int responseCode = getResponseCode(link.getAttribute("href"));
//		System.out.println("responseCode " + link.getAttribute("href") + ":" + responseCode);
		return responseCode == 301;
	}

	public void click(WebElement element) {
		waitForElementToBeClickable(element).click();
	}

	public void click(By by) {
		waitForElementToBeClickable(by).click();
	}
	public void doubleClick(WebElement element) {
		action.doubleClick(element).perform();
	}
	public void rightClick(WebElement element) {
		action.contextClick(element).perform();
	}
	public WebElement waitForElementVisibility(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public WebElement waitForElementToBeClickable(WebElement element) {
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public WebElement waitForElementToBeClickable(By by) {
		return wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	public void scrollToElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public String getElementText(WebElement element) {
		return waitForElementVisibility(element).getText();
	}

	public String getElementElementAttribute_Value(WebElement element) {
		return waitForElementVisibility(element).getAttribute(ATTRIBUTE_VALUE);
	}

	public String getElementElementCustomAttribute(WebElement element, String customAttribute) {
		return waitForElementVisibility(element).getAttribute(customAttribute);
	}
}
