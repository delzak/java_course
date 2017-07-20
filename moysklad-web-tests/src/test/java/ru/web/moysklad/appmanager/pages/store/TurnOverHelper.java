package ru.web.moysklad.appmanager.pages.store;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.web.moysklad.appmanager.HelperBase;

public class TurnOverHelper extends HelperBase {
    public TurnOverHelper(WebDriver wd) {
        super(wd);
    }

    public String getTitleText() throws InterruptedException {
        Thread.sleep(100);
        return wd.findElement(By.xpath("//table[@class='help-wrapper']//div[.='Обороты']")).getText();
    }
}
