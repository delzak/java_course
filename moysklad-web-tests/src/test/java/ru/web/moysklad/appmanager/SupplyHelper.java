package ru.web.moysklad.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SupplyHelper extends HelperBase{

    public SupplyHelper(WebDriver wd) {
        super(wd);
    }

    public void clickButtonNewSupply() {
        click(By.xpath("//table[@class='pump-title-panel']//span[.='Приемка']"));
    }

    public void setGoodCount(String count) {
        type(By.xpath("//div[@class='gwt-TabPanelBottom']/div[1]/div/table/tbody/tr[1]/td[4]/div/div[2]/div/div/input"), count);
    }

    public void setPrice(String price) {
        type(By.xpath("//div[@class='gwt-TabPanelBottom']/div[1]/div/table/tbody/tr[1]/td[11]/div/div[2]/div/input"), price);
    }
}
