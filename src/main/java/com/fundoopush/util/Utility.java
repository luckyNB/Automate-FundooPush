package com.fundoopush.util;

import com.google.gson.Gson;

import org.apache.commons.io.FileUtils;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Utility {
    public static final int pageload = 20;
    public static final int wait = 10;
    public static final int pageNo = 1;

    public static Gson readingJsonFileFromGivenPath(String filePath) {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(filePath)) {
            Object obj = jsonParser.parse(reader);
            Gson employeeList = (Gson) obj;
            return employeeList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void captureScreenShot(WebDriver driver, String screenshotName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File dest = new File("/home/admin1/Documents/POM_Sample_Facebook_With_TestNGLister/src/main/resources/ScreenShots/" + screenshotName + ".png");
        try {
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
