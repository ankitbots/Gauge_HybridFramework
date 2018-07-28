import com.thoughtworks.gauge.Step;
import hf.common.action.LinkAction;
import org.junit.Assert;

/**
 * Created by AnkitNigam on 7/27/2018.
 */
public class LinkActionSteps {

    public LinkAction linkAction;
    public LinkActionSteps() {
        this.linkAction = new LinkAction();
    }

    @Step({"User click <name> link","User click <name> checkbox","User click <name> radio button"})
    public void click(String name) throws Exception {
        boolean flag = false;
        try {
            flag = linkAction.click(name);
            Assert.assertTrue("Failed to click link: " + name, flag);
        } catch (AssertionError assertionError) {
            throw new Exception("Link click operation failed", assertionError);
        } catch (Exception ex) {
            throw new Exception("Error in clicking link: " + name, ex);
        }
    }
}
