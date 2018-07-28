package hf.common.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Paths;

/**
 * Created by AnkitNigam on 7/27/2018.
 */
public class DriverFactory {
    private static final Logger logger = LoggerFactory.getLogger(DriverFactory.class);
    private static WebDriver driver = null;

    public static WebDriver getWebDriver() {
        if (driver == null) {
            try {
                String browser = System.getenv("BROWSER");
                if (browser==null){browser="chrome";}

                switch (browser.toUpperCase()) {
                    case "IE":
                        //Launch IE browser
                        logger.info("Launching IE browser ");
                        System.setProperty("webdriver.ie.driver", Paths.get(".").toAbsolutePath().normalize().toString() + "/drivers/iedriver/IEDriverServer.exe");
                        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
                        //Disable protection mode
                        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                        InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions(capabilities);
                        driver = new InternetExplorerDriver(internetExplorerOptions);
                    case "FIREFOX":
                        //Launch Firefox browser
                        logger.info("Launching FireFox browser ");
                        System.setProperty("webdriver.gecko.driver", Paths.get(".").toAbsolutePath().normalize().toString() + "/drivers/geckodriver/geckodriver.exe");
                        driver = new FirefoxDriver();

                    default:
                        //Launch Chrome browser
                        logger.info("Launching Chrome browser");
                        System.setProperty("webdriver.chrome.driver", Paths.get(".").toAbsolutePath().normalize().toString() + "/drivers/chromedriver/chromedriver.exe");
                        driver = new ChromeDriver();
                }
            } catch (Exception ex) {
                logger.error("Error in launching browser");
                ex.printStackTrace();
            }
        }
        return driver;
    }


}



