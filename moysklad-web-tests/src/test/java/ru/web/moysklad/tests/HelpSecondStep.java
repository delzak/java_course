package ru.web.moysklad.tests;

import org.testng.annotations.Test;
import ru.web.moysklad.model.ProductData;


public class HelpSecondStep extends TestBase{

    @Test
    public void testHelpGoods() throws InterruptedException {
        app.click().help();
        app.tutorial().clickSecondStepHelp();
        app.goTo().productsAndServices();
        Thread.sleep(500);
        app.good().clickButtonNewProduct();
        app.tutorial().inputProductInformation(new ProductData("Товар", "1500"));
        Thread.sleep(500);
        app.click().saveButton();
        Thread.sleep(500);
        app.click().closeButton();
        Thread.sleep(500);
        app.tutorial().clickOverTutorialStepHelp();
    }

}
