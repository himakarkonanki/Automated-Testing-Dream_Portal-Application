package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.time.Duration;

public class Base {
    public static WebDriver webDriver;

    public static void openBrowser() throws MalformedURLException {
        webDriver=new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.manage().window().maximize();
        webDriver.get("https://arjitnigam.github.io/myDreams/");
    }
}
