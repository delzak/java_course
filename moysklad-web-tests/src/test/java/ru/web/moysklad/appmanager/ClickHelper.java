package ru.web.moysklad.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
}
