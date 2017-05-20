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

}
