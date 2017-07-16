package ru.web.moysklad.appmanager.Pages.MyCompany;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.web.moysklad.appmanager.HelperBase;

public class AppsHelper extends HelperBase {
    public AppsHelper(WebDriver wd) {
        super(wd);
    }

    public String getTitleText() throws InterruptedException {
        Thread.sleep(100);
        return wd.findElement(By.cssSelector("div.gwt-Label.b-manual-name")).getText();
    }
}
