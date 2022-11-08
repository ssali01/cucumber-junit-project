package com.cydeo.step_definitions;

import com.cydeo.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    //    @Before ()
    public void setupScenario() {
        System.out.println("Setting up browser using cucumber @Before each scenario in Hooks class");
        Driver.getDriver().get("URL of your app");
    }


    @After
    public void teardownScenario(Scenario scenario) {

        //   System.out.println("It will be closing browser using cucumber @After each scenario in Hooks class");
        if (scenario.isFailed()){

            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        Driver.closeDriver();

    }


    //  @Before (value = "@login", order = 2)
    public void setUpLogIn() {
        System.out.println("Setting up browser using cucumber @Before @login scenario");
    }


    //  @Before (value = "@db", order = 3)
    public void setupDatabaseScenario() {

    }
}
