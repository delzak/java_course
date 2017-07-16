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

    public void subscription() {
        click(By.linkText("Подписка"));
    }

    public void specialOffer() {
        click(By.linkText("Спецпредложение"));
    }

    //Вкладка "Розница"

    public void retail() {
        click(By.linkText("Розница"));
    }

    public void retailStore() {
        click(By.linkText("Точки продаж"));
    }

    public void retailShift() {
        click(By.linkText("Смены"));
    }

    public void retailDemand() {
        click(By.xpath("//div[@class='subMenu']/span[3]/a/span"));
    }

    public void retailSalesReturn() {
        click(By.linkText("Возвраты"));
    }

    public void retaildrawercashin() {
        click(By.linkText("Внесения"));
    }

    public void retaildrawercashout() {
        click(By.linkText("Выплаты"));
    }

    //Вкладка "Закупки

    public void purchases() {
        click(By.linkText("Закупки"));
    }

    public void supplies() {
        click(By.linkText("Приёмки"));
    }

    //Вкладка "Продажи"

    public void sales() {
        click(By.linkText("Продажи"));
    }

    public void demands() {
        click(By.linkText("Отгрузки"));
    }

    //Вкладка "Склад"

    public void store() {
        click(By.linkText("Склад"));
    }

    public void stocks() {
        click(By.linkText("Остатки"));
    }

    public void profitability() {
        click(By.linkText("Прибыльность"));
    }

    //Вкладка "Деньги"

    //Вкладка "Справочники"

    public void catalog() {
        click(By.linkText("Справочники"));
    }

    public void productsAndServices() {
        click(By.linkText("Товары и услуги"));
    }








}
