package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/student1.feature", glue= "stepdefinition",
                   plugin= {"pretty","html:target/cucumber-reports"})
public class TestRunner {

}
