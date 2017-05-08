package ru.web.moysklad.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ClickHelper extends HelperBase {

    public ClickHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void clickOverTutorialStepHelp() {
        click(By.xpath("//div[@class='GL-QOY4BI0']//span[.='Продолжить']"));
    }

    public void clickCloseButton() {
        click(By.xpath("//table[@class='b-editor-toolbar']//span[.='Закрыть']"));
    }

    public void clickSaveButton() {
        click(By.xpath("//table[@class='b-editor-toolbar']//span[.='Сохранить']"));
    }

    public void clickPopupButton() {
        click(By.xpath("//div[@class='popupContent']//button[.='Далее']"));
    }

    public void clickHelp() {
        click(By.xpath("//table[@class='info']//span[.='Помощь']"));
    }

    public void clickFirstStepHelp() {
        click(By.xpath("//table[@class='GL-QOY4BH-']/tbody/tr/td[1]/div/div/div[1]/img[3]"));
    }

    public void clickSecondStepHelp() {
        click(By.cssSelector("div.gwt-Label.GL-QOY4BOU"));
    }

    public void clickThirdStepHelp() {
        click(By.xpath("//table[@class='GL-QOY4BH-']/tbody/tr/td[3]/div/div/div[3]"));
    }


}
