package ru.web.moysklad.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ClickHelper {
    private FirefoxDriver wd;

    public ClickHelper(FirefoxDriver wd) {
        this.wd = wd;
    }

    public void clickOverTutorialStepHelp() {
        wd.findElement(By.xpath("//div[@class='GL-QOY4BI0']//span[.='Продолжить']")).click();
    }

    public void clickCloseButton() {
        wd.findElement(By.xpath("//table[@class='b-editor-toolbar']//span[.='Закрыть']")).click();
    }

    public void clickSaveButton() {
        wd.findElement(By.xpath("//table[@class='b-editor-toolbar']//span[.='Сохранить']")).click();
    }

    public void clickPopupButton() {
        wd.findElement(By.xpath("//div[@class='popupContent']//button[.='Далее']")).click();
    }

    public void clickFirstStepHelp() {
        wd.findElement(By.xpath("//table[@class='GL-QOY4BH-']/tbody/tr/td[1]/div/div/div[1]/img[3]")).click();
    }

    public void clickHelp() {
        wd.findElement(By.xpath("//table[@class='info']//span[.='Помощь']")).click();
    }

    public void clickButtonNewProduct() {
        wd.findElement(By.xpath("//table[@class='pump-title-panel']/tbody/tr/td[2]/div/table/tbody/tr/td[2]")).click();
    }

    public void clickSecondStepHelp() {
        wd.findElement(By.cssSelector("div.gwt-Label.GL-QOY4BOU")).click();
    }
}
