package com.TestRunnerClass;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
    monochrome = true,
    plugin = {"pretty", "json:target/Output.json"}, // Corrected the file path
    stepNotifications = true,
    dryRun = false,
    glue = "com.stepdefinition",
    features = "C:\\Users\\Admin\\eclipse-workspace\\RyanairProject\\src\\test\\resources\\Features"
    
)
public class TestRunnerClass {

}


