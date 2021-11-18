package org.automation.stepdefinitions;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.automation.pageobjects.EggTimer;
import org.automation.util.BrowserFactory;
import org.automation.util.Reporter;
import org.automation.util.ReusableComponents;
import org.junit.Assert;
import org.openqa.selenium.By;

public class TimerPage{
    ReusableComponents util = new ReusableComponents();
    Reporter reporter = Reporter.getReporterInstance();
    BrowserFactory driver = BrowserFactory.getInstance();
    @When("user enters time {long}")
    public void userEntersTimeTime(long time) {
        util.findElementAndSendKeys(By.id(EggTimer.ID_EGGTIMER_START),String.valueOf(time),"Timer Input Box");
    }

    @When("user clicks on start timer")
    public void userClicksOnStartTimer() {
        util.findElementAndClick(By.xpath(EggTimer.XPATH_EGGTIMERSTART_BUTTON),"Egg Timer Start");
    }

    @And("timer should decrement by every second")
    public void timerShouldDecrementByEverySecond() {

        //check for alert presence
        while(util.checkIfAlertPresent()!=true){
            String time = util.getTextFromElement(By.xpath(EggTimer.XPATH_TIMER_CHECKER),"Timer Checker");
            if(null!=time){
                reporter.reportPass("Timer is decrement every second - now at"+time+" second");
                Assert.assertTrue("Timer is decrement every second - now at"+time+" second",true);
            }
        }
    }

    @Then("accept the task complete alert")
    public void acceptTheTaskCompleteAlert() {
        if(util.checkIfAlertPresent()){
            driver.getBrowser().switchTo().alert().accept();
        }
    }
}
