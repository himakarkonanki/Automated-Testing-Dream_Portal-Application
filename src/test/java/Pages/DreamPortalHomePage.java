package Pages;


import Locators.HomePageLocators;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import utils.*;

import java.util.Set;

public class DreamPortalHomePage {
    public WebDriverHelper webDriverHelper;
    public ExtentTest test;

    public DreamPortalHomePage(ExtentTest test){
        this.test=test;
        webDriverHelper= new WebDriverHelper(Base.webDriver);
    }

    //loading animation
    public void verifyLoadingAnimation(){
        long startTime=System.currentTimeMillis();
        webDriverHelper.waitForElementToBeVisible(HomePageLocators.loadingAnimation,10);
        LoggerHandler.info("Loading Animation Visible");
        test.log(Status.INFO,"Loading Animation Visible");

        webDriverHelper.waitForElementToBeInvisible(HomePageLocators.loadingAnimation,10);
        LoggerHandler.info("Loading Animation Invisible");
        test.log(Status.INFO,"Loading Animation Invisible");
        long endTime=System.currentTimeMillis();

        long durationOfLoadingAnimation=(endTime-startTime)/1000;

        LoggerHandler.info("Loader visible for: " + durationOfLoadingAnimation + " seconds");

        if(durationOfLoadingAnimation>0 && durationOfLoadingAnimation<=3){
            LoggerHandler.info("Loading animation is normal");
            test.log(Status.INFO,"Loading Animation is normal");
        }else {
            LoggerHandler.error("Loading animation is not normal");
            test.log(Status.FAIL,"Loading Animation is not normal");
        }
    }

    //Clicking on My Dreams Button
    public void clickOnMyDreamsButton(){
        try{
            webDriverHelper.waitForElementToBeVisible(HomePageLocators.myDreamsButton,10);
            webDriverHelper.clickOnElement(HomePageLocators.myDreamsButton);
            LoggerHandler.info("Clicked on My Dreams Button");
            test.log(Status.INFO,"Clicked on My Dreams Button");
        } catch (Exception e) {
            LoggerHandler.error("Click on My Dream Button Failed");
            test.log(Status.FAIL,"Click on My Dream Button Failed");
        }
    }

    //Verifying two tabs opened
    public void verifyDreamsDiaryTab(){
        Set<String> allWindows = Base.webDriver.getWindowHandles();
        for (String window : allWindows) {
            Base.webDriver.switchTo().window(window);
            if (Base.webDriver.getCurrentUrl().contains("dreams-diary.html")) {
                String title=Base.webDriver.getTitle();
                LoggerHandler.info(title);
                Assert.assertEquals(title,"Dreams Diary");
                Screenshots.captureFullScreenshot("Dream Diary Tab");
                Report.addScreenshot(test,Base.webDriver,"Attached Screenshot to Report");
            } else if (Base.webDriver.getCurrentUrl().contains("dreams-total.html")) {
                String title1=Base.webDriver.getTitle();
                System.out.println(title1);
                Assert.assertEquals(title1,"Dreams Total");
                Screenshots.captureFullScreenshot("Dreams Total Tab");
                Report.addScreenshot(test,Base.webDriver,"Attached Screenshot to Report");
            }
        }
    }

    public void testCase01(){
        verifyLoadingAnimation();
        clickOnMyDreamsButton();
        try {
            Thread.sleep(3000);
            verifyDreamsDiaryTab();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
