package ru.web.moysklad.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HelpThirdStep extends TestBase{

    @Test
    public void testHelpAddmission() throws InterruptedException {
        app.click().help();
        app.tutorial().clickThirdStepHelp();
        assertEquals(app.tutorial().getHintText(), "Для контроля остатков товаров, а также расчета " +
                "себестоимости и прибыли необходимо вести учет поступлений товара на склад.");
        app.tutorial().clickPopupButton();
        assertEquals(app.tutorial().getHintText(), "Нажмите на вкладку «Закупки»");
        app.goTo().purchases();
        assertEquals(app.tutorial().getHintText(), "Перейдите в раздел «Приемки»");
        app.goTo().supplies();
        assertEquals(app.tutorial().getHintText(), "Чтобы учесть поступление товара, нажмите кнопку «+ Приемка»");
        app.supply().clickButtonNewSupply();
        assertEquals(app.tutorial().getHintText(), "Нажмите на стрелочку, чтобы выбрать контрагента");
        app.click().listOfCounterparty();
        assertEquals(app.tutorial().getHintText(), "Выберите Поставщика");
        app.click().selectCounterparty();
        assertEquals(app.tutorial().getHintText(), "Добавьте товар в приёмку. Вы можете сделать это, введя его наименование и" +
                " выбрав соответствующий товар из списка, либо же выбрав его из Справочника.");
        app.click().addPosition("Ошибка");
        assertEquals(app.tutorial().getHintText(), "Нажмите на товар, чтобы добавить его в приемку");
        app.tutorial().clearAddPosition();
        app.click().listOfCounterparty();
        app.click().selectCounterparty();
        app.click().addPosition("Товар");
        Thread.sleep(1000);
        assertEquals(app.tutorial().getHintText(), "Нажмите на товар, чтобы добавить его в приемку");
        app.click().selectGood();
        assertEquals(app.tutorial().getHintText(), "Укажите кол-во товара - 6");
        app.supply().setGoodCount("6");
        assertEquals(app.tutorial().getHintText(), "Укажите цену товара - 1000");
        app.supply().setPrice("1000");
        assertEquals(app.tutorial().getHintText(), "Нажмите кнопку «Сохранить»");
        app.click().saveButton();
        assertEquals(app.tutorial().getHintText(), "Нажмите кнопку «Закрыть»");
        app.click().closeButton();
        assertEquals(app.tutorial().getOverThirdStepText(), "Поздравляем!\nВы завершили третий шаг,\nосталось еще три.");
        app.tutorial().clickOverTutorialStepHelp();
        assertEquals(app.tutorial().getHintText(), "Нажмите на вкладку «Склад»");
    }

    @Test
    public void testFindAndAdd() throws InterruptedException {
        app.goTo().purchases();
        app.goTo().supplies();
        Thread.sleep(500);
        app.supply().clickButtonNewSupply();
        app.click().addPosition("FullProduct");
        Assert.assertEquals(app.tutorial().getBubbleText(), "FP001 – fp1 FullProduct");
        app.click().addPosition("FP001");
        Assert.assertEquals(app.tutorial().getBubbleText(), "FP001 – fp1 FullProduct");
        app.click().addPosition("fp1");
        Assert.assertEquals(app.tutorial().getBubbleText(), "FP001 – fp1 FullProduct");
        app.click().addBarcodePosition("2000000999999");
        app.click().catalogButton();
        app.click().addGoodFromCatalog();
        app.click().saveButton();
    }
}
