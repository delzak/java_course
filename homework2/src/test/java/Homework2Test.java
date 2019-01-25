import org.junit.Test;
import pages.MainPage;
import pages.TravelAndShopingPage;
import pages.TravelInsurancePage;

/**
 * Created by Алексей on 24.01.2019.
 */
public class Homework2Test extends BaseTest {
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
    public void newInsuranceTest() {
        //Переход на страницу http://www.sberbank.ru/ru/person осуществляется в BaseTest
        MainPage mainPage = new MainPage(driver);

        //Нажать на – Страхование
        mainPage.selectMainMenu("Страхование");

        //Выбрать – Путешествие и покупки
        mainPage.selectSubMenu("Путешествия и покупки");

        TravelAndShopingPage travelAndShopingPage = new TravelAndShopingPage(driver);

        //Проверить наличие на странице заголовка – Страхование путешественников
        travelAndShopingPage.findTitle("Страхование путешественников");

        //Нажать на – Оформить Онлайн
        travelAndShopingPage.registrationButton.click();

        //Переход на новую вкладку
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        TravelInsurancePage travelInsurancePage = new TravelInsurancePage(driver);

        //На вкладке – Выбор полиса  выбрать сумму страховой защиты – Минимальная
        travelInsurancePage.minInsurance.click();

        //Нажать Оформить
        travelInsurancePage.issueButton.click();

        //На вкладке Оформить заполнить поля: Фамилию и Имя, Дату рождения застрахованных
        travelInsurancePage.fillField("Фамилия застрахованного", surname);
        travelInsurancePage.fillField("Имя застрахованного", name);
        travelInsurancePage.fillField("Дата рождения застрахованного", birthday);

        //Данные страхователя: Фамилия, Имя, Отчество, Дата рождения, Пол
        travelInsurancePage.fillField("Фамилия страхователя", ruSurname);
        travelInsurancePage.fillField("Имя страхователя", ruName);
        travelInsurancePage.fillField("Отчество страхователя", middlename);
        travelInsurancePage.fillField("Дата рождения страхователя", birthday);
        travelInsurancePage.femaleGender.click();

        //Паспортные данные
        travelInsurancePage.fillField("Серия паспорта", series);
        travelInsurancePage.fillField("Номер паспорта", number);
        travelInsurancePage.fillField("Дата выдачи", issueDay);
        travelInsurancePage.fillField("Кем выдан", issuedBy);

        //Проверить, что все поля заполнены правильно
        travelInsurancePage.assertFieldText("Фамилия застрахованного", surname);
        travelInsurancePage.assertFieldText("Имя застрахованного", name);
        travelInsurancePage.assertFieldText("Дата рождения застрахованного", birthday);
        travelInsurancePage.assertFieldText("Фамилия страхователя", ruSurname);
        travelInsurancePage.assertFieldText("Имя страхователя", ruName);
        travelInsurancePage.assertFieldText("Отчество страхователя", middlename);
        travelInsurancePage.assertFieldText("Дата рождения страхователя", birthday);
        travelInsurancePage.assertFieldText("Серия паспорта", series);
        travelInsurancePage.assertFieldText("Номер паспорта", number);
        travelInsurancePage.assertFieldText("Дата выдачи", issueDay);
        travelInsurancePage.assertFieldText("Кем выдан", issuedBy);

        //Нажать продолжить
        travelInsurancePage.continueButton.click();

        //Проверить, что появилось сообщение - Заполнены не все обязательные поля
        travelInsurancePage.assertFieldText("Сообщение об ошибке", "Заполнены не все обязательные поля");
    }
}
