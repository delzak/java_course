package ru.web.moysklad.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.web.moysklad.model.ProductData;

import java.util.List;

public class TutorialHelper extends HelperBase {
    public TutorialHelper(WebDriver wd) {
        super(wd);
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

    public void clickSixthStepHelp() {
        click(By.xpath("//table[@class='GL-QOY4BH-']/tbody/tr/td[6]/div/div/div[3]"));
    }

    public void clickPopupButton() {
        click(By.xpath("//div[@class='popupContent']//button[.='Далее']"));
    }

    public void clickOverTutorialStepHelp() {
        click(By.xpath("//div[@class='GL-QOY4BI0']//span[.='Продолжить']"));
    }

    public void clickOverTutorial() {
        click(By.xpath("//div[@class='GL-QOY4BI0']//span[.='Закрыть']"));
    }

    public void goToOrganizations() {
        click(By.linkText("Юр. лица"));
    }

    public void goToPurchases() {
        click(By.linkText("Закупки"));
    }

    public void goToSupplies() {
        click(By.linkText("Приёмки"));
    }

    public void goToStore() {
        click(By.linkText("Склад"));
    }

    public void goToStocks() {
        click(By.linkText("Остатки"));
    }

    public void goToSales() {
        click(By.linkText("Продажи"));
    }

    public void goToDemands() {
        click(By.linkText("Отгрузки"));
    }

    public void goToProfitability() {
        click(By.linkText("Прибыльность"));
    }

    public void inputProductInformation(ProductData productData) throws InterruptedException {
        type(By.xpath("//tr[@class='tutorial-stage-sales-fourth-step']/td[2]/input"), productData.getProductName());
        Thread.sleep(500);
        type(By.xpath("//table[@class='price-table']/tbody/tr/td[2]/div/table/tbody/tr/td[1]/div/input"), productData.getProductSum());
    }

    public String getHintText() {
        String text = wd.findElement(By.cssSelector("div.gwt-HTML.GL-QOY4BO5")).getText();
        return text;
    }

    public String getOverTutorialText() {
        String text1 = wd.findElement(By.cssSelector("div.gwt-HTML.GL-QOY4BM0")).getText();
        String text2 = wd.findElement(By.cssSelector("div.gwt-HTML.GL-QOY4BL0")).getText();
        String text3 = wd.findElement(By.xpath("//div[@class='GL-QOY4BI0']//div[.='осталось еще пять.']")).getText();
        return text1 + "\n" + text2 + "\n" + text3;
    }
}
