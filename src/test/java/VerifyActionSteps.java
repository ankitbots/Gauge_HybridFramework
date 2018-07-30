import com.thoughtworks.gauge.Step;
import hf.common.action.VerifyAction;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by AnkitNigam on 7/27/2018.
 */
public class VerifyActionSteps {

    private static final Logger logger = LoggerFactory.getLogger(VerifyActionSteps.class);
    private VerifyAction verifyAction;
    public VerifyActionSteps() {
        this.verifyAction = new VerifyAction();
    }

    @Step("User on <pageName> page")
    public void verifyOnPageActionSteps(String pageName) throws Exception {
        boolean flag = false;
        try {
            System.out.println(System.getProperty("browser"));
            logger.info("Verifying the " + pageName);
            flag = verifyAction.verifyPageAndSetContext(pageName);
            Assert.assertTrue("Page not found: " + pageName, flag);
        } catch (AssertionError assertionError) {
            throw new Exception("Page not found: " + pageName, assertionError);
        } catch (Exception ex) {
            throw new Exception("Error in finding Page: " + pageName, ex);
        }
    }

    @Step("<objName> as <CustomerName> displaying")
    public void verifyTextDisplayingActionStep(String objName, String value) throws Exception {
        boolean flag = false;
        try {
            logger.info("Verifying object " + objName + " has value " + value);
            flag = verifyAction.verifyTextDisplayingAction(objName, value);
            Assert.assertTrue("Unable to find the text: " + value, flag);
        } catch (AssertionError assertionError) {
            throw new Exception("Text not available", assertionError);
        } catch (Exception ex) {
            throw new Exception("Error in finding text: " + value, ex);
        }
    }

    @Step("<objName> contains <value>")
    public void verifyTextDisplayingContainsActionStep(String objName, String value) throws Exception {
        boolean flag = false;
        try {
            logger.info("Verifying object " + objName + " contains value " + value);
            flag = verifyAction.verifyTextDisplayingContainsAction(objName, value);
            Assert.assertTrue("Unable to find text: " + value, flag);
        } catch (AssertionError assertionError) {
            throw new Exception("Sub-Text not available", assertionError);
        } catch (Exception ex) {
            throw new Exception("Error in finding text: " + value, ex);
        }
    }

    @Step("<objName> is displaying")
    public void verifyObjectExistsActionStep(String objName) throws Exception {
        boolean flag = false;
        try {
            logger.info("Verifying object " + objName + " exist");
            //Verify object available on page
            flag = verifyAction.verifyObjectExists(objName);
            Assert.assertTrue("Unable to find the object: " + objName, flag);
        } catch (AssertionError assertionError) {
            throw new Exception("Object not available", assertionError);
        } catch (Exception ex) {
            throw new Exception("Error in finding object: " + objName, ex);
        }
    }
}
