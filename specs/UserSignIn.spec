User Sign-in
=====================
Created by AnkitNigam on 7/27/2018

```````````Using external file to make seprate data from test case
```````````Can execute same test multiple time depending on the number of rows in csv

table:src/test/resources/TestData/signInData.csv

* User Navigate to application home

Verify user able to SignIn
----------------
* User on "Home" page
* User click "SignIn" button
* User on "Authentication" page
* User enter "NewEmailAddress" as <EmailAddress>
* User click "CreateAccount" button
* User on "CreateAnAccount" page
* User click "Mrs" radio button
Can make it Declarative but from my experience, I belive its better to keep it imperative for the easiness of Manual testers & re-usablity
Using data from external file
* User enter "FirstName" as <FirstName>
* User enter "LastName" as <LastName>
* User enter "Password" as <Password>
* User select "Days" with "value" as <Days>
* User select "Months" with "value" as <Months>
* User select "Years" with "value" as <Years>
* User enter "Company" as <Company>
* User enter "Address1" as <Address1>
* User enter "Address2" as <Address2>
* User enter "City" as <City>
* User select "State" with "text" as <State>
* User enter "Postcode" as <PostCode>
* User enter "AdditionalInformation" as <AdditionalInfo>
* User enter "HomePhone" as <Phone>
* User enter "MobilePhone" as <MobileNo>
* User enter "AddressAlias" as <Alias>
* User click "Register" button
* User on "MyAccount" page
* "MyAccountText" as "MY ACCOUNT" displaying
* "CustomerName" as "COMPLETE_NAME" displaying
* "WelcomeMessage" contains "Welcome to your account."
* "URL" contains "controller=my-account"









