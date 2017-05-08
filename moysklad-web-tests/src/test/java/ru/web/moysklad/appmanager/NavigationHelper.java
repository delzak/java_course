package ru.web.moysklad.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void goToOrganizations() {
        click(By.linkText("Юр. лица"));
    }

    public void goToProductsAndServices() {
        click(By.linkText("Товары и услуги"));
    }

    public void goToCatalog() {
        click(By.linkText("Справочники"));
    }
}
