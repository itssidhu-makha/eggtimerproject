package org.automation.util;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@critical or @medium",
        features = "src/test/java/org/automation/features/eggtimer.feature",
        glue = {"org.automation.stepdefinitions"},
        plugin = {"json:target/cucumber.json", "pretty","html:target/cucumber-reports.html"},
        publish = false)
    public class Runner {

    }

