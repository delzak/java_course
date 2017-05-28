package ru.web.moysklad.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HelpFourthStep extends TestBase{

    @Test
    public void testHelpStocks() {
        app.click().help();
        app.tutorial().clickFourthStepHelp();
        assertEquals(app.tutorial().getHintText(), "Нажмите на вкладку «Склад»");
        app.tutorial().goToStore();
        assertEquals(app.tutorial().getHintText(), "Перейдите в раздел «Остатки»");
        app.tutorial().goToStocks();
        assertEquals(app.tutorial().getHintText(), "В столбце «Остаток» показывается " +
                "фактический остаток товара на складе");
        app.tutorial().clickPopupButton();
        assertEquals(app.tutorial().getHintText(), "В столбце «Сумма себестоимости» " +
                "показывается закупочная стоимость товаров");
        app.tutorial().clickPopupButton();
        assertEquals(app.tutorial().getOverFourthStepText(), "Поздравляем!\nВы завершили четвертый шаг,\nосталось еще два.");
        app.tutorial().clickOverTutorialStepHelp();
        assertEquals(app.tutorial().getHintText(), "Нажмите на вкладку «Продажи»");
    }
}
