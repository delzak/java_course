package ru.web.moysklad.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.web.moysklad.model.OrganizationData;
import ru.web.moysklad.model.ProductData;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    FirefoxDriver wd;

    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public void initialization() {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.get("https://online-1.moysklad.ru/");
        login("admin@ab1", "111111");
    }

    private void login(String accountname, String password) {
        wd.findElement(By.id("lable-login")).click();
        wd.findElement(By.id("lable-login")).clear();
        wd.findElement(By.id("lable-login")).sendKeys(accountname);
        wd.findElement(By.id("lable-password")).click();
        wd.findElement(By.id("lable-password")).clear();
        wd.findElement(By.id("lable-password")).sendKeys(password);
        wd.findElement(By.id("submit")).click();
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

    public void inputOrganizationInformation(OrganizationData organizationData) {
        wd.findElement(By.xpath("//tr[@class='tutorial-stage-company-fifth-step']/td[2]/input")).click();
        wd.findElement(By.xpath("//tr[@class='tutorial-stage-company-fifth-step']/td[2]/input")).clear();
        wd.findElement(By.xpath("//tr[@class='tutorial-stage-company-fifth-step']/td[2]/input")).sendKeys(organizationData.getOrganizationName());
    }

    public void selectFirstOrganization() {
        wd.findElement(By.xpath("//table[@id='DocumentTableMyCompany']/tbody[1]/tr/td[10]")).click();
    }

    public void goToOrganizations() {
        wd.findElement(By.linkText("Юр. лица")).click();
    }

    public void clickFirstStepHelp() {
        wd.findElement(By.xpath("//table[@class='GL-QOY4BH-']/tbody/tr/td[1]/div/div/div[1]/img[3]")).click();
    }

    public void clickHelp() {
        wd.findElement(By.xpath("//table[@class='info']//span[.='Помощь']")).click();
    }

    public void stop() {
        wd.quit();
    }

    public void inputProductInformation(ProductData productData) throws InterruptedException {
        wd.findElement(By.xpath("//tr[@class='tutorial-stage-sales-fourth-step']/td[2]/input")).click();
        wd.findElement(By.xpath("//tr[@class='tutorial-stage-sales-fourth-step']/td[2]/input")).clear();
        wd.findElement(By.xpath("//tr[@class='tutorial-stage-sales-fourth-step']/td[2]/input")).sendKeys(productData.getProductName());
        Thread.sleep(500);
        wd.findElement(By.xpath("//table[@class='price-table']/tbody/tr/td[2]/div/table/tbody/tr/td[1]/div/input")).click();
        wd.findElement(By.xpath("//table[@class='price-table']/tbody/tr/td[2]/div/table/tbody/tr/td[1]/div/input")).clear();
        wd.findElement(By.xpath("//table[@class='price-table']/tbody/tr/td[2]/div/table/tbody/tr/td[1]/div/input")).sendKeys(productData.getProductSum());
    }

    public void clickButtonNewProduct() {
        wd.findElement(By.xpath("//table[@class='pump-title-panel']/tbody/tr/td[2]/div/table/tbody/tr/td[2]")).click();
    }

    public void goToProductsAndServices() {
        wd.findElement(By.linkText("Товары и услуги")).click();
    }

    public void goToCatalog() {
        wd.findElement(By.linkText("Справочники")).click();
    }

    public void clickSecondStepHelp() {
        wd.findElement(By.cssSelector("div.gwt-Label.GL-QOY4BOU")).click();
    }
}
