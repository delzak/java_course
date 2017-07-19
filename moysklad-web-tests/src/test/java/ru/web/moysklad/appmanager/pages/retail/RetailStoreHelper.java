package ru.web.moysklad.appmanager.pages.retail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.web.moysklad.appmanager.HelperBase;

public class RetailStoreHelper extends HelperBase {
    public RetailStoreHelper(WebDriver wd) {
        super(wd);
    }

    public String getTitleText() throws InterruptedException {
        Thread.sleep(100);
        return wd.findElement(By.cssSelector("div.page-title-margin")).getText();
    }
}
