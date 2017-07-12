package ru.web.moysklad.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    //Вкладка "Моя компания"

    public void myCompany() {
        click(By.linkText("Моя компания"));
    }

    public void dashboard() {
        click(By.linkText("Показатели"));
    }

    public void organizations() {
        click(By.linkText("Юр. лица"));
    }

    public void employees() {
        click(By.linkText("Сотрудники"));
    }

    public void storages() {
        click(By.linkText("Склады"));
    }

    public void documents() {
        click(By.linkText("Документы"));
    }

    public void recyclebin() {
        click(By.linkText("Корзина"));
    }

    public void settings() {
        click(By.linkText("Настройки"));
    }

    public void apps() {
        click(By.linkText("Приложения"));
    }

    public void subscriprion() {
        click(By.linkText("Подписка"));
    }

    public void specialOffer() {
        click(By.linkText("Спецпредложение"));
    }

    //Вкладка "Розница"

    public void catalog() {
        click(By.linkText("Справочники"));
    }

    public void productsAndServices() {
        click(By.linkText("Товары и услуги"));
    }

    public void purchases() {
        click(By.linkText("Закупки"));
    }

    public void supplies() {
        click(By.linkText("Приёмки"));
    }

    public void sales() {
        click(By.linkText("Продажи"));
    }

    public void demands() {
        click(By.linkText("Отгрузки"));
    }

    public void store() {
        click(By.linkText("Склад"));
    }

    public void stocks() {
        click(By.linkText("Остатки"));
    }

    public void profitability() {
        click(By.linkText("Прибыльность"));
    }
}
