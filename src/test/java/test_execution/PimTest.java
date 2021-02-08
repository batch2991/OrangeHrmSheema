package test_execution;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		
		features = {"/OrangeHRM/src/test/java/test_execution/pim_users.feature"},
		
		glue= {"test_execution"},
		tags = "@addemp"
		
		
		)


@RunWith(Cucumber.class)
public class PimTest extends AbstractTestNGCucumberTests {

}
