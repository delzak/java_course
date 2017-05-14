package ru.web.moysklad.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.web.moysklad.model.ProductData;

public class ProductHelper extends HelperBase {

    public ProductHelper(WebDriver wd) {
        super(wd);
    }

    public void clickButtonNewProduct() {
        click(By.xpath("//table[@class='pump-title-panel']/tbody/tr/td[2]/div/table/tbody/tr/td[2]"));
    }

    public void inputTutorialProductInformation(ProductData productData) throws InterruptedException {
        type(By.xpath("//tr[@class='tutorial-stage-sales-fourth-step']/td[2]/input"), productData.getProductName());
        Thread.sleep(500);
        type(By.xpath("//table[@class='price-table']/tbody/tr/td[2]/div/table/tbody/tr/td[1]/div/input"), productData.getProductSum());
    }

}
