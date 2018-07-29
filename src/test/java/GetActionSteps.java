import com.thoughtworks.gauge.Step;
import hf.common.action.GetAction;
import org.junit.Assert;

/**
 * Created by AnkitNigam on 7/29/2018.
 */
public class GetActionSteps {
    public GetAction getAction;

    public GetActionSteps() {
        this.getAction = new GetAction();
    }

    @Step("User get <endPoint>")
    public void getResponseActionSteps(String endPoint) throws Exception {
        boolean flag = false;
        try {
            flag = getAction.getResponse(endPoint, null);
            Assert.assertTrue("Unable to get valid response for request: " + endPoint, flag);
        } catch (AssertionError assertionError) {
            throw new Exception("GET operation failed", assertionError);
        } catch (Exception ex) {
            throw new Exception("Error in GET operation", ex);
        }
    }

    @Step("User get <endPoint> as <queryParameter>")
    public void getResponseQueryParameterActionSteps(String endPoint, String queryParameter) throws Exception {
        boolean flag = false;
        try {
            flag = getAction.getResponse(endPoint, queryParameter);
            Assert.assertTrue("Unable to get valid response for request: " + endPoint, flag);
        } catch (AssertionError assertionError) {
            throw new Exception("GET operation failed", assertionError);
        } catch (Exception ex) {
            throw new Exception("Error in GET operation", ex);
        }

    }
}
