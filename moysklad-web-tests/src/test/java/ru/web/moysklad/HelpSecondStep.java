package ru.web.moysklad;

import org.testng.annotations.Test;


public class HelpSecondStep extends TestBase{

    
    @Test
    public void testHelpGoods() throws InterruptedException {
        clickHelp();
        clickSecondStepHelp();
        goToCatalog();
        goToProductsAndServices();
        Thread.sleep(500);
        clickButtonNewProduct();
        inputProductInformation(new ProductData("Товар", "1500"));
        Thread.sleep(500);
        clickSaveButton();
        Thread.sleep(500);
        clickCloseButton();
        Thread.sleep(500);
        clickOverTutorialStepHelp();
    }

}
