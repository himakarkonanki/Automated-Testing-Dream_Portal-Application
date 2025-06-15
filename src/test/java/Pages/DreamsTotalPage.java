package Pages;


import Locators.DreamTotalPageLocators;
import Locators.DreamsDiaryPageLocators;
import Locators.HomePageLocators;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DreamsTotalPage{

    public WebDriverHelper webDriverHelper;
    public ExtentTest test;

    public DreamsTotalPage(ExtentTest test){
        this.test=test;
        webDriverHelper = new WebDriverHelper(Base.webDriver);
    }

    //Clicked on My Dreams Button
    public void clickOnMyDreamsButton(){
        try{
            webDriverHelper.waitForElementToBeVisible(HomePageLocators.myDreamsButton,10);
            webDriverHelper.clickOnElement(HomePageLocators.myDreamsButton);
            LoggerHandler.info("Clicked on My Dreams Button");
            test.log(Status.INFO,"Clicked on My Dreams Button");
        } catch (Exception e) {
            LoggerHandler.error("Click on My Dream Button Failed");
            test.log(Status.FAIL,"Clicked on My Dreams Button Failed");
        }
    }

    //Switching Tab
    public void switchingTab(){
        Set<String>tabs=Base.webDriver.getWindowHandles();
        List <String> listOfTabs=new ArrayList<>(tabs);
        String dreamTotalTab=listOfTabs.get(2);
        Base.webDriver.switchTo().window(dreamTotalTab);
        LoggerHandler.info("Switched to Dream Total Tab");
        test.log(Status.INFO,"Switched to Dream Total Tab");
        Screenshots.captureFullScreenshot("Dream Total Tab");
        Report.addScreenshot(test,Base.webDriver,"Attached Screenshot to Report");

    }

    //Verify Stats
    public void verifyStats(){
        List<WebElement> list1 = webDriverHelper.getListOfElements(DreamTotalPageLocators.dreamTypeColumn);
        List<WebElement> list2 = webDriverHelper.getListOfElements(DreamTotalPageLocators.totalCountColumns);

        for(int i=0;i<list1.size();i++){

            String dreamType=list1.get(i).getText().trim();
            String totalCount=list2.get(i).getText().trim();

            if(dreamType.equals("Good Dreams") && totalCount.equals("6")){
                LoggerHandler.info("Good Dreams count is correct");
                test.log(Status.INFO,"Good Dreams count is correct");
            } else if (dreamType.equals("Bad Dreams") && totalCount.equals("4")) {
                LoggerHandler.info("Bad Dreams count is correct");
                test.log(Status.INFO,"Bad Dreams count is correct");
            } else if (dreamType.equals("Total Dreams") && totalCount.equals("10")) {
                LoggerHandler.info("Total Dreams count is correct");
                test.log(Status.INFO,"Total Dreams count is correct");
            }else if (dreamType.equals("Recurring Dreams") && totalCount.equals("2")) {
                LoggerHandler.info("Recurring Dreams count is correct");
                test.log(Status.INFO,"Recurring Dreams count is correct");
            }
        }
    }

    //Switching to Dream Diary Tab
    public void switchingToDreamDiaryTab(){
        Set<String>tabs = Base.webDriver.getWindowHandles();
        List <String> listOfTabs = new ArrayList<>(tabs);
        String dreamDiary = listOfTabs.get(1);
        Base.webDriver.switchTo().window(dreamDiary);
        LoggerHandler.info("Switched to Dream Diary Tab");
        test.log(Status.INFO,"Switched to Dream Diary Tab");
        Screenshots.captureFullScreenshot("Switched from Dream total Tab to Dream Diary");
        Report.addScreenshot(test,Base.webDriver,"Attached Screenshot to Report");
    }

    //Asserting Recurring Dream Count
    public void assertRecurringDreams(){
        List <WebElement> elements=webDriverHelper.getListOfElements(DreamsDiaryPageLocators.dreamName);
        int flyingDreamCount=0;
        int lostInMazeCount=0;
        for(WebElement element: elements){
            String recurringDreamType=element.getText().trim();
            if(recurringDreamType.equals("Flying over mountains")){
                flyingDreamCount++;
            }
            if(recurringDreamType.equals("Lost in maze")){
                lostInMazeCount++;
            }
        }
        Assert.assertTrue(flyingDreamCount>1,"Flying over mountains is not Recurring");
        Assert.assertTrue(lostInMazeCount>1,"Lost in Maze is not Recurring");
    }

    public void testCase03(){
        clickOnMyDreamsButton();
        switchingTab();
        verifyStats();
        switchingToDreamDiaryTab();
        assertRecurringDreams();
    }
}

