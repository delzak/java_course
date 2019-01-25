package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Алексей on 24.01.2019
 */
public class MainPage {

    @FindBy(xpath = "//ul[@class='lg-menu__list']")
    WebElement mainMenu;

    @FindBy(xpath = "//div[@class='kit-col kit-col_lg_5 lg-menu__col']//a[text()='Путешествия и покупки']/../../..")
    WebElement subMenu;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void selectMainMenu(String menuItem) {
        mainMenu.findElement(By.xpath(".//span[text()='" + menuItem + "']")).click();
    }

    public void selectSubMenu(String menuItem) {
        subMenu.findElement(By.xpath(".//a[text()='" + menuItem + "']")).click();
    }
}
