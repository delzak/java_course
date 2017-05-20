package ru.web.moysklad.tests;

import org.testng.annotations.Test;

public class HelpFourthStep extends TestBase{

    @Test
    public void testHelpStocks() throws InterruptedException {
        app.click().help();
        app.tutorial().clickFourthStepHelp();
        app.tutorial().goToStore();
        app.tutorial().goToStocks();
        app.tutorial().clickPopupButton();
        app.tutorial().clickPopupButton();
        Thread.sleep(500);
        app.tutorial().clickOverTutorialStepHelp();
    }
}
