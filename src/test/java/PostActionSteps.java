import com.thoughtworks.gauge.Step;
import hf.common.action.PostAction;
import org.junit.Assert;
/**
 * Created by AnkitNigam on 7/29/2018.
 */
public class PostActionSteps {

    public PostAction postAction;
    public PostActionSteps() {
        this.postAction = new PostAction();
    }

    @Step("User create <endpoint> with <NewCountryName>,<Alpha2Code>,<Alpha3Code>")
    public void addNewCountryActionSteps(String endpoint, String newCountryName, String alpha2Code, String alpha3Code) throws Exception {
        boolean flag = false;
        try {
            flag = postAction.addNewCountry(endpoint, newCountryName, alpha2Code, alpha3Code);
            Assert.assertTrue("Unable to add new country", flag);
        } catch (AssertionError assertionError) {
            throw new Exception("Create new country operation failed", assertionError);
        } catch (Exception ex) {
            throw new Exception("Error in creating new country", ex);
        }
    }
}
