package hf.common.context;

import hf.common.constants.Constants;
import hf.common.driver.DriverFactory;
import hf.common.repository.DataNotFoundInRepoExecption;
import hf.common.repository.PageElement;
import hf.common.repository.RepositoryContext;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by AnkitNigam on 7/27/2018.
 */
public class WebPageContext implements IWebPageContext {
    private static final Logger logger = LoggerFactory.getLogger(WebPageContext.class);
    private static WebDriverWait wait;
    private static WebPageContext webPageContext;
    private WebPageContext(){}
    public static WebPageContext getInstance(){
        if (webPageContext==null){
            webPageContext = new WebPageContext();
        }
        return webPageContext;
    }

    private RepositoryContext repository = RepositoryContext.getInstance();
    private ExpectedCondition<Boolean> document_readyState_toBeComplete = new ExpectedCondition<Boolean>() {
        public Boolean apply(WebDriver webDriver) {
            return Boolean.valueOf(((JavascriptExecutor)DriverFactory.getWebDriver()).executeScript("return document.readyState", new Object[0]).toString().equalsIgnoreCase("complete"));
        }
    };

    @Override
    public By getElementLocator(String elementName) {
        By locElement = null;
        try {
            PageElement element = this.repository.getElement(elementName);
            locElement = this.getLocator(element);
        } catch (DataNotFoundInRepoExecption dataNotFoundInRepoExecption) {
            dataNotFoundInRepoExecption.printStackTrace();
        }finally {
            return locElement;
        }
    }

    @Override
    public WebDriver getRealDriver() {
        return DriverFactory.getWebDriver();
    }

    @Override
    public WebDriverWait getWait() {
        if (wait==null){
            wait = new WebDriverWait(DriverFactory.getWebDriver(), Constants.WAIT_TIMEOUT);
        }
        return wait;
    }

    @Override
    public void waitForCurrentPageLoad() throws Exception {
        wait.until(this.document_readyState_toBeComplete);
    }

    @Override
    public void setContextCurrentPage(String pageName) {
        this.repository.setContextCurrentPage(pageName);
    }

    private By getLocator(PageElement element) throws DataNotFoundInRepoExecption {
        logger.debug("Locating element: " + element);
        if (element.getLocatorType().equalsIgnoreCase("name")){return By.name(element.getLocator());}
        else if (element.getLocatorType().equalsIgnoreCase("id")){return By.id(element.getLocator());}
        else if (element.getLocatorType().equalsIgnoreCase("xpath")){return By.xpath(element.getLocator());}
        else if (element.getLocatorType().equalsIgnoreCase("className")){return By.className(element.getLocator());}
        else if (element.getLocatorType().equalsIgnoreCase("partialLinkText")){return By.partialLinkText(element.getLocator());}
        else if (element.getLocatorType().equalsIgnoreCase("linkText")){return By.linkText(element.getLocator());}
        else if (element.getLocatorType().equalsIgnoreCase("css")){return By.cssSelector(element.getLocator());}
        else {throw new DataNotFoundInRepoExecption("Locator not found for webelement " + element);}
    }
}
