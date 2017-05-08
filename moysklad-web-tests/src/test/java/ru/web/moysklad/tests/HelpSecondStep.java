package ru.web.moysklad.tests;

import org.testng.annotations.Test;
import ru.web.moysklad.model.ProductData;


public class HelpSecondStep extends TestBase{

    
    @Test
    public void testHelpGoods() throws InterruptedException {
        app.getClickHelper().clickHelp();
        app.getClickHelper().clickSecondStepHelp();
        app.getNavigationHelper().goToProductsAndServices();
        Thread.sleep(500);
        app.getClickHelper().clickButtonNewProduct();
        app.getProductHelper().inputTutorialProductInformation(new ProductData("Товар", "1500"));
        Thread.sleep(500);
        app.getClickHelper().clickSaveButton();
        Thread.sleep(500);
        app.getClickHelper().clickCloseButton();
        Thread.sleep(500);
        app.getClickHelper().clickOverTutorialStepHelp();
    }

}
