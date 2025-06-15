package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class WebDriverHelper {
    public WebDriver webDriver;

    public WebDriverHelper(WebDriver webDriver){
        this.webDriver=webDriver;
    }

    public void clickOnElement(By locator){
        webDriver.findElement(locator).click();
    }

    public void waitForElementToBeVisible(By locator, int seconds){
        WebDriverWait wait=new WebDriverWait(webDriver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForElementToBeInvisible(By locator, int seconds){
        WebDriverWait wait=new WebDriverWait(webDriver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public List<WebElement> getListOfElements(By locator){
        return webDriver.findElements(locator);
    }




}
