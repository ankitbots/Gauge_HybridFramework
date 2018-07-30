package hf.common.action;

import com.thoughtworks.gauge.datastore.DataStore;
import com.thoughtworks.gauge.datastore.DataStoreFactory;
import hf.common.constants.Constants;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by AnkitNigam on 7/29/2018.
 */
public class APIVerifyAction {
    DataStore scenarioStore = DataStoreFactory.getScenarioDataStore();
    private static final Logger logger = LoggerFactory.getLogger(APIVerifyAction.class);

    public boolean verifyValuePresentInResponseAction(String expectedValue, String jsonPath) {
        boolean flag = false;
        String responseString = null;
        String fullJsonPath = null;
        logger.info("Checking expected value " + expectedValue + " available in response");
        try {
            responseString = (String) scenarioStore.get("RESPONSE");

            if (jsonPath.equalsIgnoreCase("MESSAGE_PATH")) {
                fullJsonPath = String.format(Constants.MESSAGE_PATH, expectedValue);
            } else if (jsonPath.equalsIgnoreCase("COUNTRY_NAME_PATH")) {
                fullJsonPath = String.format(Constants.COUNTRY_NAME_PATH, expectedValue);
            } else if (jsonPath.equalsIgnoreCase("COUNTRY_ALPHA2_PATH")) {
                fullJsonPath = String.format(Constants.COUNTRY_ALPHA2_PATH, expectedValue);
            } else if (jsonPath.equalsIgnoreCase("COUNTRY_ALPHA3_PATH")) {
                fullJsonPath = String.format(Constants.COUNTRY_ALPHA3_PATH, expectedValue);
            }else if (jsonPath.equalsIgnoreCase("COUNTRIES_ALPHA2_PATH")) {
                fullJsonPath = String.format(Constants.COUNTRIES_ALPHA2_PATH, expectedValue);
            }

            if (!StringUtils.isEmpty(responseString) && !StringUtils.isEmpty(fullJsonPath)) {
                flag = JsonPath.from(responseString).get(fullJsonPath).equals(true);
                logger.info( flag ? expectedValue + "' available in response" : expectedValue + "' not available in response" );
            } else {
                logger.info("Response body or jsonpath cannot be empty");
            }

        } catch (Exception ex) {
            logger.error("Error in finding " + expectedValue + " in response");
            ex.printStackTrace();
        } finally {
            return flag;
        }
    }
}
