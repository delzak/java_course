package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Алексей on 24.01.2019.
 */
public class TravelAndShopingPage {

    @FindBy(xpath = "//div[@class='col-xs-12 col-sm-12 col-md-12 row1-col1 --area bp-area']")
    WebElement title;

    @FindBy(linkText = "Оформить онлайн")
    public WebElement registrationButton;

    public TravelAndShopingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(registrationButton));
    }

    public void findTitle(String titleItem) {
        title.findElement(By.xpath(".//*[text()='" + titleItem + "']")).isEnabled();
    }
}
