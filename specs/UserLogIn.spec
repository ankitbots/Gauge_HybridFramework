User Log-In
=====================
Created by AnkitNigam on 7/28/2018

```````````Using external file to make seprate data from test case
```````````Can execute same test multiple time depending on the number of rows in csv


table:src/test/resources/TestData/logInData.csv

* User Navigate to application home

Verify user able to SignIn
----------------
tags: logIn

* User on "Home" page
* User click "SignIn" button
* User on "Authentication" page
* User enter "RegisteredEmailAddress" as <ExistingUserEmail>
* User enter "Password" as <ExistingUserPassword>
* User click "SignIn" button
* User on "MyAccount" page
* "MyAccountText" as "MY ACCOUNT" displaying
* "CustomerName" as <FullName> displaying
* "Logout" is displaying
* "URL" contains "controller=my-account"
* User click "Logout" button









