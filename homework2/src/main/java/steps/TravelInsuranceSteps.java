package steps;

import pages.TravelInsurancePage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

/**
 * Created by Алексей on 28.01.2019.
 */
public class TravelInsuranceSteps extends BaseSteps {

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

    @Step("Поле {0} заполнено значением {1}")
    public void stepFillField(String field, String value) {
        new TravelInsurancePage(driver).fillField(field, value);
    }

    @Step("Заполняются поля:")
    public void stepFillFields(HashMap<String, String> fields) {
        fields.forEach(this::stepFillField);
    }

    @Step("Проверить корректность поля {0} заполненным значением {1}")
    public void stepAssertField(String field, String value) {
        new TravelInsurancePage(driver).assertFieldText(field, value);
    }

    @Step("Проверяются поля:")
    public void stepAssertFields(HashMap<String, String> fields) {
        fields.forEach(this::stepAssertField);
    }

    @Step("Выбор полиса на сумму страховой защиты – Минимальная")
    public void stepClickMinInsurance() {
        new TravelInsurancePage(driver).minInsurance.click();
    }

    @Step("Нажатие кнопки 'Оформить'")
    public void stepClickIssueButton() {
        new TravelInsurancePage(driver).issueButton.click();
    }

    @Step("На вкладке 'Оформить' заполнить поля: Фамилию и Имя, Дату рождения застрахованных")
    public void stepFillInformationAboutInsured() {
        new TravelInsurancePage(driver).fillField("Фамилия застрахованного", surname);
        new TravelInsurancePage(driver).fillField("Имя застрахованного", name);
        new TravelInsurancePage(driver).fillField("Дата рождения застрахованного", birthday);
    }

    @Step("Заполнение данных страхователя: Фамилия, Имя, Отчество, Дата рождения, Пол")
    public void stepFillInformationAboutInsurer() {
        new TravelInsurancePage(driver).fillField("Фамилия страхователя", ruSurname);
        new TravelInsurancePage(driver).fillField("Имя страхователя", ruName);
        new TravelInsurancePage(driver).fillField("Отчество страхователя", middlename);
        new TravelInsurancePage(driver).fillField("Дата рождения страхователя", birthday);
        new TravelInsurancePage(driver).femaleGender.click();
    }

    @Step("Заполнение паспортных данных")
    public void stepFillPasportInformation() {
        new TravelInsurancePage(driver).fillField("Серия паспорта", series);
        new TravelInsurancePage(driver).fillField("Номер паспорта", number);
        new TravelInsurancePage(driver).fillField("Дата выдачи", issueDay);
        new TravelInsurancePage(driver).fillField("Кем выдан", issuedBy);
    }

    @Step("Проверка корректности заполнения полей")
    public void stepAssertTextFields() {
        new TravelInsurancePage(driver).assertFieldText("Фамилия застрахованного", surname);
        new TravelInsurancePage(driver).assertFieldText("Имя застрахованного", name);
        new TravelInsurancePage(driver).assertFieldText("Дата рождения застрахованного", birthday);
        new TravelInsurancePage(driver).assertFieldText("Фамилия страхователя", ruSurname);
        new TravelInsurancePage(driver).assertFieldText("Имя страхователя", ruName);
        new TravelInsurancePage(driver).assertFieldText("Отчество страхователя", middlename);
        new TravelInsurancePage(driver).assertFieldText("Дата рождения страхователя", birthday);
        new TravelInsurancePage(driver).assertFieldText("Серия паспорта", series);
        new TravelInsurancePage(driver).assertFieldText("Номер паспорта", number);
        new TravelInsurancePage(driver).assertFieldText("Дата выдачи", issueDay);
        new TravelInsurancePage(driver).assertFieldText("Кем выдан", issuedBy);
    }

    @Step("Нажатие кнопки 'Продолжить'")
    public void stepClickContinueButton() {
        new TravelInsurancePage(driver).continueButton.click();
    }

    @Step("Проверка появления сообщения об ошибке {0}")
    public void stepAssertErrorText(String errorText) {
        errorText = "Заполнены не все обязательные поля";
        new TravelInsurancePage(driver).assertFieldText("Сообщение об ошибке", errorText);
    }
}
