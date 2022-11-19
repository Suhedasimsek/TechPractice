package com.amazon.tests.day12;

import com.amazon.utilities.ConfigurationReader;
import com.amazon.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class PropertiesTest {

    @Test
    public void test1(){
        String browser = ConfigurationReader.get("browser");
        System.out.println("browser = " + browser);
        String url = ConfigurationReader.get("url");
        System.out.println("url = " + url);
    }

    @Test
    public void test2() throws InterruptedException {
        WebDriver driver = Driver.get();
        driver.get(ConfigurationReader.get("url"));
        Thread.sleep(5000);
        //Driver.closeDriver();
    }

}
