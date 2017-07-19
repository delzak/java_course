package ru.web.moysklad.appmanager.pages.sales;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import ru.web.moysklad.appmanager.HelperBase;

public class DemandHelper extends HelperBase {

    public DemandHelper(WebDriver wd) {
        super(wd);
    }

    public void clickButtonNewDemand() {
        click(By.xpath("//table[@class='pump-title-panel']//span[.='Отгрузка']"));
    }

    public void setGoodCount(String count) {
        new Actions(wd).moveToElement(wd.findElement(
        By.xpath("//div[@class='gwt-TabPanelBottom']/div[1]/div/table/tbody/tr[1]/td[4]/div/div[2]/div/div/input"))).build().perform();
        type(By.xpath("//div[@class='gwt-TabPanelBottom']/div[1]/div/table/tbody/tr[1]/td[4]/div/div[1]/div/div/input"), count);
    }

    public void clickButtonPrint() {
        click(By.xpath("//table[@class='b-editor-toolbar']//span[.='Печать']"));
    }

    public void selectPrintTorg12() {
        click(By.xpath("//div[@class='popupContent']//td[.='ТОРГ-12']"));
    }

    public void clickActionButtonYes() {
        click(By.xpath("//table[@class='b-action-buttons-wrap']//span[.='Да']"));
    }

    public String getTitleText() throws InterruptedException {
        Thread.sleep(100);
        return wd.findElement(By.cssSelector("div.title")).getText();
    }
}
