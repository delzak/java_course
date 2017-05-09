package ru.web.moysklad.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SupplyHelper extends HelperBase{

    public SupplyHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void clickButtonNewSupply() {
        click(By.xpath("//table[@class='pump-title-panel']//span[.='Приемка']"));
    }

    public void getListOfCounterparty() {
        click(By.xpath("//div[@class='tutorial-counter-party-field']/table[1]/tbody/tr/td[1]/table/tbody/tr/td[3]/div/div"));
    }

    public void selectCounterparty() {
        click(By.xpath("//div[@class='popupContent']/table/tbody/tr/td[2]/div/div/div/table/tbody[1]/tr[2]/td/div/div[1]"));
    }

    public void addPosition(String positionName) {
        type(By.xpath("//div[@class='b-delivery-actionbar']/input"), positionName);

    }

    public void selectGood() {
        click(By.cssSelector("div[class='gwt-HTML'"));
    }

    public void setGoodCount(String count) {
        type(By.xpath("//div[@class='gwt-TabPanelBottom']/div[1]/div/table/tbody/tr[1]/td[4]/div/div[2]/div/div/input"), count);
    }

    public void setPrice(String price) {
        type(By.xpath("//div[@class='gwt-TabPanelBottom']/div[1]/div/table/tbody/tr[1]/td[11]/div/div[2]/div/input"), price);
    }
}
