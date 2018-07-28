package hf.common.action;

import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.datastore.DataStore;
import com.thoughtworks.gauge.datastore.DataStoreFactory;
import hf.common.utils.RandGenerator;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by AnkitNigam on 07/28/2018.
 */

public class TypeAction extends AbstractBaseAction implements IInputAction {
    private static final Logger logger = LoggerFactory.getLogger(TypeAction.class);
    DataStore scenarioStore = DataStoreFactory.getScenarioDataStore();

    @Override
    public boolean setInput(String name, String... value) {
        boolean flag = false;
        try{
            logger.info("Enter text " + value[0] + " in field " + name);
            if(name.toLowerCase().contains("NewEmailAddress")){
                value[0] = RandGenerator.getRandString("EMAIL",15,value[0].replace("@",""));
                scenarioStore.put("EMAIL", value[0]);
                Gauge.writeMessage("Email Address: " + value[0]);
            }else if(name.equalsIgnoreCase("FirstName")){scenarioStore.put("FIRST_NAME", value[0]);}
            else if(name.equalsIgnoreCase("LastName")){scenarioStore.put("LAST_NAME", value[0]);}

            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(context.getElementLocator(name)));
            element.sendKeys(value[0]);
            flag = true;
            logger.debug("Successfully able to enter value: " + value[0]);
        }catch (TimeoutException ex){
            logger.error("TimeoutException -  Unable to find textbox: " + name);
        }
        catch (Exception ex){
            logger.error("Error in entering a value in textbox: " + name);
            ex.printStackTrace();
        }finally {
            return flag;
        }
    }
}
