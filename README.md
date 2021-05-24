Full Name : Ufuk Sahinduran

Project Title : The Modern Milkman technical UI testing framework

Installation guide: This is a maven project. so It's assumed that the host running this code have Java and maven
installed and JAVA_HOME already set. Here is the guide for maven installation just in
link : https://maven.apache.org/install.html Project get all dependencies from maven repository.
So no additional installation needed. The tools are managed by adding dependencies' to pom.xml file which are
for this framework and test.

pom.xml file:
Below are the dependencies are being used for this project :

Selenium Java: https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java

Github Bonigarcia(WebdriverManager): https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager

Cucumber Java: https://mvnrepository.com/artifact/io.cucumber/cucumber-java

Cucumber JUnit: https://mvnrepository.com/artifact/io.cucumber/cucumber-junit

Github Java Faker: https://mvnrepository.com/artifact/com.github.javafaker/javafaker

Cucumber Reports plugins: https://plugins.jenkins.io/cucumber-reports/


                        Web Testing:
configuration.properties: This file is for storing and managing test data.

docker-compose.yml: this file is for creating images and container for selenium 

chrome and firefox in order to run this test script on Docker container.

resources: this directory is for storing feature file which contains test scenarios 
    Scenarios: created based on BDD by Gherkin syntax


pages Package:
    Login class: I have built most of the test scripts in this class by using methods based on the test steps.

runner Package:
    Cukes Runner class: This class is for running this test script by using cucumber options which contains
        feature file pathway, step definitions, plugins and dryRun.

Step Definitions: 
    LoginStepdef class: This class for running our scenario and steps from login feature file. I also
        created a reference type of Login class object in order to call instance methods from this class.
    Hook class: this class is for running before and after each and every scenario.
        I have added scenario names, before and after methods and also implicity wait and maximize screen for UI test.

utilities Package:
    Driver class: it contains selenium webdriver which I initialised for chrome, firefox, remotechrome and
        remotefirefox driver
    ConfigurationReader class: this class is for reading data from Config file.
    BrowserUtils class: in order to use static methods (avoiding repetitions).

        
                Note1:
This script is working without any static wait(not required), but I have put the static waits between test step just 
in order to see how this automation script is working on the webpage.  


                Note2:
There could be added possible test scenarios for this specific test cases such as

 1-Entering letters and special characters in phone input box

 2-Entering a valid non-UK phone number

 3-Checking boundaries for both phone number and password

 4-Testing "Remember me"

 5-Testing "Don't have an account? Sign Up"

 6-Testing "Forget Password" 
    