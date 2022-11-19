package com.amazon.tests.day7;

import org.junit.After;
import org.testng.annotations.*;

public class BeforeAfter {

    @Test
    public void test1(){
        System.out.println("first test case");
    }

    @Test
    public void test2(){
        System.out.println("second test case");
    }

    @BeforeMethod
    public void setUp(){
        System.out.println("Before Method");
        System.out.println("Webdriver, opening browser");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("After Method");
        System.out.println("close driver");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }



}
