package ru.web.moysklad.appmanager.pages.purchases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.web.moysklad.appmanager.HelperBase;

public class PurchaseControlHelper extends HelperBase {
    public PurchaseControlHelper(WebDriver wd) {
        super(wd);
    }

    public String getTitleText() throws InterruptedException {
        Thread.sleep(100);
        return wd.findElement(By.xpath("//table[@class='help-wrapper']//div[.='Управление закупками']")).getText();
    }
}
