package org.automation.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.automation.util.BrowserFactory;
import org.automation.util.Reporter;
import org.automation.util.ReusableComponents;
import org.openqa.selenium.By;

import static org.automation.pageobjects.EggTimer.PENGUIN_WITH_PENDULUM;


public class EggTimer {
    BrowserFactory driver = BrowserFactory.getInstance();
    ReusableComponents util = new ReusableComponents();


    @Then("an egg penguin with a clock should welcome us")
    public void anEggPenguinWithAClockShouldWelcomeUs() {

        util.elementShouldBeDisplayed(By.xpath(PENGUIN_WITH_PENDULUM),"Penguin Pendulum");


    }

    @And("the title of the egg should be {string}")
    public void theTitleOfTheEggShouldBeTitle(String title) {
        util.verifyTitleOfPage(title);
    }


    @Given("I navigate to url {string}")
    public void iNavigateToUrlAppUrl(String url) {
        driver.getBrowser().get(url);
    }
}
