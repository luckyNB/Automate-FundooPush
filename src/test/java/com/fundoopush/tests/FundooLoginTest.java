package com.fundoopush.tests;

import com.fundoopush.base.BaseClass;
import com.fundoopush.pages.LoginPage;
import com.fundoopush.util.JsonReader;
import org.apache.log4j.Logger;
import org.testng.ITestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class FundooLoginTest extends BaseClass {
    Logger log = Logger.getLogger(FundooLoginTest.class);
    String filePath = "./src/main/resources/TestData/LoginTestData.json";
    LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        initiation();
        loginPage = new LoginPage();
    }

    @DataProvider(name = "LoginTest Data")
    public Object[][] passData() throws IOException {

        return JsonReader.getdata(filePath, "LoginTest Data", 7, 2);
    }

    @Test(dataProvider = "LoginTest Data")
    public void givenEmailIDAndPasswordWhenCorrect_Should_LoginIntoFundooPushApplication(String email, String password) {
        log.info("Login operation started");
        loginPage.setEmailValue(email);
        loginPage.setPasswordValue(password);
        loginPage.clickOnLoginButton();
        log.info("login operation ended");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
