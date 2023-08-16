package Testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features={"Allfeatures"},
		glue= {"Stepdefination"},
		dryRun=false,
		tags="@EndToEndTesting",
		plugin= {"pretty","com.aventstack.extentreports.cucumber.adapater.ExtentCucumberAdapter:"}
		
		)

public class Runnertest extends AbstractTestNGCucumberTests
{

}
