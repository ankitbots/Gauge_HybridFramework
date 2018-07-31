package hf.common.driver;

import com.google.common.io.Resources;
import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeSuite;
import hf.common.repository.RepositoryContext;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Paths;

/**
 * Created by AnkitNigam on 7/27/2018.
 */
public class Driver {
    public static WebDriver webDriver;
    private static final Logger logger = LoggerFactory.getLogger(Driver.class);

    @BeforeSuite
    public void stepUp(){
        DOMConfigurator.configure(Paths.get(".") + "/src/log4j.xml");

        logger.info("Initializing web driver");
        webDriver = DriverFactory.getWebDriver();
        RepositoryContext repositoryContext = RepositoryContext.getInstance();
        repositoryContext.setRepoPath(Paths.get(".") + System.getenv("REPOSITORY_PATH"));
        repositoryContext.loadRepository();

    }
    @AfterSuite
    public void tearDown(){
        try {
            logger.info("Closing webdriver");
            //close failed for firefox
            //webDriver.close();
            webDriver.quit();
        }catch (Exception ex){
            logger.error("Error in closing web driver");
            ex.printStackTrace();
        }
    }
}
