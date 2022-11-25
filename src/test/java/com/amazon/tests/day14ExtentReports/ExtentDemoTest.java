package com.amazon.tests.day14ExtentReports;

import com.amazon.utilities.ConfigurationReader;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtentDemoTest {

    //this class is used for starting and building reports
    ExtentReports report;

    //this class is used to create HTML report file
    ExtentHtmlReporter htmlReporter;

    //this will define a test, enables adding logs, authors, test steps
    ExtentTest extentLogger;

    @BeforeMethod
    public void setUp(){
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

    @Test
    public void test1(){
        //give a name to current test
        extentLogger = report.createTest("TC1 - Login with first valid user");

        //test steps
        extentLogger.info("Open Chrome Browser");

        extentLogger.info("Go to this url");

        extentLogger.info("Enter email");

        extentLogger.info("Click login");

        extentLogger.info("verify logged in");

        extentLogger.info("TC1 is passed");
    }

    @AfterMethod
    public void tearDown(){
        //when the report is actually created
        report.flush();
    }


}
