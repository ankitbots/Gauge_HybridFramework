
import com.thoughtworks.gauge.Step;
import hf.common.action.NavigationAction;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by AnkitNigam on 7/27/2018.
 */
public class NavigationActionStep {


    public NavigationAction navigationAction;
    public NavigationActionStep(){
        navigationAction = new NavigationAction();
    }

    private static final Logger logger = LoggerFactory.getLogger(NavigationActionStep.class);

    @Step("User Navigate to application home")
    public void userNavigateToApplicationHome() throws Exception {
        boolean flag = false;
        try{
            String url = System.getenv("APP_URL");
            System.out.println(url);
            if (!StringUtils.isEmpty(url)){
                flag = navigationAction.navigateToPage(url);
            }else {
                flag = false;
            }
            Assert.assertTrue("Unable to navigate to URL: " + url, flag);
        }catch (AssertionError assertionError){
            throw new Exception("Navigation to url failed", assertionError);
        }catch (Exception ex){
            throw new Exception("Error in navigating to url", ex);
        }
    }
}
