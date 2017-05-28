package ru.web.moysklad.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HelpSixthStep extends TestBase{

    @Test
    public void testHelpProfit() {
        app.click().help();
        app.tutorial().clickSixthStepHelp();
        assertEquals(app.tutorial().getHintText(), "Нажмите на вкладку «Продажи»»");
        app.tutorial().goToSales();
        assertEquals(app.tutorial().getHintText(), "Перейдите в раздел «Прибыльность»");
        app.tutorial().goToProfitability();
        assertEquals(app.tutorial().getHintText(), "В столбце «Сумма себестоимости» " +
                "показывается закупочная стоимость товара");
        app.tutorial().clickPopupButton();
        assertEquals(app.tutorial().getHintText(), "В столбце «Продажи — Сумма» " +
                "показывается стоимость, за которую вы продали товар");
        app.tutorial().clickPopupButton();
        assertEquals(app.tutorial().getHintText(), "В столбце «Прибыль» показывается " +
                "прибыль, которую вы получили");
        app.tutorial().clickPopupButton();
        assertEquals(app.tutorial().getOverSixthStepText(), "Поздравляем!\nВы прошли обучение.");
        app.tutorial().clickOverTutorial();
    }
}
