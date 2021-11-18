# Project verifies the Egg Timer
# Running and building scripts
    1. Batch File : Just double click the batch file after cloning the project from github. Ensure Maven is installed and setup
    2. Jenkins Job : Use Jenkins pipeline and schedule a job in your agent
    3. From command prompt : Navigate to base project folder and run mvn clean install

# Highlights
    Singleton structure framework to ease out parallel execution
    It uses the BDD approach with Cucumber's latest features
    Extent Report has been integrated with Cucumber default reports
    Reports can be published to Cucumber shared repository
    Tags has been used to run specific tests alone
    Extent Reports will auto populate and Cucumber.html reports can be accessed from within the target folder

# Project structure
    1. org.automaiton 
       It is the base package containing all sub packages
    2. features package 
       It has all .feature files
    3. pageobjects 
       It has common controllers for framework[CommonSetters.java file] and locators specific to every page
       CommonSetters.java - manages and controls the default parameters for the framework
    4. stepdefinitions packag
       It has the methods corresponding to our features
    5. Util package
       BrowserFactory Class : Has all browser related methods
       Reporter Class : Extent report specific methods
       Reusable Components Class : Has all driver related methods to find and interact with elements
       Runner : Is our Junit Runner class for execution

# Limitations/Prerequisites
    1. Will work only on web based elements
    2. Chrome driver should be the latest version in the system
    3. Maven should be installed
    4. Docker should be installed on WSL2/WSL1

# Improvement
    1. Better approach to test this could have been vis Cypress or TestNG
    2. Reports can be further extended to every step or scenario. At moment it does basic reporting
    3. Facility to run every scenario can also be provided

# Bugs:
    1. 10000 returns 2 hours
    2. 9600 returns 7569 years
    3. 1000000000 returns blank

# Jenkins
    1. Jenkins Linter to validate the pipeline
    2. Jenkins.yml contains the container mappings - No need to install Jenkins into the system. Mapping of volume shoudl be done to save data
    3. JenkinsFile has the basic build and compile and run stages on agent with label eggtimer


    