package runner;

import Pages.DreamPortalHomePage;
import Pages.DreamsDiaryPage;
import Pages.DreamsTotalPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.*;
import utils.Base;
import utils.Report;

import java.net.MalformedURLException;

public class TestRunner extends Base {

    public ExtentTest test;
    public ExtentReports report;

    @BeforeClass
    public void report(){
        report= Report.generateExtentReports("Dream Portal Report");
    }

    @BeforeMethod
    public void setup(){
        try {
            openBrowser();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 1)
    public void testCase1(){
        test = report.createTest("Dream Portal Home Page Test");
        DreamPortalHomePage dreamPortalHomePage= new DreamPortalHomePage(test);
        dreamPortalHomePage.testCase01();
    }

    @Test(priority = 2)
    public void testCase2(){
        test = report.createTest("Dreams Diary Page Test");
        DreamsDiaryPage dreamsDiaryPage= new DreamsDiaryPage(test);
        dreamsDiaryPage.testCase02();
    }

    @Test(priority = 3)
    public void testCase3(){
        test = report.createTest("Dreams Total Page Test");
        DreamsTotalPage dreamsTotalPage= new DreamsTotalPage(test);
        dreamsTotalPage.testCase03();
    }

    @AfterMethod
    public void tearDown(){
        webDriver.quit();
    }

    @AfterClass
    public void flushReport(){
        report.flush();
    }
}
