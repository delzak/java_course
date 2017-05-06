package ru.web.moysklad.tests;

import org.testng.annotations.Test;
import ru.web.moysklad.model.OrganizationData;


public class HelpFirstStep extends TestBase {

    @Test
    public void testHelpRequisites() throws InterruptedException {
        app.clickHelp();
        app.clickFirstStepHelp();
        app.goToOrganizations();
        Thread.sleep(500);
        app.selectFirstOrganization();
        app.inputOrganizationInformation(new OrganizationData("saaa"));
        app.clickPopupButton();
        Thread.sleep(1000);
        app.clickSaveButton();
        Thread.sleep(500);
        app.clickCloseButton();
        Thread.sleep(500);
        app.clickOverTutorialStepHelp();
    }

}
