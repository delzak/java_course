package ru.web.moysklad.tests;

import org.testng.annotations.Test;

public class HelpFifthStep extends TestBase{

    @Test
    public void testHelpSale() throws InterruptedException {
        app.click().help();
        app.tutorial().clickFifthStepHelp();
        Thread.sleep(500);
        app.tutorial().goToSales();
        app.tutorial().goToDemands();
        Thread.sleep(1000);
        app.demand().clickButtonNewDemand();
        Thread.sleep(1000);
        app.click().listOfCounterparty();
        Thread.sleep(1000);
        app.click().selectCounterparty();
        app.click().addPosition("Товар");
        app.click().selectGood();
        app.tutorial().clickPopupButton();
        app.demand().setGoodCount("2");
        Thread.sleep(500);
        app.tutorial().clickPopupButton();
        Thread.sleep(1000);
        app.demand().clickButtonPrint();
        Thread.sleep(500);
        app.demand().selectPrintTorg12();
        Thread.sleep(500);
        app.demand().clickActionButtonYes();
        app.tutorial().clickPopupButton();
        app.tutorial().clickPopupButton();
        Thread.sleep(500);
        app.click().closeButton();
        Thread.sleep(1000);
        app.tutorial().clickOverTutorialStepHelp();
    }
}
