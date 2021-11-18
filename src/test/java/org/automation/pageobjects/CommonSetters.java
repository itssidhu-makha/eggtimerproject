package org.automation.pageobjects;

public interface CommonSetters {

    String BROWSER = "chrome";
    int IMPLICIT_WAIT_TIME = 30;
    long EXPLICIT_WAIT_TIME = 15;
    String REPORTER_PATH = System.getProperty("user.dir")+"//reports";
    String SCREENSHOT_PATH = System.getProperty("user.dir") + "//screenshots//";
}
