import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeSuite;
import hf.common.driver.DriverFactory;
import hf.common.repository.RepositoryContext;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import java.nio.file.Paths;

/**
 * Created by AnkitNigam on 7/27/2018.
 */
public class Hooks {
    public static WebDriver webDriver;

    @BeforeSuite
    public void stepUp(){
        PropertyConfigurator.configure(Paths.get(".") + "/src/log4j.properties");
        webDriver = DriverFactory.getWebDriver();
        RepositoryContext repositoryContext = RepositoryContext.getInstance();
        repositoryContext.setRepoPath(Paths.get(".") + System.getenv("REPOSITORY_PATH"));
        repositoryContext.loadRepository();

    }
    @AfterSuite
    public void tearDown(){
        webDriver.quit();
    }
}
