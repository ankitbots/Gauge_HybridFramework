Test to validate countries US,DE and GB in response
=====================
Created by NONF on 7/29/2018

'''''Can use external table also like
'''''<CountryCode> with "COUNTRY_PATH" present in response

Validate countries US,DE and GB in response
----------------
tags: allCountries

* User get "All_Countries"
* Verify "US" with "COUNTRIES_ALPHA2_PATH" present in response
* Verify "DE" with "COUNTRIES_ALPHA2_PATH" present in response
* Verify "GB" with "COUNTRIES_ALPHA2_PATH" present in response
