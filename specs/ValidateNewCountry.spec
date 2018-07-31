Test to create and validate new country
=====================
Created by NONF on 7/29/2018

This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.

//alpha2_code = TC alreay exist

Create and validate new country - LO
----------------
tags: addNewCountry

* User create "NEW_COUNTRY" with "Test Country","LO","TCY"
* User get "COUNTRY" as "LO"
* Verify "Country found matching code [LO]." with "MESSAGE_PATH" present in response

