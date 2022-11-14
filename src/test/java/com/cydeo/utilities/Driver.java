package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
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

        if (driverPool.get() == null) { // if driver browser was never opened
            String browserType;
            if (System.getProperty("BROWSER") == null){
                browserType=ConfigurationReader.getProperty("browser");
            }else{
                browserType=System.getProperty("BROWSER");
            }

            switch (browserType) {
                case "remote-chrome":
                    try {
                        // assign your grid server address
                        String gridAddress = "18.213.2.252";
                        URL url = new URL("http://"+ gridAddress + ":4444/wd/hub");
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("chrome");
                        driverPool.set(new RemoteWebDriver(url, desiredCapabilities));
                        //driverPool.set(new RemoteWebDriver(new URL("http://0.0.0.0:4444/wd/hub"),desiredCapabilities));

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "remote-firefox":
                    try {
                        // assign your grid server address
                        String gridAddress = "18.213.2.252";
                        URL url = new URL("http://"+ gridAddress + ":4444/wd/hub");
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("firefox");
                        driverPool.set(new RemoteWebDriver(url, desiredCapabilities));
                        //driverPool.set(new RemoteWebDriver(new URL("http://0.0.0.0:4444/wd/hub"),desiredCapabilities));

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

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
