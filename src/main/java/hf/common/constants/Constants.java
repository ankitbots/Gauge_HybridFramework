package hf.common.constants;

/**
 * Created by AnkitNigam on 07/27/2018.
 */
public class Constants {
    //General hf.common.constants
    public static final long WAIT_TIMEOUT = 10;
    public static final long STALE_ELEMENT_WAIT_TIMEOUT = 15;
    public static final long NAVIGATION_WAIT_TIMEOUT = 5 ;
    public static final long SHORT_WAIT_TIMEOUT = 2 ;

    //API endpoints
    public static final String ALL_COUNTRIES="/get/all";
    public static final String COUNTRY="/get/iso2code/%s";
    public static final String ADD_NEW_COUNTRY ="/post/addnewcountry";

    //JSONPATH
    public static final String COUNTRIES_ALPHA2_PATH="RestResponse.result.findAll{result->result.alpha2_code=='%s'}.size()==1";
    public static final String MESSAGE_PATH="RestResponse.messages[0]=='%s'";
    public static final String COUNTRY_NAME_PATH="RestResponse.result.name=='%s'";
    public static final String COUNTRY_ALPHA2_PATH="RestResponse.result.alpha2_code=='%s'";
    public static final String COUNTRY_ALPHA3_PATH="RestResponse.result.alpha3_code=='%s'";

}
