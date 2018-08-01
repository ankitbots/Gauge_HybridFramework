# HybridAutomation Framework

This is a test automation framework to implement the Task 1 and Task 2 for HelloFresh. I have designed a Hybrid Automation Framework to test **Web GUI** and **SOA** test cases.

To design this framework I am using **Thoughworks Gauge** + **Selenium WebDriver** + **RestAssured** libraries. 

_In this framework I have tried catering all the requirements mention in the automation task._ 



## Getting Started

### Prerequisites

- [Install Gauge](https://docs.gauge.org/installing.html#installation)
- [Gauge Java Plugin](https://github.com/getgauge/gauge-java/#gauge-java)
- [Gauge HTML Report Plugin](https://github.com/getgauge/html-report/blob/master/README.md)
- [Java](https://www.java.com/en/download/index.jsp)
- [Configure Maven](https://maven.apache.org/download.cgi)
- Browser Chrome/Firefox/IE
- Browser drivers 


### Installation

Install Gauge using [Chocolatey](https://chocolatey.org/)

```
choco install gauge
```

Or Download the [zip](https://github.com/getgauge/gauge/releases/download/v1.0.0/gauge-1.0.0-windows.x86_64.zip) installer and the run following command in powershell

```
PS> Expand-Archive -Path gauge-1.0.0-windows.x86_64.zip -DestinationPath custom_path
```
Make sure Gauge added in $PATH

Install **Gauge Java plugin**

```
gauge install java
```

Install **HTML report plugin**

```
gauge install html-report
```

For any help on installation please refer [link](https://docs.gauge.org/latest/index.html)

Add **Browser Drivers** in drivers/{browser} folder

```
like: /drivers/chromedriver/chromedriver.exe
```

## Running the tests

All test cases are available under **specs** folder. 

Run the below command to execute all specifications in `specs` directory

```
mvn test -P{profile} -DspecsDir=specs{optional} -Denv={chrome/firefox/ie}{optional}
```

Launch using **Chrome**(default option) with minimum options
```
mvn test -Pdev
```

Launch using **Firefox**
```
mvn test -Pdev -Denv=firefox -DspecsDir=specs
```

Launch using **IE**
```
mvn test -Pdev -Denv=ie -DspecsDir=specs
```

_I have only tested the scripts on Chrome and Firefox browser_


Execute specs In **parallel**

```
mvn test -Pdev -DspecsDir=specs -DinParallel=true -Dnodes=4
```

Execute specifications by [tags](http://getgauge.io/documentation/user/current/advanced_readings/execution_types/tagged_execution.html)

```
mvn test -Pdev -DspecsDir=specs -Dtags="logIn"
```

> Makes sure to provide profile while executing the specs


### Framework details:

```
Specs
```

* **Specs** (Specifications): In Gauge, we write our test cases as .spec files

To script the required test scenarios I have created 7 test cases(spec):

 1. UserCheckout.spec
 2. UserLogIn.spec
 3. UserSignIn.spec
 4. ValidateAllCountries.spec
 5. ValidateEachCountry.spec
 6. ValidateInexistentCountry.spec
 7. ValidateNewCountry.spec

> ValidateNewCountry.spec test case will always fail as we have not yet implemented POST functionality for adding new country.

:exclamation: To write the specs I am following **Imperative style** instead of **Declarative style**. As per my experience, Imperative style makes framework more re-usable to test other applications and functional testers can easily pick the scripting.

```
Repository
```

* Instead of using typical POM for designing framework. I am maintaining objects, divided by pages in **repository.xml**
* Using unmarshalling to load xml to objects and extracting locators at run time

```
Driver
```
* Driver folder contains DriverFactory. It allows use to test application with different browsers like _Chrome, Firefox and IE_. However, I have tested my scripts only with Chrome and Firefox.
* User can pass browser using **-Denv={browser_name}** property and configure driver in `/env/{browser_name}/browser.properties` folder.
* Environment details like app urls are set using profiles in pom.xml

```
ActionSteps and Action
```
* The sentences we wrote in the specs are linked with Java functions available in `src/test/java` folder
* Using ActionStep functions only to call Action functions and performing assertions
* All the script execution logic are written in Action functions

```
TestData
```
* I have separated my test data from the scripts to make them more re-usable
* TestData is available under src/test/resources


```
Reports
```
* Html reports are available in report folder
* All failed test steps will contain snapshot of the failure


 <img src="https://github.com/ankitbots/Gauge_HybridFramework/raw/master/Gauge_Report.jpg" alt="Test Report" style="width: 600px;"/>

```
Logs
```
Generating custom logs under hf_logs/ folders with below 3 logs

* testhfInfo.log: Contains Info logs
* testhfRegression.log: Contains Debug logs
* testhfError.log: Contains Error, Warn and Fatal


## Author

**Ankit Nigam**
