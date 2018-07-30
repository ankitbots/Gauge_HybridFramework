import com.thoughtworks.gauge.Step;
import hf.common.action.LinkCheckboxRadioClickAction;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by AnkitNigam on 7/27/2018.
 */
public class LinkCheckboxRadioClickActionSteps {
    private static final Logger logger = LoggerFactory.getLogger(LinkCheckboxRadioClickActionSteps.class);

    private LinkCheckboxRadioClickAction linkCheckboxRadioClickAction;
    public LinkCheckboxRadioClickActionSteps() {
        this.linkCheckboxRadioClickAction = new LinkCheckboxRadioClickAction();
    }

    @Step({"User click <name> link","User click <name> checkbox","User click <name> radio button"})
    public void click(String name) throws Exception {
        boolean flag = false;
        try {
            logger.info("Clicking object " + name);
            flag = linkCheckboxRadioClickAction.click(name);
            Assert.assertTrue("Failed to click link: " + name, flag);
        } catch (AssertionError assertionError) {
            throw new Exception("Linlick operation failed", assertionError);
        } catch (Exception ex) {
            throw new Exception("Error in clicking link: " + name, ex);
        }
    }
}
