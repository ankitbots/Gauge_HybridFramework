package hf.common.action;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by AnkitNigam on 07/28/2018.
 */

public class SelectAction extends AbstractBaseAction implements IInputAction {
    private static final Logger logger = LoggerFactory.getLogger(SelectAction.class);

    @Override
    public boolean setInput(String name, String... value) {
        boolean flag = false;
        try{
            logger.info("Select dropdown " + name + " as " + value[0]);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(context.getElementLocator(name)));
            Select dropdown = new Select(element);
            if(value[0].equalsIgnoreCase("text")) {
                logger.info("Selecting by text");
                dropdown.selectByVisibleText(value[1]);
            }else if(value[0].equalsIgnoreCase("value")) {
                logger.info("Selecting by value");
                dropdown.selectByValue(value[1]);
            }
            flag = true;
            logger.debug("Successfully able to select value: " + value[0]);
        }catch (TimeoutException ex){
            logger.error("TimeoutException -  Unable to find object: " + name);
        }
        catch (Exception ex){
            logger.error("Error in selecting a value from dropdown " + name);
            ex.printStackTrace();
        }finally {
            return flag;
        }
    }
}
