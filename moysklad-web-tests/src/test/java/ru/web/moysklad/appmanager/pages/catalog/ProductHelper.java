package ru.web.moysklad.appmanager.pages.catalog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.web.moysklad.appmanager.HelperBase;
import ru.web.moysklad.model.ProductData;

public class ProductHelper extends HelperBase {

    WebDriverWait wait = new WebDriverWait(wd, 10/*seconds*/);

    public ProductHelper(WebDriver wd) {
        super(wd);
    }

    public void waitButton(){
        wait.until((WebDriver d) -> d.findElement(By.xpath("//table[@class='pump-title-panel']/tbody/tr/td[2]/div/table/tbody/tr/td[2]")));
    }

    public void clickButtonNewProduct() {
        click(By.xpath("//table[@class='pump-title-panel']/tbody/tr/td[2]/div/table/tbody/tr/td[2]"));
    }

    public void inputProductName(ProductData productData) {
        type(By.xpath("//tr[@class='tutorial-stage-sales-fourth-step']/td[2]/input"), productData.getName());
    }

    public void inputProductCode(ProductData productData) {
        type(By.xpath("//div[@class='b-guide-editor']/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/input"),
                productData.getCode());
    }

    public void inputProductArticle(ProductData productData) {
        type(By.xpath("//div[@class='b-guide-editor']/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/input"),
                productData.getArticle());
    }

    public void inputProductCountry(ProductData productData) {
        type(By.xpath("//div[@class='b-guide-editor']/table/tbody/tr/td[1]/table/tbody/tr[7]/td[2]/input"),
                productData.getCountry());
    }

    public void inputProductWeight(ProductData productData) {
        type(By.xpath("//div[@class='b-guide-editor']/table/tbody/tr/td[1]/table/tbody/tr[11]/td[2]/div/input"),
                productData.getWeight());
    }

    public void inputProductVolume(ProductData productData) {
        type(By.xpath("//div[@class='b-guide-editor']/table/tbody/tr/td[1]/table/tbody/tr[13]/td[2]/div/input"),
                productData.getVolume());
    }

    public void inputProductVAT(ProductData productData) {
        type(By.xpath("//div[@class='b-guide-editor']/table/tbody/tr/td[1]/table/tbody/tr[17]/td[2]/input"),
                productData.getVat());
    }

    public void inputProductDescription(ProductData productData) {
        type(By.xpath("//div[@class='b-guide-editor']/table/tbody/tr/td[1]/table/tbody/tr[23]/td[2]/textarea"),
                productData.getDescription());
    }

    public void inputProductPrice(ProductData productData) {
        type(By.xpath("//table[@class='price-table']/tbody/tr/td[2]/div/table/tbody/tr/td[1]/div/input"), productData.getSum());
    }

    public void inputProductEAN13(ProductData productData) {
        type(By.xpath("//table[@class='b-validated-field-table']/tbody/tr/td/input"), productData.getEan13());
    }

    public String getTitleText() throws InterruptedException {
        Thread.sleep(100);
        return wd.findElement(By.cssSelector("div.title")).getText();
    }
}
