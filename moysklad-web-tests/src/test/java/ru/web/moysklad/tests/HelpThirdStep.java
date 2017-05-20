package ru.web.moysklad.tests;

import org.testng.annotations.Test;

public class HelpThirdStep extends TestBase{

    @Test
    public void testHelpAddmission() throws InterruptedException {
        app.click().help();
        app.tutorial().clickThirdStepHelp();
        app.tutorial().clickPopupButton();
        Thread.sleep(500);
        app.tutorial().goToPurchases();
        Thread.sleep(500);
        app.tutorial().goToSupplies();
        app.supply().clickButtonNewSupply();
        Thread.sleep(500);
        app.click().listOfCounterparty();
        Thread.sleep(1000);
        app.click().selectCounterparty();
        app.click().addPosition("Товар");
        Thread.sleep(500);
        app.click().selectGood();
        app.supply().setGoodCount("6");
        app.supply().setPrice("1000");
        Thread.sleep(500);
        app.click().saveButton();
        Thread.sleep(1000);
        app.click().closeButton();
        Thread.sleep(1000);
        app.tutorial().clickOverTutorialStepHelp();
    }
}
