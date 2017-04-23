package com.Cucumber;

import java.io.File;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin={"Pretty","html:/CucumberConcepts/Reports/","com.cucumber.listener.ExtentCucumberFormatter:output/report.html"},
		features={"/src/com/Cucumber/Resources"},
		glue = {"/src/com/Cucumber"}
	)
		
		
public class TestRunner {
	@AfterClass
    public static void setup() {
        Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setSystemInfo("os", "Windows");
        Reporter.setTestRunnerOutput("Sample test runner output message");
    }
}


	