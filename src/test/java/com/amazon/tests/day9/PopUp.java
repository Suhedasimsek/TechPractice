package com.amazon.tests.day9;

import com.amazon.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class PopUp {

    WebDriver driver;

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://www.krafttechexlab.com/javascript/alerts");
        WebElement clickButton = driver.findElement(By.cssSelector("#myBtnClick"));
        Thread.sleep(1000);
        clickButton.click();
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        //accept()
        //dismiss()
        //sendKeys()
        alert.accept();
        Thread.sleep(5000);
    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("https://www.krafttechexlab.com/javascript/alerts");
        List<WebElement> elements = driver.findElements(By.xpath("//button[.='Click Me']"));
        elements.get(2).click();
        //WebElement element = driver.findElement(By.xpath("(//button[.='Click Me'])[3]"));
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        Thread.sleep(2000);
    }



    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
