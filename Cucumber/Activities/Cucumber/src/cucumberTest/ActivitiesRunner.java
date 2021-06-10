package cucumberTest;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Features",
    glue = {"stepDefinitions"},
    //tags = "@activity2_5",
    tags = "@SmokeTest",
    
    //for pretty reports. This will print in the console
    plugin = {"pretty"},
    
    //for HTML report. This will create a new folder named test-reports.
    //plugin = {"html: test-reports"},
    
    //for JSON report. This will create a new file named json-report.json in test-reports folder
    //plugin = {"json: test-reports/json-report.json"},
    
    monochrome = true
    )

public class ActivitiesRunner {
	
}


