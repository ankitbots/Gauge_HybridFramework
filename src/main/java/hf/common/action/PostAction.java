package hf.common.action;

import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.datastore.DataStore;
import com.thoughtworks.gauge.datastore.DataStoreFactory;
import hf.common.constants.Constants;
import hf.common.utils.JSONParser;
import io.restassured.response.Response;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

import static io.restassured.RestAssured.given;


/**
 * Created by AnkitNigam on 7/29/2018.
 */

public class PostAction {
    private static final Logger logger = LoggerFactory.getLogger(PostAction.class);

    public boolean addNewCountry(String endPoint, String newCountryName, String alpha2Code, String alpha3Code) {
        boolean flag = false;
        String baseUrl = System.getenv("BASE_URL");
        Response response = null;
        String jsonBody = null;
        try {
            if (!StringUtils.isEmpty(baseUrl)) {
                //Finding endpoint based on the value passed in test case
                if (endPoint.equalsIgnoreCase("NEW_COUNTRY")) {
                    endPoint = Constants.ADD_NEW_OUNTRY;
                }

                if (!StringUtils.isEmpty(endPoint)) {
                    //Concatenate base url with endpoint
                    String url = baseUrl + endPoint;
                    logger.info("Post URL: " + url);
                    jsonBody = JSONParser.getAddNewCountryJson(newCountryName,alpha2Code,alpha3Code);

                    HashMap<String,String> headers = new HashMap<>();
                    headers.put(HttpHeaders.CONTENT_TYPE,"application/json; charset=UTF-8");
                    headers.put(HttpHeaders.ACCEPT,"application/json");
                    Gauge.writeMessage(jsonBody);
                    response = given()
                            .headers(headers)
                            .body(jsonBody)
                            .post(url);

                    if (response.statusCode() == HttpStatus.SC_CREATED) {
                        logger.debug("New country successfully added");
                        logger.info("Request body: " + response.getBody().asString());
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
            logger.debug("Error in adding new country");
            ex.printStackTrace();
        } finally {
            return flag;
        }
    }
}
