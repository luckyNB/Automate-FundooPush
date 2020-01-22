package com.fundoopush.base;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public static WebDriver driver;
    public static Properties property;
    public static WebDriverWait wait;
    public static FileInputStream fis;

    static {
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver");
        System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver");

    }

    public BaseClass() {

        property = new Properties();
        try {
            fis = new FileInputStream("./src/main/java/com/fundoopush/config/config.properties");
            property.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initiation() {

        if (property.getProperty("browser").equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("profile.default_content_setting_values.notifications", 1);
//1-Allow, 2-Block, 0-default
            options.setExperimentalOption("prefs", prefs);
            options.addArguments("disable-infobars");
            driver = new ChromeDriver(options);

        } else if (property.getProperty("browser").equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(property.getProperty("URL"));
        wait = new WebDriverWait(driver, 10);

    }

}