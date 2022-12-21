package com.sdetcourse.testRunner;

import cucumber.api.CucumberOptions;

@CucumberOptions(
		features = "/sdet_java/src/main/java/features/AmazonExercise.feature",
		glue = "stepDefinitions",
		dryRun = false,
		plugin = {"pretty", "html:test-output"})
public class Runner {
}
