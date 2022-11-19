package com.amazon.tests.day10;

import com.amazon.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FileUpload {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://demoqa.com/upload-download");
        WebElement element = driver.findElement(By.cssSelector("#uploadFile"));
        element.sendKeys("/Users/eren.cengel/Desktop/File.txt");
        Thread.sleep(5000);

        //Yüklemek istediğim dosya desktop üzerinde --> File.txt
        WebElement element1 = driver.findElement(By.cssSelector("#uploadedFilePath"));
        String expected = "C:\\fakepath\\File.txt";
        String actual = element1.getText();

        Assert.assertEquals(actual,expected);
    }


    @Test
    public void test2(){
        ///Users/eren.cengel/IdeaProjects/CraftTech/src/test/resources/File
        System.out.println("System.getProperty(\"user.dir\") = " + System.getProperty("user.dir"));

        String projectPath = System.getProperty("user.dir");
        String filePath = "src/test/resources/File";
        String fullPath = projectPath + "/" + filePath;

        //Yüklemek istediğim dosya frameworkte --> File
        driver.get("https://demoqa.com/upload-download");
        WebElement element = driver.findElement(By.cssSelector("#uploadFile"));
        element.sendKeys(fullPath);

        WebElement element1 = driver.findElement(By.cssSelector("#uploadedFilePath"));
        String expected = "C:\\fakepath\\File";
        String actual = element1.getText();

        Assert.assertEquals(actual,expected);
    }



}
