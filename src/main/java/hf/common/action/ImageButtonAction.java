package hf.common.action;


import hf.common.utils.Highlight;
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
        logger.info("Clicking image button: " + name);
        try {
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(context.getElementLocator(name)));
            Actions actions = new Actions(context.getRealDriver());
            actions.moveToElement(element).build().perform();
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
