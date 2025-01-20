package org.incubyte.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/org/incubyte/feature_files",
        glue = "org/incubyte/step_def",
        plugin = {"pretty", "html:reports/cucumber-report.html"},
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}

