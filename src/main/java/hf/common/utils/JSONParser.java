package hf.common.utils;

import hf.common.apipojo.NewCountry;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by AnkitNigam on 07/29/2018.
 */
public class JSONParser {
    private static final Logger logger = LoggerFactory.getLogger(JSONParser.class);

    public static String getAddNewCountryJson(String newCountryName, String alpha2Code, String alpha3Code){
        String newCountryJson = null;
        ObjectMapper mapper = null;
        try{
            logger.info("Creating new country json");
            NewCountry newCountry = new NewCountry();
            newCountry.setName(newCountryName);
            newCountry.setAlpha2Code(alpha2Code);
            newCountry.setAlpha3Code(alpha3Code);
            mapper = new ObjectMapper();
            newCountryJson = mapper.writeValueAsString(newCountry);

            logger.info("Generate JSON: " + newCountryJson);

        }catch (Exception e){
            logger.error("Error in generating new country json");
            e.printStackTrace();
        }finally {
            return newCountryJson;
        }
    }


}
