package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

/**
 * Created by Алексей on 24.01.2019
 */
public class TravelInsurancePage {

    @FindBy(css = "div.b-form-prog-note.ng-binding")
    public WebElement minInsurance;

    @FindBy(css = "span.b-continue-btn")
    public WebElement issueButton;

    @FindBy(name = "insured0_surname")
    WebElement insuredSurname;

    @FindBy(name = "insured0_name")
    WebElement insuredName;

    @FindBy(name = "insured0_birthDate")
    WebElement insuredBirthdate;

    @FindBy(name = "surname")
    WebElement insurerSurname;

    @FindBy(name = "name")
    WebElement insurerName;

    @FindBy(name = "middlename")
    WebElement insurerMiddlename;

    @FindBy(name = "birthDate")
    WebElement insurerBirthdate;

    @FindBy(name = "female")
    public WebElement femaleGender;

    @FindBy(name = "passport_series")
    WebElement passportSeries;

    @FindBy(name = "passport_number")
    WebElement passportNumber;

    @FindBy(name = "issueDate")
    WebElement issueDate;

    @FindBy(name = "issuePlace")
    WebElement issuePlace;

    @FindBy(xpath = ".//span[@class=\"b-continue-btn\"]")
    public WebElement continueButton;

    @FindBy(xpath = ".//*[@ng-show='tryNext && myForm.$invalid']")
    WebElement errorText;

    public TravelInsurancePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        new WebDriverWait(driver, 5, 1000)
                .until(ExpectedConditions.visibilityOf(continueButton));
    }

    public void fillField(String fieldName, String value) {
        switch (fieldName) {
            case "Фамилия застрахованного":
                fillField(insuredSurname, value);
                break;
            case "Имя застрахованного":
                fillField(insuredName, value);
                break;
            case "Дата рождения застрахованного":
                fillField(insuredBirthdate, value);
                break;
            case "Фамилия страхователя":
                fillField(insurerSurname, value);
                break;
            case "Имя страхователя":
                fillField(insurerName, value);
                break;
            case "Отчество страхователя":
                fillField(insurerMiddlename, value);
                break;
            case "Дата рождения страхователя":
                fillField(insurerBirthdate, value);
                break;
            case "Серия паспорта":
                fillField(passportSeries, value);
                break;
            case "Номер паспорта":
                fillField(passportNumber, value);
                break;
            case "Дата выдачи":
                fillField(issueDate, value);
                break;
            case "Кем выдан":
                fillField(issuePlace, value);
                break;
        }
    }

    protected void fillField(WebElement locator, String value) {
        locator.click();
        locator.clear();
        locator.sendKeys(value);
    }

    public void assertFieldText(String fieldName, String value) {
        switch (fieldName) {
            case "Фамилия застрахованного":
                assertEquals(insuredSurname.getAttribute("value"), value);
                break;
            case "Имя застрахованного":
                assertEquals(insuredName.getAttribute("value"), value);
                break;
            case "Дата рождения застрахованного":
                assertEquals(insuredBirthdate.getAttribute("value"), value);
                break;
            case "Фамилия страхователя":
                assertEquals(insurerSurname.getAttribute("value"), value);
                break;
            case "Имя страхователя":
                assertEquals(insurerName.getAttribute("value"), value);
                break;
            case "Отчество страхователя":
                assertEquals(insurerMiddlename.getAttribute("value"), value);
                break;
            case "Дата рождения страхователя":
                assertEquals(insurerBirthdate.getAttribute("value"), value);
                break;
            case "Серия паспорта":
                assertEquals(passportSeries.getAttribute("value"), value);
                break;
            case "Номер паспорта":
                assertEquals(passportNumber.getAttribute("value"), value);
                break;
            case "Дата выдачи":
                assertEquals(issueDate.getAttribute("value"), value);
                break;
            case "Кем выдан":
                assertEquals(issuePlace.getAttribute("value"), value);
                break;
            case "Сообщение об ошибке":
                assertEquals(errorText.getText(), value);
                break;
        }
    }
}
