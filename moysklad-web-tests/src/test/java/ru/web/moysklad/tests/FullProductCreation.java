package ru.web.moysklad.tests;

import org.testng.annotations.Test;
import ru.web.moysklad.model.ProductData;

public class FullProductCreation extends TestBase{

    @Test
    public void testCreateFullProduct () throws InterruptedException {
        app.goTo().catalog();
        app.goTo().productsAndServices();
        Thread.sleep(500);
        app.good().clickButtonNewProduct();
        app.good().inputProductName(new ProductData().withName("FullProduct"));
        app.good().inputProductCode(new ProductData().withCode("FP001"));
        app.good().inputProductArticle(new ProductData().withArticle("fp1"));
        app.good().inputProductCountry(new ProductData().withCountry("Россия"));
        app.good().inputProductWeight(new ProductData().withWeight("10"));
        app.good().inputProductVolume(new ProductData().withVolume("10"));
        app.good().inputProductVAT(new ProductData().withVat("18"));
        app.good().inputProductDescription(new ProductData().withDescription("Description"));
        app.good().inputProductPrice(new ProductData().withSum("220"));
        app.good().inputProductEAN13(new ProductData().withEan13("2000000999999"));
        app.click().saveButton();
    }
}
