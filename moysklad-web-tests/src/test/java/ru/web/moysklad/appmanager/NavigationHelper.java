package ru.web.moysklad.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper {
    private FirefoxDriver wd;

    public NavigationHelper(FirefoxDriver wd) {
        this.wd = wd;
    }

    public void goToOrganizations() {
        wd.findElement(By.linkText("Юр. лица")).click();
    }

    public void goToProductsAndServices() {
        wd.findElement(By.linkText("Товары и услуги")).click();
    }

    public void goToCatalog() {
        wd.findElement(By.linkText("Справочники")).click();
    }
}
