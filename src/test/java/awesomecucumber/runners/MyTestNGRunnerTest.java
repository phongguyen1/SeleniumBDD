package awesomecucumber.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
		plugin = {
				"html:target/cucumber/cucumber.html" ,
				"me.jvt.cucumber.report.PrettyReports:target/cucumber/"
		},
		 glue = {"awesomecucumber.customtype", "awesomecucumber.stepdefinitions", "awesomecucumber.hooks"},
		features = "src/test/resources/features",
		tags = "main"
)
public class MyTestNGRunnerTest extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
