package ru.web.moysklad.tests;

import org.testng.annotations.Test;

public class HelpSixthStep extends TestBase{

    @Test
    public void testHelpProfit() throws InterruptedException {
        app.getClickHelper().clickHelp();
        app.getClickHelper().clickSixthStepHelp();
        app.getNavigationHelper().goToTutorialSales();
        app.getNavigationHelper().goToProfitability();
        app.getClickHelper().clickPopupButton();
        app.getClickHelper().clickPopupButton();
        app.getClickHelper().clickPopupButton();
        Thread.sleep(500);
        app.getClickHelper().clickOverTutorial();
    }
}