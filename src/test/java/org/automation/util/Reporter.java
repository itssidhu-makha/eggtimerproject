package org.automation.util;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;
import org.apache.commons.io.FileUtils;
import org.automation.pageobjects.CommonSetters;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Reporter {
    static Reporter instance=null;
    public ThreadLocal<ExtentReports> reports= new ThreadLocal<>();
    public ThreadLocal<ExtentTest> test= new ThreadLocal<>();
    public static String reporterPath=null;

    private Reporter(){

    }
    public static Reporter getReporterInstance(){
        if(instance==null){
            instance=new Reporter();
        }
        return instance;
    }

    public ExtentReports getReporter(){
        return reports.get();
    }

    public void setExtentReports(){
        SimpleDateFormat format = new SimpleDateFormat("MMddyyyy_HHmmss");
        String time =format.format(Calendar.getInstance().getTime());
        reporterPath= CommonSetters.REPORTER_PATH+"//"+time+"//"+time+".html";
        ExtentReports repo = new ExtentReports(reporterPath, NetworkMode.ONLINE);
        reports.set(repo);
    }

    public void setTest(String name){
        test.set(reports.get().startTest(name));
    }
    public ExtentTest getTest(){
        return test.get();
    }

    public static String takeScreenShot() {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot)BrowserFactory.getInstance().getBrowser();
        String destination="";
        try {
            File source = ts.getScreenshotAs(OutputType.FILE);
            destination = CommonSetters.SCREENSHOT_PATH + dateName
                    + ".png";
            System.out.println(destination);
            File finalDestination = new File(destination);
            FileUtils.copyFile(source, new File(finalDestination.getCanonicalPath()));
        }catch (Exception ignored){

        }
        return destination;
    }

    public  void reportPass(String message){
        this.test.get().log(LogStatus.PASS,message,getTest().addScreenCapture(takeScreenShot()));
    }

    public  void reportFail(String message){
        this.test.get().log(LogStatus.FAIL,message);
    }

    public  void reportInfo(String message){
        this.test.get().log(LogStatus.INFO,message);
    }

    public  void reportWarning(String message){
        this.test.get().log(LogStatus.WARNING,message);
    }
}
