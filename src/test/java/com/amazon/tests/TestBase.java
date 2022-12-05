package com.amazon.tests;

import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.ConfigurationReader;
import com.amazon.utilities.Driver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {

    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait webDriverWait;

    //this class is used for starting and building reports
    protected ExtentReports report;
    //this class is used to create HTML report file
    protected ExtentHtmlReporter htmlReporter;
    //this will define a test, enables adding logs, authors, test steps
    protected ExtentTest extentLogger;

    @BeforeMethod
    public void setUp(){
        driver = Driver.get();
        driver.get(ConfigurationReader.get("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        actions = new Actions(driver);
        webDriverWait = new WebDriverWait(driver,7);
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {

        //if test fails
        if(result.getStatus() == ITestResult.FAILURE){
            //record the name of failed test case
            extentLogger.fail(result.getName());

            //take the screenshot and return location of ss
            String screenShotPath = BrowserUtils.getScreenshot(result.getName());

            //add your ss to your report
            extentLogger.addScreenCaptureFromPath(screenShotPath);

            //capture the exception and put inside the report
            extentLogger.fail(result.getThrowable());
        }

        Driver.closeDriver();
    }

    @BeforeTest
    public void setUpTest(){
        //initialize the class
        report = new ExtentReports();

        //create a report path (it should be dynamic, not should be duplicated)
        String projectPath = System.getProperty("user.dir");
        String path = projectPath + "/" + "/test-output/report.html"; // this will be created automatically

        //initialize the html reporter with the report path
        htmlReporter = new ExtentHtmlReporter(path);

        //attach the html report to report object
        report.attachReporter(htmlReporter);

        //title in report
        htmlReporter.config().setReportName("craftLoginTest");

        //set environment information
        report.setSystemInfo("Environment", "QA");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS", System.getProperty("os.name"));
    }

    @AfterTest
    public void tearDownTest(){
        //when the report is actually created
        report.flush();
    }
}
