package ru.web.moysklad.tests;

import org.testng.annotations.Test;
import ru.web.moysklad.model.OrganizationData;

import static org.testng.Assert.*;


public class HelpFirstStep extends TestBase {

    @Test
    public void testHelpRequisites() throws InterruptedException {
        String hint;
        app.click().help();
        app.tutorial().clickFirstStepHelp();
        hint = app.tutorial().getHintText();
        assertEquals(hint, "Перейдите в раздел «Юр. лица»");
        app.tutorial().goToOrganizations();
        hint = app.tutorial().getHintText();
        assertEquals(hint, "Откройте карточку юр. лица, для этого нажмите на его название");
        //Thread.sleep(500);
        app.organization().selectFirstOrganization();
        hint = app.tutorial().getHintText();
        assertEquals(hint, "Заполните наименование вашей компании");
        app.organization().inputInformation(new OrganizationData("saaa"));
        app.tutorial().clickPopupButton();
        //Thread.sleep(1000);
        hint = app.tutorial().getHintText();
        assertEquals(hint, "Нажмите кнопку «Сохранить»");
        app.click().saveButton();
        //Thread.sleep(500);
        hint = app.tutorial().getHintText();
        assertEquals(hint, "Нажмите кнопку «Закрыть»");
        app.click().closeButton();
        //Thread.sleep(500);
        hint = app.tutorial().getOverTutorialText();
        assertEquals(hint, "Поздравляем!\nВы завершили первый шаг,\nосталось еще пять.");
        app.tutorial().clickOverTutorialStepHelp();
        hint = app.tutorial().getHintText();
        assertEquals(hint, "Нажмите на вкладку «Справочники»");
    }

}
