package com.tests.runner;

import org.testng.annotations.Test;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json"},features = "src/test/java/com/tests/features", glue = { "com.tests.stepdefenitions" })


public class RunCucumberTests extends AbstractTestNGCucumberTests{

}