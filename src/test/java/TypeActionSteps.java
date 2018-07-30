import com.thoughtworks.gauge.Step;
import hf.common.action.TypeAction;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by AnkitNigam on 7/28/2018.
 */
public class TypeActionSteps {
    private static final Logger logger = LoggerFactory.getLogger(TypeActionSteps.class);
    private TypeAction typeAction;
    public TypeActionSteps(){
        typeAction = new TypeAction();
    }

    @Step("User enter <objName> as <value>")
    public void setInput(String objName, String value) throws Exception {
        boolean flag = false;
        try {
            logger.info("Entering text " + value + " in textbox " + objName);
            flag = typeAction.setInput(objName, value);
            Assert.assertTrue("Failed to enter value: " + value + " in field: " + objName, flag);
        } catch (AssertionError assertionError) {
            throw new Exception("Text enter operation failed", assertionError);
        } catch (Exception ex) {
            throw new Exception("Error in entering the text for object: " + objName, ex);
        }
    }
}
