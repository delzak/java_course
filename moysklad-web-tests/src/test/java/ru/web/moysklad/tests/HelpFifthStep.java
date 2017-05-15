package ru.web.moysklad.tests;

import org.testng.annotations.Test;

public class HelpFifthStep extends TestBase{

    @Test
    public void testHelpSale() throws InterruptedException {
        app.getClickHelper().clickHelp();
        app.getClickHelper().clickFifthStepHelp();
        Thread.sleep(500);
        app.getNavigationHelper().goToTutorialSales();
        app.getNavigationHelper().goToTutorialDemands();
        Thread.sleep(1000);
        app.getDemandHelper().clickButtonNewDemand();
        Thread.sleep(1000);
        app.getClickHelper().openListOfCounterparty();
        Thread.sleep(1000);
        app.getClickHelper().selectCounterparty();
        app.getClickHelper().addPosition("Товар");
        app.getClickHelper().selectGood();
        app.getClickHelper().clickPopupButton();
        app.getDemandHelper().setGoodCount("2");
        Thread.sleep(500);
        app.getClickHelper().clickPopupButton();
        Thread.sleep(1000);
        app.getDemandHelper().clickButtonPrint();
        Thread.sleep(500);
        app.getDemandHelper().selectPrintTorg12();
        Thread.sleep(500);
        app.getDemandHelper().clickActionButtonYes();
        app.getClickHelper().clickPopupButton();
        app.getClickHelper().clickPopupButton();
        Thread.sleep(500);
        app.getClickHelper().clickCloseButton();
        Thread.sleep(1000);
        app.getClickHelper().clickOverTutorialStepHelp();
    }
}
