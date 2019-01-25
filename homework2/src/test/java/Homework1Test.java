import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

/**
 * Created by Алексей on 24.01.2019.
 */
public class Homework1Test extends BaseTest{
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

    @Test
    @Ignore
    public void testHomework2() {
        //Перейти на страницу http://www.sberbank.ru/ru/person
        goTo(baseUrl);

        //Нажать на – Страхование
        click(driver.findElement(By.xpath("//div[@class='lg-menu']/div/div/div[1]/ul/li[6]/span/span")));

        //Выбрать – Путешествие и покупки
        click(driver.findElement(By.linkText("Путешествия и покупки")));

        //Проверить наличие на странице заголовка – Страхование путешественников
        webElementIsEnabled(driver.findElement(By.xpath(".//*[text()='Страхование путешественников']")));

        //Нажать на – Оформить Онлайн
        click(driver.findElement(By.linkText("Оформить онлайн")));

        //Тут весело открывается новая вкладка браузера и с помощью этой нехитрой команды происходит переход в новую вкладку
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        //На вкладке – Выбор полиса  выбрать сумму страховой защиты – Минимальная
        click(driver.findElement(By.cssSelector("div.b-form-prog-note.ng-binding")));

        //Нажать Оформить
        click(driver.findElement(By.cssSelector("span.b-continue-btn")));

        //На вкладке Оформить заполнить поля:
        // Фамилию и Имя, Дату рождения застрахованных
        type(driver.findElement(By.xpath(".//*[@ng-model='namespace.SURNAME_ENG']")), surname);
        type(driver.findElement(By.xpath(".//*[@ng-model='namespace.NAME_ENG']")), name);
        type(driver.findElement(By.xpath(".//*[@ng-model='namespace.BIRTHDATE']")), birthday);

        //Данные страхователя: Фамилия, Имя, Отчество, Дата рождения, Пол
        type(driver.findElement(By.name("surname")), ruSurname);
        //на этой строке почему-то все падает после ввода фамилии. Я добавил повторный жмак на поле и падения прекратились
        driver.findElement(By.name("surname")).click();
        type(driver.findElement(By.name("name")), ruName);
        type(driver.findElement(By.name("middlename")), middlename);
        type(driver.findElement(By.xpath(".//*[@ng-model='formdata.insurer.BIRTHDATE']")), birthday);
        if (!driver.findElement(By.name("female")).isSelected()) {
            driver.findElement(By.name("female")).click();
        }

        //Паспортные данные
        type(driver.findElement(By.name("passport_series")), series);
        type(driver.findElement(By.name("passport_number")), number);
        type(driver.findElement(By.xpath(".//*[@ng-model='formdata.insurer.documentList[0].ISSUEDATE']")), issueDay);
        type(driver.findElement(By.name("issuePlace")), issuedBy);

        //Проверить, что все поля заполнены правильно
        assertEquals(driver.findElement(By.xpath(".//*[@ng-model='namespace.SURNAME_ENG']")).getAttribute("value"), surname);
        assertEquals(driver.findElement(By.xpath(".//*[@ng-model='namespace.NAME_ENG']")).getAttribute("value"), name);
        assertEquals(driver.findElement(By.xpath(".//*[@ng-model='namespace.BIRTHDATE']")).getAttribute("value"), birthday);
        assertEquals(driver.findElement(By.name("surname")).getAttribute("value"), ruSurname);
        assertEquals(driver.findElement(By.name("name")).getAttribute("value"), ruName);
        assertEquals(driver.findElement(By.name("middlename")).getAttribute("value"), middlename);
        assertEquals(driver.findElement(By.xpath(".//*[@ng-model='formdata.insurer.BIRTHDATE']")).getAttribute("value"), birthday);
        assertEquals(driver.findElement(By.name("passport_series")).getAttribute("value"), series);
        assertEquals(driver.findElement(By.name("passport_number")).getAttribute("value"), number);
        assertEquals(driver.findElement(By.xpath(".//*[@ng-model='formdata.insurer.documentList[0].ISSUEDATE']")).getAttribute("value"), issueDay);
        assertEquals(driver.findElement(By.name("issuePlace")).getAttribute("value"), issuedBy);

        //Нажать продолжить
        click(driver.findElement(By.cssSelector("span.b-continue-btn")));

        //Проверить, что появилось сообщение - Заполнены не все обязательные поля
        assertEquals(driver.findElement(By.xpath(".//*[@ng-show='tryNext && myForm.$invalid']")).getText(),
                "Заполнены не все обязательные поля");
    }
}
