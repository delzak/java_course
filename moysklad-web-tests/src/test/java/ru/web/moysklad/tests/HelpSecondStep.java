package ru.web.moysklad.tests;

import org.testng.annotations.Test;
import ru.web.moysklad.model.ProductData;

import static org.testng.Assert.assertEquals;


public class HelpSecondStep extends TestBase{

    @Test
    public void testHelpGoods() {
        app.click().help();
        app.tutorial().clickSecondStepHelp();
        assertEquals(app.tutorial().getHintText(), "Нажмите на вкладку «Справочники»");
        app.goTo().catalog();
        assertEquals(app.tutorial().getHintText(), "Перейдите в раздел «Товары и услуги»");
        app.goTo().productsAndServices();
        assertEquals(app.tutorial().getHintText(), "Чтобы добавить новый товар, нажмите кнопку «+ Товар»");
        app.good().clickButtonNewProduct();
        assertEquals(app.tutorial().getHintText(), "Введите название товара");
        app.good().inputProductName(new ProductData().withName("Товар"));
        assertEquals(app.tutorial().getHintText(), "Введите цену продажи товара - 1500");
        app.good().inputProductPrice(new ProductData().withSum("1500"));
        assertEquals(app.tutorial().getHintText(), "Нажмите кнопку «Сохранить»");
        app.click().saveButton();
        assertEquals(app.tutorial().getHintText(), "Нажмите кнопку «Закрыть»");
        app.click().closeButton();
        assertEquals(app.tutorial().getOverSecondStepText(), "Поздравляем!\nВы завершили второй шаг,\nосталось еще четыре.");
        app.tutorial().clickOverTutorialStepHelp();
        assertEquals(app.tutorial().getHintText(), "Для контроля остатков товаров, а также расчета " +
                "себестоимости и прибыли необходимо вести учет поступлений товара на склад.");
    }

}
