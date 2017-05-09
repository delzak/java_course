package ru.web.moysklad.tests;

import org.testng.annotations.Test;

public class HelpThirdStep extends TestBase{

    @Test
    public void testHelpAddmission() throws InterruptedException {
        app.getClickHelper().clickHelp();
        app.getClickHelper().clickThirdStepHelp();
        app.getClickHelper().clickPopupButton();
        Thread.sleep(500);
        app.getNavigationHelper().goToTutorialPurchases();
        Thread.sleep(500);
        app.getNavigationHelper().goToTutorialSupplies();
        app.getSupplyHelper().clickButtonNewSupply();
        app.getClickHelper().getListOfCounterparty();
        Thread.sleep(500);
        app.getClickHelper().selectCounterparty();
        app.getClickHelper().addPosition("Товар");
        Thread.sleep(500);
        app.getClickHelper().selectGood();
        app.getSupplyHelper().setGoodCount("6");
        app.getSupplyHelper().setPrice("1000");
        Thread.sleep(500);
        app.getClickHelper().clickSaveButton();
        Thread.sleep(500);
        app.getClickHelper().clickCloseButton();
        Thread.sleep(500);
        app.getClickHelper().clickOverTutorialStepHelp();
    }
}
