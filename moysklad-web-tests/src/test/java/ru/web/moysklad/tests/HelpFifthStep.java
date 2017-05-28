package ru.web.moysklad.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HelpFifthStep extends TestBase{

    @Test
    public void testHelpSale() {
        app.click().help();
        app.tutorial().clickFifthStepHelp();
        assertEquals(app.tutorial().getHintText(), "Нажмите на вкладку «Продажи»");
        app.tutorial().goToSales();
        assertEquals(app.tutorial().getHintText(), "Перейдите в раздел «Отгрузки»");
        app.tutorial().goToDemands();
        assertEquals(app.tutorial().getHintText(), "Чтобы учесть продажу, нажмите кнопку «+ Отгрузка»");
        app.demand().clickButtonNewDemand();
        assertEquals(app.tutorial().getHintText(), "Нажмите на стрелочку, чтобы выбрать контрагента");
        app.click().listOfCounterparty();
        assertEquals(app.tutorial().getHintText(), "Выберите Покупателя");
        app.click().selectCounterparty();
        assertEquals(app.tutorial().getHintText(), "Добавьте товар в отгрузку. Вы можете сделать это, введя " +
                "его наименование и выбрав соответствующий товар из списка, либо же выбрав его из Справочника или Остатков.");
        app.click().addPosition("Товар");
        assertEquals(app.tutorial().getHintText(), "Нажмите на товар, чтобы добавить его в отгрузку");
        app.click().selectGood();
        assertEquals(app.tutorial().getHintText(), "Вы можете назначить товарам штрих-коды и " +
                "использовать сканер для добавления в документ");
        app.tutorial().clickPopupButton();
        assertEquals(app.tutorial().getHintText(), "Укажите кол-во товара - 2");
        app.demand().setGoodCount("2");
        assertEquals(app.tutorial().getHintText(), "Цена автоматически подставилась из " +
                "справочника, но вы можете изменить ее");
        app.tutorial().clickPopupButton();
        assertEquals(app.tutorial().getHintText(), "Нажмите кнопку «Печать»");
        app.demand().clickButtonPrint();
        assertEquals(app.tutorial().getHintText(), "Нажмите на пункт «ТОРГ-12»");
        app.demand().selectPrintTorg12();
        assertEquals(app.tutorial().getHintText(), "Нажмите кнопку «Да»");
        app.demand().clickActionButtonYes();
        assertEquals(app.tutorial().getHintText(), "Вы создали накладную, она была сохранена на ваш компьютер");
        app.tutorial().clickPopupButton();
        assertEquals(app.tutorial().getHintText(), "Вы можете добавлять собственные шаблоны документов");
        app.tutorial().clickPopupButton();
        assertEquals(app.tutorial().getHintText(), "Нажмите кнопку «Закрыть»");
        app.click().closeButton();
        assertEquals(app.tutorial().getOverFifthStepText(), "Поздравляем!\nВы завершили пятый шаг,\nостался еще один.");
        app.tutorial().clickOverTutorialStepHelp();
        assertEquals(app.tutorial().getHintText(), "Перейдите в раздел «Прибыльность»");
    }
}
