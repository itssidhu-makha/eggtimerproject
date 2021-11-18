package org.automation.stepdefinitions;


import io.cucumber.java.*;
import org.automation.pageobjects.CommonSetters;
import org.automation.util.BrowserFactory;
import org.automation.util.Reporter;


public class Hook {
    static BrowserFactory driver = BrowserFactory.getInstance();
    static Reporter reporter = Reporter.getReporterInstance();

    @BeforeAll
    public static void before_all(){


        reporter.setExtentReports();
        driver.setBrowser(CommonSetters.BROWSER);
    }

    @Before
    public void initialiseReporter(Scenario scenario){
        reporter.setTest("Starting scenario "+scenario.getId());
    }
    @After
    public void endTest(Scenario scenario){

    }

    @AfterAll
    public static void after_all(){
        reporter.getReporter().flush();
        driver.driver.remove();
        reporter.test.remove();
        reporter.reports.remove();
        populateReports();
    }
    private static void populateReports() {
        driver.setBrowser("chrome");
        driver.getBrowser().get(Reporter.reporterPath);
    }

}
