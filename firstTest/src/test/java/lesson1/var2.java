package lesson1;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class var2 {
    ChromeDriver wd;
    String surname = "Surname";
    String name = "Name";
    String ruSurname = "Фамилия";
    String ruName = "Имя";
    String middlename = "Отчество";
    String birthday = "01.01.1991";
    String series = "1111";
    String number = "222222";
    String issueDay = "01.02.2012";
    String issuedBy = "Выдан людьми из паспортного стола";

    @BeforeMethod
    public void setUp() throws Exception {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.manage().window().maximize();

    }
    
    @Test
    public void asdf() throws InterruptedException {
        //Перейти на страницу http://www.sberbank.ru/ru/person
        goTo("https://www.sberbank.ru/ru/person");

        //Нажать на – Страхование
        click(wd.findElement(By.xpath("//div[@class='lg-menu']/div/div/div[1]/ul/li[6]/span/span")));

        //Выбрать – Путешествие и покупки
        click(wd.findElement(By.linkText("Путешествия и покупки")));

        //Проверить наличие на странице заголовка – Страхование путешественников
        webElementIsEnabled(wd.findElement(By.xpath(".//*[text()='Страхование путешественников']")));

        //Нажать на – Оформить Онлайн
        click(wd.findElement(By.linkText("Оформить онлайн")));

        //Тут весело открывается новая вкладка браузера и с помощью этой нехитрой команды происходит переход в новую вкладку
        for (String winHandle : wd.getWindowHandles()) {
            wd.switchTo().window(winHandle);
        }

        //На вкладке – Выбор полиса  выбрать сумму страховой защиты – Минимальная
        click(wd.findElement(By.cssSelector("div.b-form-prog-note.ng-binding")));

        //Нажать Оформить
        click(wd.findElement(By.cssSelector("span.b-continue-btn")));

        //На вкладке Оформить заполнить поля:
        // Фамилию и Имя, Дату рождения застрахованных
        type(wd.findElement(By.xpath(".//*[@ng-model='namespace.SURNAME_ENG']")), surname);
        type(wd.findElement(By.xpath(".//*[@ng-model='namespace.NAME_ENG']")), name);
        type(wd.findElement(By.xpath(".//*[@ng-model='namespace.BIRTHDATE']")), birthday);

        //Данные страхователя: Фамилия, Имя, Отчество, Дата рождения, Пол
        type(wd.findElement(By.name("surname")), ruSurname);
        //на этой строке почему-то все падает после ввода фамилии. Я добавил повторный жмак на поле и падения прекратились
        wd.findElement(By.name("surname")).click();
        type(wd.findElement(By.name("name")), ruName);
        type(wd.findElement(By.name("middlename")), middlename);
        type(wd.findElement(By.xpath(".//*[@ng-model='formdata.insurer.BIRTHDATE']")), birthday);
        if (!wd.findElement(By.name("female")).isSelected()) {
            wd.findElement(By.name("female")).click();
        }

        //Паспортные данные
        type(wd.findElement(By.name("passport_series")), series);
        type(wd.findElement(By.name("passport_number")), number);
        type(wd.findElement(By.xpath(".//*[@ng-model='formdata.insurer.documentList[0].ISSUEDATE']")), issueDay);
        type(wd.findElement(By.name("issuePlace")), issuedBy);

        //Проверить, что все поля заполнены правильно
        assertEquals(wd.findElement(By.xpath(".//*[@ng-model='namespace.SURNAME_ENG']")).getAttribute("value"), surname);
        assertEquals(wd.findElement(By.xpath(".//*[@ng-model='namespace.NAME_ENG']")).getAttribute("value"), name);
        assertEquals(wd.findElement(By.xpath(".//*[@ng-model='namespace.BIRTHDATE']")).getAttribute("value"), birthday);
        assertEquals(wd.findElement(By.name("surname")).getAttribute("value"), ruSurname);
        assertEquals(wd.findElement(By.name("name")).getAttribute("value"), ruName);
        assertEquals(wd.findElement(By.name("middlename")).getAttribute("value"), middlename);
        assertEquals(wd.findElement(By.xpath(".//*[@ng-model='formdata.insurer.BIRTHDATE']")).getAttribute("value"), birthday);
        assertEquals(wd.findElement(By.name("passport_series")).getAttribute("value"), series);
        assertEquals(wd.findElement(By.name("passport_number")).getAttribute("value"), number);
        assertEquals(wd.findElement(By.xpath(".//*[@ng-model='formdata.insurer.documentList[0].ISSUEDATE']")).getAttribute("value"), issueDay);
        assertEquals(wd.findElement(By.name("issuePlace")).getAttribute("value"), issuedBy);

        //Нажать продолжить
        click(wd.findElement(By.cssSelector("span.b-continue-btn")));

        //Проверить, что появилось сообщение - Заполнены не все обязательные поля
        assertEquals(wd.findElement(By.xpath(".//*[@ng-show='tryNext && myForm.$invalid']")).getText(),
                "Заполнены не все обязательные поля");
    }

    private void type(WebElement locator, String value) {
        locator.click();
        locator.clear();
        locator.sendKeys(value);
    }

    private void webElementIsEnabled(WebElement locator) {
        locator.isEnabled();
    }

    private void click(WebElement locator) {
        locator.click();
    }

    private void goTo(String path) {
        wd.get(path);
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
