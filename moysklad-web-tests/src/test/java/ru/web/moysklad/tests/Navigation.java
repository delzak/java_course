package ru.web.moysklad.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Navigation extends TestBase{

    @Test
    public void testNavigation() throws InterruptedException {
        //Навигация во вкладке "Моя компания"
        assertEquals("Просроченные заказы", app.dashboard().getOverdueOrderText());
        app.goTo().organizations();
        assertEquals("Юр. лица", app.organization().getTitleText());
        app.goTo().employees();
        assertEquals("Сотрудники", app.employees().getTitleText());
        app.goTo().storages();
        assertEquals("Склады", app.storages().getTitleText());
        app.goTo().documents();
        assertEquals("Документы", app.documents().getTitleText());
        app.goTo().recyclebin();
        assertEquals("Корзина", app.recyclebin().getTitleText());
        app.goTo().settings();
        assertEquals("Настройки", app.settings().getTitleText());
        app.goTo().apps();
        assertEquals("Приложения", app.apps().getTitleText());
        app.goTo().subscription();
        assertEquals("Подписка", app.subscription().getTitleText());
        app.goTo().specialOffer();
        assertEquals("Предложения от наших партнеров", app.special().getTitleText());

        //Навигация во вкладке "Розница"
        app.goTo().retail();
        app.goTo().retailStore();
        assertEquals("Точки продаж", app.retailStore().getTitleText());
        app.goTo().retailShift();
        assertEquals("Смены", app.retailShift().getTitleText());
        app.goTo().retailDemand();
        assertEquals("Продажи", app.retailDemand().getTitleText());
        app.goTo().retailSalesReturn();
        assertEquals("Возвраты", app.retailSalesReturn().getTitleText());
        app.goTo().retaildrawercashin();
        assertEquals("Внесения", app.retailDrawerCashin().getTitleText());
        app.goTo().retaildrawercashout();
        assertEquals("Выплаты", app.retailDrawerCashout().getTitleText());

        //Навигация во вкладке "Закупки"

        //Навигация во вкладке "Продажи"

        //Навигация во вклакде "Склад"

        //Навигация во вкладке "Деньги"

        //Навигация во вкладке "Справочники"
    }
}
