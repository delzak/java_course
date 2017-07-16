package ru.web.moysklad.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RetailShiftHelper extends HelperBase {
    public RetailShiftHelper(WebDriver wd) {
        super(wd);
    }

    public String getTitleText() throws InterruptedException {
        Thread.sleep(300);
        return wd.findElement(By.cssSelector("div.title")).getText();
    }
}
