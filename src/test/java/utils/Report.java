package utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;

public class Report {
    public static ExtentReports reports;
    public static ExtentTest test;

    public static ExtentReports generateExtentReports(String reportName) {
        ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/" + reportName + ".html");
        reports = new ExtentReports();
        reports.attachReporter(spark);
        return reports;
    }

    public static void addScreenshot(ExtentTest test, WebDriver driver, String message) {
        try {
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String path = System.getProperty("user.dir") + "/reports/" + "_" + timestamp + ".png";
            FileUtils.copyFile(src, new File(path));
            test.info(message, MediaEntityBuilder.createScreenCaptureFromPath(path).build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
