import com.thoughtworks.gauge.Step;
import hf.common.action.ButtonAction;
import org.junit.Assert;

/**
 * Created by AnkitNigam on 7/27/2018.
 */
public class ButtonActionSteps {

    public ButtonAction buttonAction;
    public ButtonActionSteps() {
        this.buttonAction = new ButtonAction();
    }

    @Step("User click <name> button")
    public void click(String name) throws Exception {
        boolean flag = false;
        try {
            flag = buttonAction.click(name);
            Assert.assertTrue("Failed to click: " + name, flag);
        } catch (AssertionError assertionError) {
            throw new Exception("Click operation failed", assertionError);
        } catch (Exception ex) {
            throw new Exception("Error in clicking: " + name, ex);
        }
    }
}
