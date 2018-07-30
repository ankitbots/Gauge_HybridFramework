package hf.common.action;

import com.thoughtworks.gauge.datastore.DataStore;
import com.thoughtworks.gauge.datastore.DataStoreFactory;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by AnkitNigam on 07/27/2018.
 */


public class VerifyAction extends AbstractBaseAction {
    private static final Logger logger = LoggerFactory.getLogger(VerifyAction.class);
    DataStore scenarioStore = DataStoreFactory.getScenarioDataStore();

    public boolean verifyObjectExists(String name){
        boolean flag = false;
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(context.getElementLocator(name)));
            logger.info("Object found: " + name);
            flag = true;
        }catch (TimeoutException e){
            logger.error("TimeoutException - Object not found: " + name);
        }catch (Exception ex){
            logger.error("Error in finding object " + name);
            ex.printStackTrace();
        }finally {
            return flag;
        }
    }


    public boolean verifyTextDisplayingAction(String name, String expectedValue) {
        boolean flag = false;
        String actualValue = null;
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(context.getElementLocator(name)));
            logger.info("Object found: " + name);
            actualValue = element.getText().trim();
            if(expectedValue.equalsIgnoreCase("COMPLETE_NAME")){
                expectedValue = (String) scenarioStore.get("FIRST_NAME") + " " + (String) scenarioStore.get("LAST_NAME");
            }
            if (actualValue.equals(expectedValue)){
                logger.info("Expected text found");
                flag = true;
            }else {
                logger.info("Expected text not found on the page");
                logger.info("Actual Value: " + actualValue);
                flag = false;
            }
        }catch (TimeoutException e){
            logger.error("TimeoutException - Object not found: " + name);
            e.printStackTrace();
        }catch (Exception ex){
            logger.error("Error in finding object " + name);
            ex.printStackTrace();
        }finally {
            return flag;
        }
    }


    public boolean verifyPageAndSetContext(String pageName) {
        boolean flag = false;
        try {
            logger.info("Waiting of page to load...");
            context.waitForCurrentPageLoad();
            logger.info("Setting the page context as " + pageName);
            context.setContextCurrentPage(pageName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(context.getElementLocator(pageName)));
            logger.info("Page found: " + pageName);
            flag = true;
        }catch (TimeoutException e){
            logger.error("TimeoutException - Page not found: " + pageName);
            e.printStackTrace();
        }catch (Exception ex){
            logger.error("Error in finding Page " + pageName);
            ex.printStackTrace();
        }finally {
            return flag;
        }
    }

    public boolean verifyTextDisplayingContainsAction(String objName, String expectedValue) {
        boolean flag = false;
        String actualValue = null;
        try {
            if(objName.equalsIgnoreCase("url")){
                actualValue = context.getRealDriver().getCurrentUrl();
                logger.info("Current URL: " + actualValue);
            }else {
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(context.getElementLocator(objName)));
                logger.info("Object found: " + objName);
                actualValue = element.getText().trim();
            }
            if (actualValue.contains(expectedValue)){
                logger.info("Expected sub-text found");
                flag = true;
            }else {
                logger.info("Expected sub-text not found in the object");
                flag = false;
            }
        }catch (TimeoutException e){
            logger.error("TimeoutException - Object not found: " + objName);
            e.printStackTrace();
        }catch (Exception ex){
            logger.error("Error in finding object " + objName);
            ex.printStackTrace();
        }finally {
            return flag;
        }
    }
}
