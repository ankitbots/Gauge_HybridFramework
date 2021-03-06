package hf.common.action;


import hf.common.constants.Constants;
import hf.common.utils.Highlight;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by AnkitNigam on 07/28/2018.
 */

public class LinkCheckboxRadioClickAction extends AbstractBaseAction implements IClickAction {
    private static final Logger logger = LoggerFactory.getLogger(LinkCheckboxRadioClickAction.class);
//    @Override
//    public boolean click(String name) {
//        WebElement element;
//        boolean flag = false;
//        logger.info("Clicking link: " + name);
//        try {
//            element = wait.until(ExpectedConditions.visibilityOfElementLocated(context.getElementLocator(name)));
//            Highlight.elementHighlight(context.getRealDriver(), element);
//            element.click();
//            flag = true;
//        } catch (TimeoutException e) {
//            logger.debug("Timeout Exception: Unable to find object: " + name);
//            e.printStackTrace();
//        } catch (Exception ex) {
//            logger.error("Error in clicking link object: " + name);
//            logger.debug(ex.getMessage());
//            ex.printStackTrace();
//
//        }
//        return flag;
//    }

    public boolean click(String name) {
        WebElement element;
        Long startTime = System.currentTimeMillis();
        boolean flag = false;
        try {
            while ((System.currentTimeMillis() - startTime) < Constants.STALE_ELEMENT_WAIT_TIMEOUT * 1000L) {
                try {
                    element = wait.until(ExpectedConditions.visibilityOfElementLocated(context.getElementLocator(name)));
                    if (element.isEnabled()) {
                        Highlight.elementHighlight(context.getRealDriver(), element);
                        logger.info("Object " + name + " found");
                        element.click();
                        logger.info("Object " + name + " clicked");
                        flag = true;
                        break;
                    } else {
                        element = null;
                        logger.debug("Waiting for the " + name + " to load...");
                        Thread.sleep(2000);
                    }
                } catch (StaleElementReferenceException e) {
                    logger.debug("Stale Exception: Trying to recover it...");
                } catch (TimeoutException e) {
                    logger.debug("Timeout Exception: Unable to find object: " + name);
                }
            }
        }catch (Exception ex) {
            logger.error("Error in clicking the object: " + name);
            logger.debug(ex.getMessage());
            ex.printStackTrace();
        }finally {
            return flag;
        }

    }
}
