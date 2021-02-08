package test_execution;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		
		features = {"/OrangeHRM/src/test/java/test_execution/search.feature"},
		
		glue= {"test_execution"},
		tags = "@sanity",
		monochrome=true
		
		)

@RunWith(Cucumber.class) 
public class SearchTest extends AbstractTestNGCucumberTests
{

}
