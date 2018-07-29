Test to create and validate new country
=====================
Created by NONF on 7/29/2018

This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.

//alpha2_code = TC alreay exist

Create and validate new country - LO
----------------
* User create "NEW_COUNTRY" with "Test Country","LO","TCY"
* User get "COUNTRY" as "LO"
* Verify "Test Country" with "COUNTRY_NAME_PATH" present in response
* Verify "LO" with "COUNTRY_ALPHA2_PATH" present in response
* Verify "TCY" with "COUNTRY_ALPHA3_PATH" present in response

