User Checkout
=====================
Created by AnkitNigam on 7/28/2018

```````````Using external file to make seprate data from test case
```````````Can execute same test multiple time depending on the number of rows in csv
```````````Using Same as LogIn data



table:src/test/resources/TestData/logInData.csv

* User Navigate to application home

Verify user able to SignIn
----------------
tags: checkOut

* User on "Home" page
* User click "SignIn" button
* User on "Authentication" page
* User enter "RegisteredEmailAddress" as <ExistingUserEmail>
* User enter "Password" as <ExistingUserPassword>
* User click "SignIn" button
* User on "MyAccount" page
* User click "WomenLink" link
* User on "WomenStore" page
* User click "FadedShortSleeveTshirts" image
* User on "FadedShortSleeveTshirtsStore" page
* User click "AddToCart" button
* User click "ProceedToCheckout" button
* User on "OrderStore" page
* User click "ProceedToCheckout" button
* User click "ProceedAddress" button
* User click "AgreeTerms" checkbox
* User click "ProceedCarrier" button
* User click "PayByBankWire" link
* User on "MyStore" page
* User click "ConfirmOrder" button
* User on "OrderConformationStore" page
* "OrderConformationText" as "ORDER CONFIRMATION" displaying
* "ShippingTab" is displaying
* "PaymentTab" is displaying
* "OrderCompleteMessage" contains "Your order on My Store is complete."
* "URL" contains "controller=order-confirmation"
* User click "Logout" button






