package ru.web.moysklad.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.web.moysklad.model.ProductData;

public class ProductHelper {
    private FirefoxDriver wd;

    public ProductHelper(FirefoxDriver wd) {
        this.wd = wd;
    }

    public void inputTutorialProductInformation(ProductData productData) throws InterruptedException {
        wd.findElement(By.xpath("//tr[@class='tutorial-stage-sales-fourth-step']/td[2]/input")).click();
        wd.findElement(By.xpath("//tr[@class='tutorial-stage-sales-fourth-step']/td[2]/input")).clear();
        wd.findElement(By.xpath("//tr[@class='tutorial-stage-sales-fourth-step']/td[2]/input")).sendKeys(productData.getProductName());
        Thread.sleep(500);
        wd.findElement(By.xpath("//table[@class='price-table']/tbody/tr/td[2]/div/table/tbody/tr/td[1]/div/input")).click();
        wd.findElement(By.xpath("//table[@class='price-table']/tbody/tr/td[2]/div/table/tbody/tr/td[1]/div/input")).clear();
        wd.findElement(By.xpath("//table[@class='price-table']/tbody/tr/td[2]/div/table/tbody/tr/td[1]/div/input")).sendKeys(productData.getProductSum());
    }
}
