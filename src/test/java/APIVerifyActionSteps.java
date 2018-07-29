import com.thoughtworks.gauge.Step;
import hf.common.action.APIVerifyAction;
import org.junit.Assert;

/**
 * Created by AnkitNigam on 7/29/2018.
 */
public class APIVerifyActionSteps {
    public APIVerifyAction apiVerifyAction;

    public APIVerifyActionSteps() {
        this.apiVerifyAction = new APIVerifyAction();
    }

    @Step("Verify <value> with <jsonPath> present in response")
    public void verifyValuePresentInResponseActionStep(String value, String jsonPath) throws Exception {
        boolean flag = false;
        try {
            //Verify object value available in response
            flag = apiVerifyAction.verifyValuePresentInResponseAction(value, jsonPath);
            Assert.assertTrue("Unable to find: " + value + " in response", flag);
        } catch (AssertionError assertionError) {
            throw new Exception(value + " not returned", assertionError);
        } catch (Exception ex) {
            throw new Exception("Error in finding: " + value, ex);
        }

    }
}
