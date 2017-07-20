package ru.web.moysklad.appmanager.pages.store;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.web.moysklad.appmanager.HelperBase;

public class SerialNumberHelper extends HelperBase {
    public SerialNumberHelper(WebDriver wd) {
        super(wd);
    }

    public String getTitleText() throws InterruptedException {
        Thread.sleep(100);
        return wd.findElement(By.xpath("//table[@class='help-wrapper']//div[.='Сер. номера']")).getText();
    }
}
