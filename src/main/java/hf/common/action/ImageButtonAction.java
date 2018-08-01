package hf.common.action;


import hf.common.utils.Highlight;
import hf.common.utils.PropertiesHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by AnkitNigam on 07/28/2018.
 */

public class ImageButtonAction extends AbstractBaseAction implements IClickAction {
    private static final Logger logger = LoggerFactory.getLogger(ImageButtonAction.class);
    @Override
    public boolean click(String name) {
        WebElement element;
        boolean flag = false;
        String browser = System.getenv("BROWSER");
        //String browser = PropertiesHelper.getPropertyValue("app_browser");
        logger.info("Clicking image button: " + name);
        try {
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(context.getElementLocator(name)));

            //Actions are not working on firefox
            if(browser.equalsIgnoreCase("firefox") || browser.equalsIgnoreCase("ie")) {
                String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); " +
                        "arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
                ((JavascriptExecutor) context.getRealDriver()).executeScript(mouseOverScript,
                        element);
            }else {
                Actions actions = new Actions(context.getRealDriver());
                actions.moveToElement(element).build().perform();
            }

            element.click();
            flag = true;
        } catch (TimeoutException e) {
            logger.debug("Timeout Exception: Unable to find object: " + name);
        } catch (Exception ex) {
            logger.error("Error in clicking the object: " + name);
            logger.debug(ex.getMessage());
            ex.printStackTrace();

        }
        return flag;
    }
}
