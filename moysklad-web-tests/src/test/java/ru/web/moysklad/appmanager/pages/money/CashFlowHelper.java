package ru.web.moysklad.appmanager.pages.money;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.web.moysklad.appmanager.HelperBase;

public class CashFlowHelper extends HelperBase {
    public CashFlowHelper(WebDriver wd) {
        super(wd);
    }

    public String getTitleText() throws InterruptedException {
        Thread.sleep(100);
        return wd.findElement(By.xpath("//table[@class='help-wrapper']//div[.='Движение денежных средств']")).getText();
    }
}
