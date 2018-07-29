Test to validate countries US,DE and GB in response individually
=====================
Created by NONF on 7/29/2018

table:src/test/resources/TestData/countryData.csv
     
Validate countries US,DE and GB in response individually
----------------
tags: individualCountry

* User get "COUNTRY" as <CountryISO2Code>
* Verify <Resopnse_Messages> with "MESSAGE_PATH" present in response
* Verify <Name> with "COUNTRY_NAME_PATH" present in response
* Verify <Alpha2_Code> with "COUNTRY_ALPHA2_PATH" present in response
* Verify <Alpha3_Code> with "COUNTRY_ALPHA3_PATH" present in response