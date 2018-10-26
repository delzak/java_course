import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class YaTest {
    FirefoxDriver wd;
    @FindBy(xpath = ".//button[@class='button button_theme_normal button_arrow_down button_size_s select__button i-bem button_js_inited']")
    private WebElement advancedSearchButton;

    @FindBy(xpath = ".//span[text()='Показывать по 12']")
    private WebElement wb;

    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    
    @Test
    public void YaTest() throws InterruptedException {


        openSite("https://yandex.ru/");
        maximizeWindow();
        goTo("Маркет");
        moveMouseToWebElement(wd.findElement(By.linkText("Электроника")));
        goTo("Телевизоры");
        //openSite("https://market.yandex.ru/catalog/59601/list?hid=90639&track=menuleaf");

        selectAdvancedPage();
      /*  wd.findElement(By.xpath("//div[@class='main']//button[.='Показывать по 48']")).click();
        wd.findElement(By.xpath("/html/body/div[3]/div/div/div[1]/span")).click();
        wd.findElement(By.xpath("//div[@class='main']//button[.='Показывать по 48']")).click();
        wd.findElement(By.xpath("//span[.='Показывать по 12']")).click();
        wd.findElement(By.xpath("//div[@class='main']//button[.='Показывать по 48']")).click();
        new Actions(wd).moveToElement(wd.findElement(By.xpath("//span[.='Показывать по 12']"))).build().perform();
        System.out.println(wd.getMouse());
        new Actions(wd).click(); */

        filterSetMinPrice("20000");
        selectMaker("LG");
        selectMaker("Samsung");
        forceWait(3);
        checkQuantityOfGoods(48);
        String firstGood = getFirstGood();
        inputNameOfGoodToSearchLine(firstGood);
        searchAndCheckNameOfGood(firstGood);
    }

    private void moveMouseToWebElement(WebElement locator) {
        new Actions(wd).moveToElement(locator).build().perform();
    }

    private void goTo(String nameOfCategory) {
        wd.findElement(By.linkText(nameOfCategory)).click();
    }

    public void selectAdvancedPage() {
        wd.findElement(By.xpath(".//button[@class='button button_theme_normal button_arrow_down button_size_s select__button i-bem button_js_inited']")).click();
        //advancedSearchButton.click();
        WebDriverWait wait = new WebDriverWait(wd, 3);
        //wait.until(ExpectedConditions.visibilityOf(wb));
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath(".//span[text()='Показывать по 12']"))));
        wd.findElement(By.xpath(".//span[text()='Показывать по 12']")).click();
        wb.click();
    }

    private void searchAndCheckNameOfGood(String nameOfGood) {
        wd.findElement(By.xpath("//span[@class='search2__button']//button[.='Найти']")).click();
        String foundValue = wd.findElement(By.xpath("html/body/div[1]/div[4]/div[2]/div[2]/div/div[1]/div[1]/div/h1")).getText();
        Assert.assertEquals(nameOfGood,foundValue);
        System.out.println(nameOfGood.equals(foundValue));
    }

    private void inputNameOfGoodToSearchLine(String nameOfGood) {
        wd.findElement(By.id("header-search")).clear();
        wd.findElement(By.id("header-search")).sendKeys(nameOfGood);
    }

    private String getFirstGood() {
        String firstElement = wd.findElement(By.xpath(
                "/html/body/div[1]/div[4]/div[2]/div[1]/div[2]/div/div[1]/div[1]/div[4]/div[1]/div[1]/a")).getText();
        System.out.println(firstElement);
        return firstElement;
    }

    private void checkQuantityOfGoods(int quantity) {
        WebElement listOfGoods = wd.findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div[1]/div[2]/div/div[1]"));
        List<WebElement> goods =
                listOfGoods.findElements(By.xpath("/html/body/div[1]/div[4]/div[2]/div[1]/div[2]/div/div[1]/div[@data-id]"));
        Assert.assertEquals(goods.size(), quantity);
        System.out.println("Quantity of goods = " + goods.size());
    }

    private void forceWait(int times) {
        for (int i = 0; i < times; i++) {
            wd.findElement(By.id("header-search")).clear();
            wd.findElement(By.id("header-search")).sendKeys("aiwjsajfoisdafioafiosjfioesjafisjafoijesaoifjsodijf");
        }

    }

    private void selectMaker(String maker) {
        if (maker.equals("LG")) {
            wd.findElement(By.xpath("//label[@for='7893318_153074']//div[.='" + maker + "']")).click();
        }
        if (maker.equals("Samsung")) {
            wd.findElement(By.xpath("//label[@for='7893318_153061']//div[.='" + maker + "']")).click();
        }
    }

    private void filterSetMinPrice(String minPrice) {
        wd.findElement(By.xpath(".//*[@id='glpricefrom']")).clear();
        wd.findElement(By.xpath(".//*[@id='glpricefrom']")).sendKeys(minPrice);
    }

    private void openSite(String url) {
        wd.get(url);
    }

    private void maximizeWindow() {
        wd.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
