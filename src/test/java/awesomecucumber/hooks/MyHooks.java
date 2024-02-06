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

package awesomecucumber.hooks;

import awesomecucumber.context.TestContext;
import awesomecucumber.factory.DriverFactory;
import awesomecucumber.utils.ZipUtils;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Optional;

import java.util.List;

import static awesomecucumber.constants.FrameworkConstants.*;

public class MyHooks {

	private WebDriver driver;
	private final TestContext context;
	List<WebDriver> webDriverList;
	private int numberOfBrowsers = 1;

	/**
	 * Dependency Injection using Pico container
	 */
	public MyHooks(TestContext context, @Optional Integer nOB) {
		this.context = context;
		this.numberOfBrowsers = nOB != null ? nOB : 1;
	}

	@Before
	public void before(Scenario scenario) {
		System.out.println(
				"BEFORE: THREAD ID : " + Thread.currentThread().getId() + "," + "SCENARIO NAME: " + scenario.getName());

		if (numberOfBrowsers == 1) {
			driver = DriverFactory.initializeDriver(System.getProperty(PARAMETER_BROWSER, BROWSER_FIREFOX));
			context.driver = driver;

		} else {
			for (int i = 0; i < numberOfBrowsers; i++) {
				webDriverList.add(DriverFactory.initializeDriver(System.getProperty(PARAMETER_BROWSER, BROWSER_FIREFOX)));
			}
			context.webDriverList = webDriverList;
		}
	}

	@After
	public void after(Scenario scenario) {
		System.out.println(
				"AFTER: THREAD ID : " + Thread.currentThread().getId() + "," + "SCENARIO NAME: " + scenario.getName());

		/* If Scenario fails */
		/* This is for attaching the screenshot in Cucumber report */
		if (scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}

		// doExtentReportWork(scenario);
		if (numberOfBrowsers == 1) {
			driver.quit();
		} else {
			for (int i = 0; i < numberOfBrowsers; i++) {
				webDriverList.get(numberOfBrowsers).quit();
			}
		}
		numberOfBrowsers = 1;
	}

//	private void doExtentReportWork(Scenario scenario) {
//
//		if (scenario.getStatus().toString().equals("PASSED")) {
//			ExtentLogger.pass("<b><i>" + scenario.getName() + "</i></b>");
//			ExtentLogger.pass("<b><i>" + scenario.getStatus().PASSED + "</i></b>");
//		}
//
//		if (scenario.getStatus().toString().equals("SKIPPED")) {
//			ExtentLogger.skip("<b><i>" + scenario.getName() + "</i></b>");
//			ExtentLogger.skip("<b><i>" + scenario.getStatus().SKIPPED + "</i></b>");
//		}
//
//		if (scenario.isFailed()) {
//			ExtentLogger.fail("<b><i>" + scenario.getName() + "</i></b>");
//			ExtentLogger.fail("<b><i>" + scenario.getStatus().FAILED + "</i></b>");
//		}
//
//	}

//	@BeforeStep
//	public static void beforeStep() {
//		ExtentLogger.pass("<b><i>" + "BEFORE STEP" + "</i></b>");
//	}

	@BeforeAll
	public static void beforeAll() {
		// ExtentReport.initReports();
	}

	@AfterAll
	public static void afterAll() {
		// ExtentReport.flushReports();
//		ZipUtils.zip();
		// EmailSendUtils.sendEmail();

	}

}
