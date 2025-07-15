package com.qa.studymate.ui.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/resources",
        glue = "com/qa/studymate/ui/stepDefinitions",
        dryRun = false,
        tags = "@createAndDeleteGroup",
        plugin={"pretty","html:target/uiReport.html","rerun:target/uiFailedTests.txt"}
)


public class Runner {
}
