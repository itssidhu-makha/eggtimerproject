package org.automation.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.automation.pageobjects.CommonSetters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class BrowserFactory {
    public static BrowserFactory instance;//static variable
    public ThreadLocal<WebDriver> driver= new ThreadLocal<>();
    //singleton structure
    private BrowserFactory(){

    }

    public static BrowserFactory getInstance(){
        if(instance==null){
            instance=new BrowserFactory();
        }
        return instance;
    }

    public static void main(String[] args) {
        killTasks();
    }

    private static void killTasks() {
        try {
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        }catch(Exception e){

        }
    }

    public void setBrowser(String browserName){
        switch (browserName){
            case "chrome":
                driver.set(launchChrome());
        }
        getBrowser().manage().window().maximize();
        getBrowser().manage().timeouts().implicitlyWait(Duration.ofSeconds(CommonSetters.IMPLICIT_WAIT_TIME));
    }

    public WebDriver getBrowser(){
        return driver.get();
    }


    private WebDriver launchChrome() {
        //System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//src//main/resources//chromedriver.exe");
        WebDriverManager.chromiumdriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

}
