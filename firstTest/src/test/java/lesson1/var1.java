package lesson1;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class var1 {
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
        //wd = new FirefoxDriver();
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.manage().window().maximize();

    }
    
    @Test
    public void asdf() throws InterruptedException {
        //Перейти на страницу http://www.sberbank.ru/ru/person
        wd.get("https://www.sberbank.ru/ru/person");

        //Нажать на – Страхование
        wd.findElement(By.xpath("//div[@class='lg-menu']/div/div/div[1]/ul/li[6]/span/span")).click();

        //Выбрать – Путешествие и покупки
        wd.findElement(By.linkText("Путешествия и покупки")).click();

        //Проверить наличие на странице заголовка – Страхование путешественников
        wd.findElement(By.xpath(".//*[text()='Страхование путешественников']")).isEnabled();
        wd.findElement(By.xpath("//tr[@class='bp-ColumnLayout-tr']//h3[.='Страхование путешественников']")).isEnabled();

        //Нажать на – Оформить Онлайн
        wd.findElement(By.linkText("Оформить онлайн")).click();

        //Тут весело открывается новая вкладка браузера и с помощью этой нехитрой команды происходит переход в новую вкладку
        for (String winHandle : wd.getWindowHandles()) {
            wd.switchTo().window(winHandle);
        }

        //На вкладке – Выбор полиса  выбрать сумму страховой защиты – Минимальная
        wd.findElement(By.cssSelector("div.b-form-prog-note.ng-binding")).click();

        //Нажать Оформить
        wd.findElement(By.cssSelector("span.b-continue-btn")).click();

        //На вкладке Оформить заполнить поля:
        // Фамилию и Имя, Дату рождения застрахованных
        wd.findElement(By.xpath(".//*[@ng-model='namespace.SURNAME_ENG']")).click();
        wd.findElement(By.xpath(".//*[@ng-model='namespace.SURNAME_ENG']")).clear();
        wd.findElement(By.xpath(".//*[@ng-model='namespace.SURNAME_ENG']")).sendKeys(surname);
        wd.findElement(By.xpath(".//*[@ng-model='namespace.NAME_ENG']")).click();
        wd.findElement(By.xpath(".//*[@ng-model='namespace.NAME_ENG']")).clear();
        wd.findElement(By.xpath(".//*[@ng-model='namespace.NAME_ENG']")).sendKeys(name);
        wd.findElement(By.xpath(".//*[@ng-model='namespace.BIRTHDATE']")).click();
        wd.findElement(By.xpath(".//*[@ng-model='namespace.BIRTHDATE']")).clear();
        wd.findElement(By.xpath(".//*[@ng-model='namespace.BIRTHDATE']")).sendKeys(birthday);

        //Данные страхователя: Фамилия, Имя, Отчество, Дата рождения, Пол
        wd.findElement(By.name("surname")).click();
        wd.findElement(By.name("surname")).clear();
        wd.findElement(By.name("surname")).sendKeys(ruSurname);
        //на этой строке почему-то все падает после ввода фамилии. Я добавил повторный жмак на поле и падения прекратились
        wd.findElement(By.name("surname")).click();
        wd.findElement(By.name("name")).click();
        wd.findElement(By.name("name")).clear();
        wd.findElement(By.name("name")).sendKeys(ruName);
        wd.findElement(By.name("middlename")).click();
        wd.findElement(By.name("middlename")).clear();
        wd.findElement(By.name("middlename")).sendKeys(middlename);
        wd.findElement(By.xpath(".//*[@ng-model='formdata.insurer.BIRTHDATE']")).click();
        wd.findElement(By.xpath(".//*[@ng-model='formdata.insurer.BIRTHDATE']")).clear();
        wd.findElement(By.xpath(".//*[@ng-model='formdata.insurer.BIRTHDATE']")).sendKeys(birthday);
        if (!wd.findElement(By.name("female")).isSelected()) {
            wd.findElement(By.name("female")).click();
        }

        //Паспортные данные
        wd.findElement(By.name("passport_series")).click();
        wd.findElement(By.name("passport_series")).clear();
        wd.findElement(By.name("passport_series")).sendKeys(series);
        wd.findElement(By.name("passport_number")).click();
        wd.findElement(By.name("passport_number")).clear();
        wd.findElement(By.name("passport_number")).sendKeys(number);
        wd.findElement(By.xpath(".//*[@ng-model='formdata.insurer.documentList[0].ISSUEDATE']")).click();
        wd.findElement(By.xpath(".//*[@ng-model='formdata.insurer.documentList[0].ISSUEDATE']")).clear();
        wd.findElement(By.xpath(".//*[@ng-model='formdata.insurer.documentList[0].ISSUEDATE']")).sendKeys(issueDay);
        wd.findElement(By.name("issuePlace")).click();
        wd.findElement(By.name("issuePlace")).clear();
        wd.findElement(By.name("issuePlace")).sendKeys(issuedBy);

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
        wd.findElement(By.cssSelector("span.b-continue-btn")).click();

        //Проверить, что появилось сообщение - Заполнены не все обязательные поля
        assertEquals(wd.findElement(By.xpath(".//*[@ng-show='tryNext && myForm.$invalid']")).getText(),
                "Заполнены не все обязательные поля");
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
