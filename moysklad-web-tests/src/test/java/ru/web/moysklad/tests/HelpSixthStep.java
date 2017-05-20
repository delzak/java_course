package ru.web.moysklad.tests;

import org.testng.annotations.Test;

public class HelpSixthStep extends TestBase{

    @Test
    public void testHelpProfit() throws InterruptedException {
        app.click().help();
        app.tutorial().clickSixthStepHelp();
        Thread.sleep(500);
        app.tutorial().goToSales();
        app.tutorial().goToProfitability();
        Thread.sleep(500);
        app.tutorial().clickPopupButton();
        app.tutorial().clickPopupButton();
        app.tutorial().clickPopupButton();
        Thread.sleep(500);
        app.tutorial().clickOverTutorial();
    }
}
