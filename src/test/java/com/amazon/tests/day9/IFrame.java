package com.amazon.tests.day9;

import com.amazon.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IFrame {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    //@AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://www.krafttechexlab.com/components/iframe");
        //driver.switchTo().frame(0);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Iframe Example']")));
        driver.findElement(By.xpath("(//button[@class='btn-close'])[1]")).click();
        Thread.sleep(3000);
    }

    @Test
    public void test2(){
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.get("https://demoqa.com/nestedframes");
        driver.switchTo().frame("frame1");
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']")));
        System.out.println(driver.findElement(By.xpath("//p[.='Child Iframe']")).getText());
        //driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();

        WebDriverWait webDriverWait = new WebDriverWait(driver, 7);
        //webDriverWait.until(ExpectedConditions.visibilityOf())
        driver.manage().timeouts().implicitlyWait(7,TimeUnit.SECONDS);
    }

    @Test
    public void test3() throws InterruptedException {
        driver.get("http://mobilkod.eba.gov.tr/");
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("#gameContainer")).click();
        Thread.sleep(3000);
    }

}
