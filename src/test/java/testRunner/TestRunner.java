package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:/eAmataProjects/eAmtaAPITestAutomation/src/test/java/feature",//"C:/Users/LNV-24/IdeaProjects/eAmataAPITestAutomation/src/test/java/feature",
        glue = "com.thinkitive.eAmata.stepDefinitions",
          tags = "@getTheLocationList"
//        plugin = {"pretty",
//                "html:target/cucumber-reports.html",
//                "junit:target/cucumber-reports/Cucumber.xml"
//        }


)

public class TestRunner {

}
