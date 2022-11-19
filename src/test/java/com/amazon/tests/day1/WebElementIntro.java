package com.amazon.tests.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementIntro {

    public static void main(String[] args) {

        //go to Amazon
        //click on search button
        // verify that url is not changed

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.findElement(By.xpath("//input[@name='field-keywords']"));

        driver.get("https://www.amazon.com");

        WebElement element = driver.findElement(By.id("twotabsearchtextbox"));

        element.click();

        String beklenenUrl = "https://www.amazon.com";
        String gerçekUrl = driver.getCurrentUrl();

        if(beklenenUrl.equals(gerçekUrl)){
            System.out.println("\"GEÇTİ\" = " + "GEÇTİ");
        }else{
            System.out.println("\"KALDI\" = " + "KALDI");
        }

        //test[@test='test']
        //test[.='text']
        //test[text()='test']
        //test[contains(text(),'test')]
        //test[contains(@test,'test')]
        //test[starts-with(text(),'test')]
        //test[starts-with(@test,'test')]
        //test[ends-with(text(),'test')] .. not work with Chrome
        //test[ends-with(@test,'test')] .. not work with Chrome




    }

}
