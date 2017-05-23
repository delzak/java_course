package ru.web.moysklad.tests;

import org.testng.annotations.Test;
import ru.web.moysklad.model.ProductData;

import static org.testng.Assert.assertEquals;


public class HelpSecondStep extends TestBase{

    @Test
    public void testHelpGoods() throws InterruptedException {
        String hint;
        app.click().help();
        app.tutorial().clickSecondStepHelp();
        hint = app.tutorial().getHintText();
        assertEquals(hint, "Нажмите на вкладку «Справочники»");
        app.tutorial().goToCatalog();
        hint = app.tutorial().getHintText();
        assertEquals(hint, "Перейдите в раздел «Товары и услуги»");
        app.tutorial().goToGoods();
        //Thread.sleep(500);
        hint = app.tutorial().getHintText();
        assertEquals(hint, "Чтобы добавить новый товар, нажмите кнопку «+ Товар»");
        app.good().clickButtonNewProduct();
        hint = app.tutorial().getHintText();
        assertEquals(hint, "Введите название товара");
        app.tutorial().inputProductName(new ProductData("Товар", null));
        //Thread.sleep(500);
        hint = app.tutorial().getHintText();
        assertEquals(hint, "Введите цену продажи товара - 1500");
        app.tutorial().inputProductPrice(new ProductData("1500"));
        hint = app.tutorial().getHintText();
        assertEquals(hint, "Нажмите кнопку «Сохранить»");
        app.click().saveButton();
        //Thread.sleep(500);
        hint = app.tutorial().getHintText();
        assertEquals(hint, "Нажмите кнопку «Закрыть»");
        app.click().closeButton();
        //Thread.sleep(500);
        hint = app.tutorial().getOverSecondStepText();
        assertEquals(hint, "Поздравляем!\nВы завершили второй шаг,\nосталось еще четыре.");
        app.tutorial().clickOverTutorialStepHelp();
        hint = app.tutorial().getHintText();
        assertEquals(hint, "Для контроля остатков товаров, а также расчета " +
                "себестоимости и прибыли необходимо вести учет поступлений товара на склад.");
    }

}
