import com.thoughtworks.gauge.Step;
import hf.common.action.ImageButtonAction;
import org.junit.Assert;

/**
 * Created by AnkitNigam on 7/27/2018.
 */
public class ImageButtonActionSteps {

    public ImageButtonAction imageButtonAction;
    public ImageButtonActionSteps() {
        this.imageButtonAction = new ImageButtonAction();
    }

    @Step("User click <name> image")
    public void click(String name) throws Exception {
        boolean flag = false;
        try {
            flag = imageButtonAction.click(name);
            Assert.assertTrue("Failed to click image button: " + name, flag);
        } catch (AssertionError assertionError) {
            throw new Exception("Image button click operation failed", assertionError);
        } catch (Exception ex) {
            throw new Exception("Error in clicking image button: " + name, ex);
        }
    }
}
