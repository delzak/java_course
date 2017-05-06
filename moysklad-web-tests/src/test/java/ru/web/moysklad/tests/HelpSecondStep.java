package ru.web.moysklad.tests;

import org.testng.annotations.Test;
import ru.web.moysklad.model.ProductData;


public class HelpSecondStep extends TestBase{

    
    @Test
    public void testHelpGoods() throws InterruptedException {
        app.clickHelp();
        app.clickSecondStepHelp();
        app.goToCatalog();
        app.goToProductsAndServices();
        Thread.sleep(500);
        app.clickButtonNewProduct();
        app.inputProductInformation(new ProductData("Товар", "1500"));
        Thread.sleep(500);
        app.clickSaveButton();
        Thread.sleep(500);
        app.clickCloseButton();
        Thread.sleep(500);
        app.clickOverTutorialStepHelp();
    }

}
