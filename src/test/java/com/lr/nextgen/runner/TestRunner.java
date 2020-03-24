package com.lr.nextgen.runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features", glue={"com.lr.nextgen.stepdefs.MS1"}, plugin = {"pretty", "html:target/cucumber",
        "json:target/cucumber.json", "junit:target/cucumber.xml"})

public class TestRunner {

}
