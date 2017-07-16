package ru.web.moysklad.appmanager.Pages.MyCompany;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.web.moysklad.appmanager.HelperBase;

public class SettingsHelper extends HelperBase {
    public SettingsHelper(WebDriver wd) {
        super(wd);
    }

    public String getTitleText() throws InterruptedException {
        Thread.sleep(100);
        return wd.findElement(By.cssSelector("div.b-manual-name")).getText();
    }
}
