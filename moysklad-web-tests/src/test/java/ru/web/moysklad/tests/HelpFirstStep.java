package ru.web.moysklad.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.web.moysklad.model.OrganizationData;

import java.util.Set;

import static org.testng.Assert.*;


public class HelpFirstStep extends TestBase {

    @Test
    public void testHelpRequisites() {
        app.click().help();
        app.tutorial().clickFirstStepHelp();
        assertEquals(app.tutorial().getHintText(), "Перейдите в раздел «Юр. лица»");
        app.tutorial().goToOrganizations();
        Set<OrganizationData> organizations = app.organization().all();
        assertTrue(organizations.size() > 0);
        assertEquals(app.tutorial().getHintText(), "Откройте карточку юр. лица, для этого нажмите на его название");
        app.organization().selectFirstOrganization();
        assertEquals(app.tutorial().getHintText(), "Заполните наименование вашей компании");
        app.organization().inputInformation(new OrganizationData().withOrganizationName("saaa"));
        app.tutorial().clickPopupButton();
        assertEquals(app.tutorial().getHintText(), "Нажмите кнопку «Сохранить»");
        app.click().saveButton();
        assertEquals(app.tutorial().getHintText(), "Нажмите кнопку «Закрыть»");
        app.click().closeButton();
        assertEquals(app.tutorial().getOverFirstStepText(), "Поздравляем!\nВы завершили первый шаг,\nосталось еще пять.");
        app.tutorial().clickOverTutorialStepHelp();
        assertEquals(app.tutorial().getHintText(), "Нажмите на вкладку «Справочники»");
    }

}
