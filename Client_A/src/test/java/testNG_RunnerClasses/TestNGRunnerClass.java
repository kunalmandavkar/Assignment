package testNG_RunnerClasses;

import org.testng.annotations.Test;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = "src/test/resources/Features",
		glue={"com.stepGeneratorClasses"},
		tags= {"@t7"}
		
		)
@Test
public class TestNGRunnerClass extends AbstractTestNGCucumberTests {
	
}
