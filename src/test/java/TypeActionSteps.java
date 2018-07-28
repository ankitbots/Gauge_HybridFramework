import com.thoughtworks.gauge.Step;
import hf.common.action.TypeAction;
import org.junit.Assert;

/**
 * Created by AnkitNigam on 7/28/2018.
 */
public class TypeActionSteps {
    public TypeAction typeAction;
    public TypeActionSteps(){
        typeAction = new TypeAction();
    }

    @Step("User enter <objName> as <value>")
    public void setInput(String objName, String value) throws Exception {
        boolean flag = false;
        try {
            flag = typeAction.setInput(objName, value);
            Assert.assertTrue("Failed to enter value: " + value + " in field: " + objName, flag);
        } catch (AssertionError assertionError) {
            throw new Exception("Text enter operation failed", assertionError);
        } catch (Exception ex) {
            throw new Exception("Error in entering the text for object: " + objName, ex);
        }
    }
}
