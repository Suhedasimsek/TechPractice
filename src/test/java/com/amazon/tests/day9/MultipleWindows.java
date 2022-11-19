package com.amazon.tests.day9;

import com.amazon.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://www.krafttechexlab.com/components/opennew");
        WebElement openNewTab = driver.findElement(By.xpath("//a[text()='Open New Tab']"));
        Thread.sleep(3000);
        String firstPage = driver.getWindowHandle();
        openNewTab.click();
        Set<String> windowHandles = driver.getWindowHandles();

        for (String windowHandle : windowHandles) {
            if(!windowHandle.equals(firstPage)){
                driver.switchTo().window(windowHandle);
                break;
            }
        }


        Thread.sleep(3000);
        String actualValue = driver.findElement(By.xpath("//h1[.='Alerts']")).getText();
        String expectedValue = "Alerts";
        Assert.assertEquals(actualValue,expectedValue);
    }

}
