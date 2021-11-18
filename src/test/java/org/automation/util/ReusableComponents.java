package org.automation.util;

import org.automation.pageobjects.CommonSetters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ReusableComponents {
    BrowserFactory driver = BrowserFactory.getInstance();
    Reporter reporter = Reporter.getReporterInstance();
    public WebElement findElement(By by, String eleName){
        try {
            reporter.reportPass("Element found :: "+eleName);
            return driver.getBrowser().findElement(by);
        }catch(Exception e){
            reporter.reportFail("Element Not found :: "+eleName);
            return null;
        }
    }
    public void findElementAndClick(By by,String eleName) {
        WebElement ele = findElement(by,eleName);
        clickElement(ele);
    }
    public void clickElement(WebElement ele) {
        if(ele!=null){
            try {
                waitForElementToBeClickable(ele);
                ele.click();
            }catch (Exception e){

                Assert.fail("Click Intercepted");
            }
        }
    }

    private void waitForElementToBeClickable(WebElement ele) {
        WebDriverWait wait = new WebDriverWait(driver.getBrowser(), CommonSetters.EXPLICIT_WAIT_TIME);
        wait.until(ExpectedConditions.elementToBeClickable(ele))
                .isDisplayed();
    }

    public void findElementAndSendKeys(By by,String value, String eleName){
        try {
            WebElement ele = findElement(by,eleName);
            sendKeys(ele,value);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void sendKeys(WebElement ele, String value) {
        ele.sendKeys(value);
    }

    public void elementShouldBeDisplayed(By by, String eleName) {
        waitForElementToBeDisplayed(by,eleName);
    }

    private void waitForElementToBeDisplayed(By by,String eleName) {

        WebDriverWait wait = new WebDriverWait(driver.getBrowser(), Duration.ofSeconds(CommonSetters.EXPLICIT_WAIT_TIME));
        wait.until(ExpectedConditions.visibilityOf(findElement(by,eleName)));
    }

    public boolean verifyTitleOfPage(String title) {
        String actualTitle="";
        try {
             actualTitle= driver.getBrowser().getTitle();
        }catch(Exception e){

        }
        return actualTitle.equalsIgnoreCase(title)?true:false;
    }

    public boolean checkIfAlertPresent() {
        WebDriverWait wait = new WebDriverWait(driver.getBrowser(),Duration.ofSeconds(1));
        try {
            if (wait.until(ExpectedConditions.alertIsPresent()) == null)
                return false;
            else
                return true;
        }catch(Exception e){
            return false;
        }
    }

    public String getTextFromElement(By by, String eleName) {
        return findElement(by,eleName).getText();
    }
}
