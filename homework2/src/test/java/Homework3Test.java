import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;
import steps.BaseSteps;
import steps.MainSteps;
import steps.TravelAndShopingSteps;
import steps.TravelInsuranceSteps;

import java.util.HashMap;

/**
 * Created by Алексей on 24.01.2019
 */
public class Homework3Test extends BaseSteps {

    @Test
    @Title("Страхование")
    public void testHomework3() {
        MainSteps mainSteps = new MainSteps();
        TravelAndShopingSteps travelAndShopingSteps = new TravelAndShopingSteps();
        TravelInsuranceSteps travelInsuranceSteps = new TravelInsuranceSteps();

        HashMap<String, String> testData = new HashMap<>();
        testData.put("Фамилия застрахованного", "Surname");
        testData.put("Имя застрахованного", "Name");
        testData.put("Дата рождения застрахованного", "01.01.1991");

        testData.put("Фамилия страхователя", "Фамилия");
        testData.put("Имя страхователя", "Имя");
        testData.put("Отчество страхователя", "Отчество");
        testData.put("Дата рождения страхователя", "01.01.1991");

        testData.put("Серия паспорта", "1111");
        testData.put("Номер паспорта", "222222");
        testData.put("Дата выдачи", "01.02.2012");
        testData.put("Кем выдан", "Выдан людьми из паспортного стола");

        //Нажать на – Страхование
        mainSteps.stepSelectMainMenu("Страхование");

        //Выбрать – Путешествие и покупки
        mainSteps.stepSelectSubMenu("Путешествия и покупки");

        //Проверить наличие на странице заголовка – Страхование путешественников
        travelAndShopingSteps.stepFindTitle("Страхование путешественников");

        //Нажать на – Оформить Онлайн
        travelAndShopingSteps.stepClickRegistrationButton();

        //На вкладке – Выбор полиса  выбрать сумму страховой защиты – Минимальная
        travelInsuranceSteps.stepClickMinInsurance();

        //Нажать Оформить
        travelInsuranceSteps.stepClickIssueButton();

        /*На вкладке Оформить заполнить поля: Фамилию и Имя, Дату рождения застрахованных
        Данные страхователя: Фамилия, Имя, Отчество, Дата рождения, Пол
        Паспортные данные */
        travelInsuranceSteps.stepFillFields(testData);

        //Проверить, что все поля заполнены правильно
        travelInsuranceSteps.stepAssertFields(testData);

        //Нажать продолжить
        travelInsuranceSteps.stepClickContinueButton();

        //Проверить, что появилось сообщение - Заполнены не все обязательные поля
        travelInsuranceSteps.stepAssertErrorText("Заполнены не все обязательные поля");
    }
}
