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
        assertEquals("Сотрудники", app.employee().getTitleText());
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
        app.goTo().purchases();
        app.goTo().purchaseOrder();
        assertEquals("Заказы поставщикам", app.purchaseOrder().getTitleText());
        app.goTo().invoiceIn();
        assertEquals("Счета поставщиков", app.invoiceIn().getTitleText());
        app.goTo().supply();
        assertEquals("Приемки", app.supply().getTitleText());
        app.goTo().purchaseReturn();
        assertEquals("Возвраты поставщикам", app.purchaseReturn().getTitleText());
        app.goTo().factureIn();
        assertEquals("Счета-фактуры полученные", app.factureIn().getTitleText());
        app.goTo().purchaseControl();
        assertEquals("Управление закупками", app.purchaseControl().getTitleText());

        //Навигация во вкладке "Продажи"
        app.goTo().sales();
        app.goTo().customerOrder();
        assertEquals("Заказы покупателей", app.customerOrder().getTitleText());
        app.goTo().invoiceOut();
        assertEquals("Счета покупателям", app.invoiceOut().getTitleText());
        app.goTo().demand();
        assertEquals("Отгрузки", app.demand().getTitleText());
        app.goTo().commissionReportIn();
        assertEquals("Полученные отчеты комиссионера", app.commissionReportIn().getTitleText());
        app.goTo().commissionReportOut();
        assertEquals("Выданные отчеты комиссионера", app.commissionReportOut().getTitleText());
        app.goTo().salesReturn();
        assertEquals("Возврат покупателя", app.salesReturn().getTitleText());
        app.goTo().factureOut();
        assertEquals("Счета-фактуры выданные", app.factureOut().getTitleText());
        app.goTo().pricelist();
        assertEquals("Прайс-листы", app.pricelist().getTitleText());
        app.goTo().discount();
        assertEquals("Скидки", app.discount().getTitleText());
        app.goTo().profitability();
        assertEquals("Прибыльность", app.profitability().getTitleText());
        app.goTo().comissionGoods();
        assertEquals("Товары на реализации", app.commissionGoods().getTitleText());
        app.goTo().purchaseFunnel();
        assertEquals("Воронка продаж", app.purchaseFunnel().getTitleText());

        //Навигация во вклакде "Склад"
        app.goTo().store();
        app.goTo().loss();
        assertEquals("Списания", app.loss().getTitleText());
        app.goTo().enter();
        assertEquals("Оприходования", app.enter().getTitleText());
        app.goTo().move();
        assertEquals("Перемещения", app.move().getTitleText());
        app.goTo().inventory();
        assertEquals("Инвентаризации", app.inventory().getTitleText());
        app.goTo().processing();
        assertEquals("Технологические операции", app.processing().getTitleText());
        app.goTo().processingPlan();
        assertEquals("Тех. карты", app.processingPlan().getTitleText());
        app.goTo().processingOrder();
        assertEquals("Заказы на производство", app.processingOrder().getTitleText());
        app.goTo().internalOrder();
        assertEquals("Внутренние заказы", app.internalOrder().getTitleText());
        app.goTo().stocks();
        assertEquals("Остатки", app.stocks().getTitleText());
        app.goTo().turnOver();
        assertEquals("Обороты", app.turnOver().getTitleText());
        app.goTo().serialNumber();
        assertEquals("Сер. номера", app.serialNumber().getTitleText());

        //Навигация во вкладке "Деньги"
        app.goTo().money();
        app.goTo().finance();
        assertEquals("Платежи", app.finance().getTitleText());
        app.goTo().cashFlow();
        assertEquals("Движение денежных средств", app.cashFlow().getTitleText());
        app.goTo().customersBalanceList();
        assertEquals("Взаиморасчеты", app.customersBalanceList().getTitleText());
        app.goTo().pnl();
        assertEquals("Прибыли и убытки", app.pnl().getTitleText());

        //Навигация во вкладке "Справочники"
        app.goTo().catalog();
        app.goTo().good();
        assertEquals("Товары и услуги", app.good().getTitleText());
        app.goTo().counterparty();
        assertEquals("Контрагенты", app.counterparty().getTitleText());
        app.goTo().currency();
        assertEquals("Валюты", app.currency().getTitleText());
        app.goTo().project();
        assertEquals("Проекты", app.project().getTitleText());
        app.goTo().contract();
        assertEquals("Договоры", app.contract().getTitleText());
    }
}
