package com.fundoopush.tests;

import com.fundoopush.base.BaseClass;
import com.fundoopush.util.JsonReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePage_02_Registration extends BaseClass {
    public static String filePath = "./src/main/resources/TestData/Registration.json";

    @BeforeMethod
    public void setUp() {
        initiation();
    }

    @DataProvider(name = "registration data")
    public Object[][] passData() throws IOException {
        //return JsonReader.getJSONdata(AppConfig.getJsonPath()+"Registration.json", "Registration Data",3);
        return JsonReader.getdata(filePath, "Registration Data", 3, 12);
    }

    @Test(dataProvider = "registration data")
    public void userRegistration(String FirstName, String LastName, String phone, String email, String address,
                                 String city, String state, String postalCode, String country, String userId,
                                 String pwd, String confirmPwd) throws Exception {
        driver.get("http://newtours.demoaut.com/");
        driver.findElement(By.partialLinkText("Register here")).click();
        driver.findElement(By.name("firstName")).sendKeys(FirstName);
        driver.findElement(By.name("lastName")).sendKeys(LastName);
        driver.findElement(By.name("phone")).sendKeys(phone);
        driver.findElement(By.id("userName")).sendKeys(email);
        driver.findElement(By.name("address1")).sendKeys(address);
        driver.findElement(By.name("city")).sendKeys(city);
        driver.findElement(By.name("state")).sendKeys(state);
        driver.findElement(By.name("postalCode")).sendKeys(postalCode);
        Select selectCountry = new Select(driver.findElement(By.name("country")));
        selectCountry.selectByVisibleText(country);
        driver.findElement(By.name("email")).sendKeys(userId);
        driver.findElement(By.name("password")).sendKeys(pwd);
        driver.findElement(By.name("confirmPassword")).sendKeys(confirmPwd);
        driver.findElement(By.name("register")).click();
        Thread.sleep(2000);
        driver.quit();
    }
}
