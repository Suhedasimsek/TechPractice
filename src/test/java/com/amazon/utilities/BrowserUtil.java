package com.amazon.utilities;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BrowserUtil {

    /*
     * click the target element
     * @param WebElement
     */
    public static void clickOnElement(WebElement element){
        try {
            element.click();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /*
     * hover over the target element
     * @param WebElement
     */
    public static void hoverOverOnElement(WebElement element){
        Actions actions = new Actions(Driver.get());
        try {
            actions.moveToElement(element).perform();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /*
     * get the text of element
     * @param WebElement
     */
    public static String getTextOfElement(WebElement element){
        return element.getText();
    }

    /*
     * drag an element onto another one
     * @param two web elements
     */
    public static void dragAndDrop(WebElement element1, WebElement element2){
        try {
            new Actions(Driver.get()).dragAndDrop(element1,element2).perform();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
