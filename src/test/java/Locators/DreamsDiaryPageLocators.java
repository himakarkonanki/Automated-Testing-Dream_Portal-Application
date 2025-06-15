package Locators;

import org.openqa.selenium.By;

public class DreamsDiaryPageLocators {
    public static By dreamEntries=By.xpath("//table//tbody//tr");
    public static By dreamType=By.xpath("//tbody//tr//td[3]");
    public static By rowHeadings=By.xpath("//thead//tr//th");
    public static By dreamName=By.xpath("//tbody/tr/td[1]");
}
