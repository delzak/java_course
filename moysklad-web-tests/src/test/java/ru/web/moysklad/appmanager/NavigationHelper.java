package ru.web.moysklad.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void productsAndServices() {
        click(By.linkText("Справочники"));
        click(By.linkText("Товары и услуги"));
    }

    public void supplies() {
        click(By.linkText("Закупки"));
        click(By.linkText("Приёмки"));
    }

    public void stocks() {
        click(By.linkText("Склад"));
        click(By.linkText("Остатки"));
    }
}
