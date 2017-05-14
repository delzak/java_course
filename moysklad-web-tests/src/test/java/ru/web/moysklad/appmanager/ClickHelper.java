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

    public void clickFourthStepHelp() {
        click(By.xpath("//table[@class='GL-QOY4BH-']/tbody/tr/td[4]/div/div/div[3]"));
    }

    public void clickFifthStepHelp() {
        click(By.xpath("//table[@class='GL-QOY4BH-']/tbody/tr/td[5]/div/div/div[3]"));
    }

    public void openListOfCounterparty() {
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

    public void clickSixthStepHelp() {
        click(By.xpath("//table[@class='GL-QOY4BH-']/tbody/tr/td[6]/div/div/div[3]"));
    }

    public void clickOverTutorial() {
        click(By.xpath("//div[@class='GL-QOY4BI0']//span[.='Закрыть']"));
    }
}
