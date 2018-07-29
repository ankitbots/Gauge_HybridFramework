package hf.common.context;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



/**
 * Created by AnkitNigam on 07/27/2018.
 */
public interface IWebPageContext {
    By getElementLocator(String var1);
    WebDriver getRealDriver();
    WebDriverWait getWait();
    WebDriverWait getShortWait();
    void waitForCurrentPageLoad() throws Exception;
    void setContextCurrentPage(String var1);
}
