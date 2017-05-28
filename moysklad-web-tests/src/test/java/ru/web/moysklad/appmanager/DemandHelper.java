package ru.web.moysklad.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class DemandHelper extends HelperBase {

    public DemandHelper(WebDriver wd) {
        super(wd);
    }

    public void clickButtonNewDemand() {
        click(By.xpath("//table[@class='pump-title-panel']//span[.='Отгрузка']"));
    }

    public void setGoodCount(String count) {
        new Actions(wd).moveToElement(wd.findElement(
                By.xpath("//tr[@class='tutorial-inline-editor-table-row']//td[.='00002 Товар[по умолчанию]']"))).build().perform();
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
}
