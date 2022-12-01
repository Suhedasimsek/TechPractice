package com.amazon.tests.day15_DDF;

import com.amazon.pages.LoginPage;
import com.amazon.tests.TestBase;
import com.amazon.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DPCombineWithRealScenario extends TestBase {

    ExcelUtil excelUtil = new ExcelUtil("src/test/resources/Book1.xlsx","Sheet1");

    @DataProvider
    public Object[][] userData(){
        String[][] dataArray = excelUtil.getDataArrayWithoutFirstRow();
        return dataArray;
    }

    @Test(dataProvider = "userData")
    public void successLoginTest(String username, String password){
        extentLogger = report.createTest("test of with " + username + " " + password);

        driver.get("https://www.krafttechexlab.com/login");
        LoginPage loginPage = new LoginPage();
        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.clickLoginButton();
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.krafttechexlab.com/index"));

        extentLogger.pass("test is passed");
    }


}
