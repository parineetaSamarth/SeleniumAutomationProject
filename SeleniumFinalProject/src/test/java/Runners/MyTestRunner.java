package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = {"Features/DemoBlazeApplication.feature"},
glue = {"step.definition"},
plugin = {"html:htmlreport/cucumber-test-report.html","pretty","json:target/cucumber-report.json"}
		)
public class MyTestRunner extends AbstractTestNGCucumberTests {

}
