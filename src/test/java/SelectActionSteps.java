import com.thoughtworks.gauge.Step;
import hf.common.action.SelectAction;
import org.junit.Assert;

/**
 * Created by AnkitNigam on 7/28/2018.
 */
public class SelectActionSteps {
    public SelectAction selectAction;

    public SelectActionSteps() {
        this.selectAction = new SelectAction();
    }

    @Step("User select <name> with <byType> as <value>")
    public void setInput(String name, String byType, String value) throws Exception {
        boolean flag = false;
        try {
            flag = selectAction.setInput(name, byType, value);
            Assert.assertTrue("Failed to select filter: " + name + " for value: " + value, flag);
        } catch (AssertionError assertionError) {
            throw new Exception("Filter operation failed", assertionError);
        } catch (Exception ex) {
            throw new Exception("Error in filtering for object: " + name, ex);
        }
    }
}
