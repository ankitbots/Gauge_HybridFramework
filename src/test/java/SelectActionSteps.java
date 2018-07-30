import com.thoughtworks.gauge.Step;
import hf.common.action.SelectAction;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by AnkitNigam on 7/28/2018.
 */
public class SelectActionSteps {
    private static final Logger logger = LoggerFactory.getLogger(SelectActionSteps.class);
    private SelectAction selectAction;
    public SelectActionSteps() {
        this.selectAction = new SelectAction();
    }

    @Step("User select <name> with <byType> as <value>")
    public void setInput(String name, String byType, String value) throws Exception {
        boolean flag = false;
        try {
            logger.info("Select " + name + " by " + byType + " as " + value);
            flag = selectAction.setInput(name, byType, value);
            Assert.assertTrue("Failed to select filter: " + name + " for value: " + value, flag);
        } catch (AssertionError assertionError) {
            throw new Exception("Filter operation failed", assertionError);
        } catch (Exception ex) {
            throw new Exception("Error in filtering for object: " + name, ex);
        }
    }
}
