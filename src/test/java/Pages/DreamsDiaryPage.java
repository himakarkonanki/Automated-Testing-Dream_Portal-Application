package Pages;

import Locators.DreamsDiaryPageLocators;
import Locators.HomePageLocators;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.Base;
import utils.LoggerHandler;
import utils.WebDriverHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



public class DreamsDiaryPage {

    public WebDriverHelper webDriverHelper;
    public ExtentTest test;

    public DreamsDiaryPage(ExtentTest test){
        this.test=test;
        webDriverHelper= new WebDriverHelper(Base.webDriver);
    }

    //Click on My Dreams Button
    public void clickOnMyDreamsButton(){
        try{
            webDriverHelper.waitForElementToBeVisible(HomePageLocators.myDreamsButton,10);
            webDriverHelper.clickOnElement(HomePageLocators.myDreamsButton);
            LoggerHandler.info("Clicked on My Dreams Button");
            test.log(Status.INFO,"Clicked on Dreams Button");
        } catch (Exception e) {
            test.log(Status.INFO,"Clicked on Dreams Button Failed");
            LoggerHandler.error("Click on My Dream Button Failed");
        }
    }

    //Switching to Dreams Diary Page
    public void switchTab(){
        Set <String> tabs = Base.webDriver.getWindowHandles();
        List<String> list= new ArrayList<>(tabs);
        System.out.println(list);
        String dreamsDiary=list.get(1);
        Base.webDriver.switchTo().window(dreamsDiary);
        String currentTab=Base.webDriver.getTitle();
        LoggerHandler.info(currentTab);
        test.log(Status.INFO,"Tab switched successfully");
    }

    //Validating Dream Entries
    public void validateDreamEntries() {
        try {
            List<WebElement> list = webDriverHelper.getListOfElements(DreamsDiaryPageLocators.dreamEntries);
            System.out.println(list.size());
            Assert.assertEquals(list.size(), 10);
            LoggerHandler.info("Dream entries validated");
            test.log(Status.INFO,"Dream Entries validated");
        } catch (Exception e) {
            LoggerHandler.error("Dream Entries validation failed");
            test.log(Status.FAIL,"Dream Entries validation failed");
        }
    }

    //Validating Dream Types
    public void validateDreamTypes(){
        List <WebElement> dreamTypes = webDriverHelper.getListOfElements(DreamsDiaryPageLocators.dreamType);
        boolean validate=true;
        for(WebElement dreamType : dreamTypes){
            if(!dreamType.getText().equals("Good") && !dreamType.getText().equals("Bad")){
                LoggerHandler.error("Dream Types validation failed");
                test.log(Status.FAIL,"Dream Types validation failed");
                validate=false;
            }
        }
        if(validate){
            LoggerHandler.info("Dream Types validation successful.");
            test.log(Status.INFO,"Dream Types validation successful.");
        }
    }

    //Validating Column Headings
    public void verifyColumnHeadings(){
        try{
            List <WebElement> rows = webDriverHelper.getListOfElements(DreamsDiaryPageLocators.rowHeadings);
            for(WebElement rowElement :rows){
                String text=rowElement.getText();
                System.out.println(text);
                if(text.equals("Dream Name")  || text.equals("Days Ago") || text.equals("Dream Type")){
                    LoggerHandler.info("Verified successfully " +rowElement.getText());
                    test.log(Status.INFO,"Verified successfully " +rowElement.getText());
                }
            }
        }catch (Exception e){
            LoggerHandler.error(e.getMessage());
            test.log(Status.INFO,"Verification Unsuccessful");
        }
    }

    public void testCase02(){
        clickOnMyDreamsButton();
        switchTab();
        validateDreamEntries();
        validateDreamTypes();
        verifyColumnHeadings();
    }
}
