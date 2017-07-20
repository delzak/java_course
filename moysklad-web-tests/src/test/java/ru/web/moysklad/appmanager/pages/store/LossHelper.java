package ru.web.moysklad.appmanager.pages.store;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.web.moysklad.appmanager.HelperBase;

public class LossHelper extends HelperBase {
    public LossHelper(WebDriver wd) {
        super(wd);
    }

    public String getTitleText() throws InterruptedException {
        Thread.sleep(150);
        return wd.findElement(By.cssSelector("div.title")).getText();
    }
}
