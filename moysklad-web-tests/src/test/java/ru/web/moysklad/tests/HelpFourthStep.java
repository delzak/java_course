package ru.web.moysklad.tests;

import org.testng.annotations.Test;

public class HelpFourthStep extends TestBase{

    @Test
    public void testHelpStocks() throws InterruptedException {
        app.getClickHelper().clickHelp();
        app.getClickHelper().clickFourthStepHelp();
        app.getNavigationHelper().goToTutorialStore();
        app.getNavigationHelper().goToTutorialStocks();
        app.getClickHelper().clickPopupButton();
        app.getClickHelper().clickPopupButton();
        Thread.sleep(500);
        app.getClickHelper().clickOverTutorialStepHelp();
    }
}
