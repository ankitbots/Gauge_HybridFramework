package hf.common.action;

import com.thoughtworks.gauge.datastore.DataStore;
import com.thoughtworks.gauge.datastore.DataStoreFactory;
import hf.common.constants.Constants;
import io.restassured.response.Response;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;

import static io.restassured.RestAssured.given;


/**
 * Created by AnkitNigam on 7/29/2018.
 */

public class GetAction {
    private static final Logger logger = LoggerFactory.getLogger(GetAction.class);
    DataStore scenarioStore = DataStoreFactory.getScenarioDataStore();

    public boolean getResponse(String endPoint, String queryParameter) {
        boolean flag = false;

        logger.info("GET the response for " + endPoint);
        String baseUrl = System.getenv("BASE_URL");
        String jsonString = null;
        Response response = null;
        try {
            if (!StringUtils.isEmpty(baseUrl)) {

                //Finding endpoint based on the value passed in test case
                if (endPoint.equalsIgnoreCase("ALL_COUNTRIES")) {
                    endPoint = Constants.ALL_COUNTRIES;
                } else if (endPoint.equalsIgnoreCase("COUNTRY")) {
                    endPoint = Constants.COUNTRY;
                } else {
                    logger.info("Endpoint: " + endPoint + " not found in Contants list");
                    endPoint = null;
                }

                if (!StringUtils.isEmpty(endPoint)) {
                    //Concatenate base url with endpoint
                    String url = baseUrl + String.format(endPoint, queryParameter);
                    response = given()
                            .get(url);
                    if (response.statusCode() == HttpStatus.SC_OK) {
                        jsonString = response.getBody().asString();
                        logger.debug("Response successfully fetched");
                        scenarioStore.put("RESPONSE", jsonString);
                        flag = true;

                    } else if (response.statusCode() == HttpStatus.SC_BAD_REQUEST) {
                        logger.debug("Bad request");
                    } else {
                        logger.info("Request failed with status code: " + response.statusCode());
                    }
                }

            } else {
                logger.debug("Base url cannot be blank");
            }
        } catch (Exception ex) {
            logger.debug("Error in GET response");
            ex.printStackTrace();
        } finally {
            return flag;
        }
    }
}
