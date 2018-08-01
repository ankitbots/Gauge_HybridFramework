# HybridAutomation Framework

This is a test automation framework to implement the task 1 and task 2 for Hello Fresh. I have designed a single Hybrid Automation Framework to test Web GUI and SOA test cases.

To design this framework I am using Thoughworks Gauge + Selenium WebDriver + RestAssured librariers. 

In this framework I have tried catering all the requirements mention in the automation task. 



## Getting Started

### Prerequisites

- [Install Gauge](https://docs.gauge.org/installing.html#installation)
- [Java](https://www.java.com/en/download/index.jsp)
- [Configure Maven](https://maven.apache.org/download.cgi)
- Browser Chrome/Firefox/IE


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

Install Gauge Java plugin

```
gauge install java
```

Install HTML report plugin

```
gauge install html-report
```

For any help on installation please refer [link](https://docs.gauge.org/latest/index.html)

## Running the tests

All the test cases are available specs folder. 

Run the below command to execute all specifications in `specs` directory

```
mvn test -P{profile} -DspecsDir=specs
like:
mvn test -Pdev -DspecsDir=specs
```

Execute specs In parallel

```
mvn test -Pdev -DspecsDir=specs -DinParallel=true -Dnodes=4
```

Execute specs by [tags](http://getgauge.io/documentation/user/current/advanced_readings/execution_types/tagged_execution.html)

```
mvn test -Pdev -DspecsDir=specs -Dtags="logIn"
```

==> Makes sure to provide profile while executing the specs


### Framework details:

```
Specs
```

* Specs (Specifications): In Gauge, we write our test cases as .spec files

To script the requied test scenarios I have created 7 test cases(spec):

UserCheckout.spec
UserLogIn.spec
UserSignIn.spec
ValidateAllCountries.spec
ValidateEachCountry.spec
ValidateInexistentCountry.spec
ValidateNewCountry.spec

* ValidateNewCountry.spec test case will always fail as we have not yet implemented POST functionality for adding new country.

==> To write the specs I am following Imperative style instead of Declarative style. As per my experience, Imperative style makes framework more re-usable to test other applications and manual testers can easly pick the scripting.

```
Repository
```

* Repository: Instead of using typical POM for desiging framework. I am maintaining objects, divided by pages in repository.xml
* Using unmarshalling to load xml to objects and use them at run time.

```
Driver
```
* Driver folder contains DriverFactory. It allows use to test application with different browsers like Chrome, Firefox and IE. However, I have tested my scripts only with Chrome and Firefox.
* User can set the browser type from the .pom profiles using property app.browser

```
ActionSteps and Action
```
* The sentences we wrote in the specs are linked with Java functions available in src/test/java folder
* I am only using these ActionStep functions for calling Action functions and performing asserstions
* All the script execution logic are writting in Action functions

```
TestData
```
* I have sperated my test data from the scripts to make them more re-usable
* TestData is available under src/test/resources


```
Reports
```
* Html reports are available in report folder
* All failed test steps will contain snapshot of the failure.


 <img src="https://github.com/ankitbots/Gauge_HybridFramework/raw/master/Gauge_Report.jpg" alt="Test Report" style="width: 600px;"/>

```
Logs
```
* I am generating logs under hf_logs folder.


## Author

* **Ankit Nigam**
