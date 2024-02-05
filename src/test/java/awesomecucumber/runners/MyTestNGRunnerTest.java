package awesomecucumber.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
		plugin = {
				"json:target/cucumber/cucumber.json",
				"html:target/cucumber/cucumber.html"
		},
		 glue = {"awesomecucumber.customtype", "awesomecucumber.stepdefinitions", "awesomecucumber.hooks"},
		features = "src/test/resources/features",
		tags = "@main"
)
public class MyTestNGRunnerTest extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
