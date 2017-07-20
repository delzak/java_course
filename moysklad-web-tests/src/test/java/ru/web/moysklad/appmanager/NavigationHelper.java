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

    public void purchaseOrder() {
        click(By.linkText("Заказы поставщикам"));
    }

    public void invoiceIn() {
        click(By.linkText("Счета поставщиков"));
    }

    public void supply() {
        click(By.linkText("Приемки"));
    }

    public void purchaseReturn() {
        click(By.linkText("Возвраты поставщикам"));
    }

    public void factureIn() {
        click(By.linkText("Счета-фактуры полученные"));
    }

    public void purchaseControl() {
        click(By.linkText("Управление закупками"));
    }

    //Вкладка "Продажи"

    public void sales() {
        click(By.linkText("Продажи"));
    }

    public void customerOrder() {
        click(By.linkText("Заказы покупателей"));
    }

    public void invoiceOut() {
        click(By.linkText("Счета покупателям"));
    }

    public void demand() {
        click(By.linkText("Отгрузки"));
    }

    public void commissionReportIn() {
        click(By.linkText("Полученные отчеты комиссионера"));
    }

    public void commissionReportOut() {
        click(By.linkText("Выданные отчеты комиссионера"));
    }

    public void salesReturn() {
        click(By.linkText("Возвраты покупателей"));
    }

    public void factureOut() {
        click(By.linkText("Счета-фактуры выданные"));
    }

    public void pricelist() {
        click(By.linkText("Прайс-листы"));
    }

    public void discount() {
        click(By.linkText("Скидки"));
    }

    public void profitability() {
        click(By.linkText("Прибыльность"));
    }

    public void comissionGoods() {
        click(By.linkText("Товары на реализации"));
    }

    public void purchaseFunnel() {
        click(By.linkText("Воронка продаж"));
    }

    //Вкладка "Склад"

    public void store() {
        click(By.linkText("Склад"));
    }

    public void loss() {
        click(By.linkText("Списания"));
    }

    public void enter() {
        click(By.linkText("Оприходования"));
    }

    public void move() {
        click(By.linkText("Перемещения"));
    }

    public void inventory() {
        click(By.linkText("Инвентаризации"));
    }


    public void processing() {
        click(By.linkText("Тех. операции"));
    }

    public void processingPlan() {
        click(By.linkText("Тех. карты"));
    }

    public void processingOrder() {
        click(By.linkText("Заказы на производство"));
    }

    public void internalOrder() {
        click(By.linkText("Внутренние заказы"));
    }

    public void stocks() {
        click(By.linkText("Остатки"));
    }

    public void turnOver() {
        click(By.linkText("Обороты"));
    }

    public void serialNumber() {
        click(By.linkText("Сер. номера"));
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
