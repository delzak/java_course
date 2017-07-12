package ru.web.moysklad.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ClickHelper extends HelperBase {

    public ClickHelper(WebDriver wd) {
        super(wd);
    }

    public void closeButton() {
        click(By.xpath("//table[@class='b-editor-toolbar']//span[.='Закрыть']"));
    }

    public void saveButton() {
        click(By.xpath("//table[@class='b-editor-toolbar']//span[.='Сохранить']"));
    }

    public void help() {
        click(By.xpath("//table[@class='info']//span[.='Помощь']"));
    }

    public void listOfCounterparty() {
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

    public void addBarcodePosition(String barcode) {
        type(By.xpath("//div[@class='b-delivery-actionbar']/input"), barcode);
        wd.findElement(By.xpath("//div[@class='b-delivery-actionbar']/input")).sendKeys(Keys.RETURN);
    }

    public void catalogButton() {
        click(By.xpath("//div[@class='b-delivery-actionbar']//span[.='Справочник']"));
    }

    public void addGoodFromCatalog() {
        click(By.xpath("//div[@class='tablePanel']/table[1]/tbody[1]/tr/td[3]/div/div"));
        click(By.xpath("//table[@class='b-action-buttons-wrap']//span[.='Выбрать']"));
    }
}
