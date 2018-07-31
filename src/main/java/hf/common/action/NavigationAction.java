package hf.common.action;

import hf.common.constants.Constants;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by AnkitNigam on 7/27/2018.
 */

public class NavigationAction extends AbstractBaseAction {
    private static final Logger logger = LoggerFactory.getLogger(NavigationAction.class);
    ButtonAction buttonAction;
    public NavigationAction() {
        this.buttonAction = new ButtonAction();
    }

    //Open URL in browser
    public boolean navigateToPage(String url){
        boolean flag = false;
        try{
            logger.info("Application URL: " + url);
            context.getRealDriver().get(url);
            context.getRealDriver().manage().window().maximize();
            context.getRealDriver().manage().timeouts().implicitlyWait(Constants.NAVIGATION_WAIT_TIMEOUT, TimeUnit.SECONDS);

            //Previous test failed and user already loggedIn
            try {
                context.setContextCurrentPage("Home");
                WebElement signOut  = context.getShortWait().until(ExpectedConditions.presenceOfElementLocated(context.getElementLocator("Logout")));
                logger.info("Signing out...");
                buttonAction.click("Logout");
            }catch (TimeoutException ex){
                //Skip
            }

            flag = true;
        }catch (Exception ex){
            logger.error("Error in navigating to URL: "+ url);
            logger.error(ex.getMessage());
            ex.printStackTrace();
        }finally {
            return flag;
        }
    }
}
