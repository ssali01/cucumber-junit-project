package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    /**
     * 1- creating a private constructor,
     * so we're closing access to the object of this class from outside of any classes
     */
    private Driver() {
    }

    /**
     * 2- making Driver instance private that is not reachable form outside of any class
     * we made it Static, because we want it to run before anything else
     * also we're going to use it in Static method
     */
    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();


    /**
     * 3- create reusable get() wich will return the same driver when we call it
     * if driver(browser) equals null, means has not been opened yet
     * we will use switch statement to switch browsers
     * depending on browser type, our switch statement will determine which type of browser to open
     */
    public static WebDriver getDriver() {

        if (driverPool.get() == null) {

            String browserType = ConfigurationReader.getProperty("browser");

            switch (browserType) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--lang=en");
                    driverPool.set(new ChromeDriver(options));
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driverPool.set(new EdgeDriver());
                    break;

            }
            driverPool.get().manage().window().maximize();
            driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        return driverPool.get(); // same driver instance will be returned every time we call Driver.getDriver()

    }

    public static void closeDriver() {
        if (driverPool.get() != null)
            driverPool.get().quit();
            driverPool.remove();
    }

}
