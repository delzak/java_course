package ru.web.moysklad.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void goToTutorialOrganizations() {
        click(By.linkText("Юр. лица"));
    }

    public void goToProductsAndServices() {
        click(By.linkText("Справочники"));
        click(By.linkText("Товары и услуги"));
    }

    public void goToTutorialPurchases() {
        click(By.linkText("Закупки"));
    }

    public void goToTutorialSupplies() {
        click(By.linkText("Приёмки"));
    }

    public void goToSupplies() {
        click(By.linkText("Закупки"));
        click(By.linkText("Приёмки"));
    }

    public void goToTutorialStore() {
        click(By.linkText("Склад"));
    }

    public void goToTutorialStocks() {
        click(By.linkText("Остатки"));
    }

    public void goToStocks() {
        click(By.linkText("Склад"));
        click(By.linkText("Остатки"));
    }
}
