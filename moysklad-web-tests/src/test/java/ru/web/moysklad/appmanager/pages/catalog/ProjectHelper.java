package ru.web.moysklad.appmanager.pages.catalog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.web.moysklad.appmanager.HelperBase;

public class ProjectHelper extends HelperBase {
    public ProjectHelper(WebDriver wd) {
        super(wd);
    }
    public String getTitleText() throws InterruptedException {
        Thread.sleep(100);
        return wd.findElement(By.cssSelector("div.title")).getText();
    }
}
