package ru.web.moysklad.tests;

import org.testng.annotations.Test;
import ru.web.moysklad.model.OrganizationData;


public class HelpFirstStep extends TestBase {

    @Test
    public void testHelpRequisites() throws InterruptedException {
        app.click().help();
        app.tutorial().clickFirstStepHelp();
        app.tutorial().goToOrganizations();
        Thread.sleep(500);
        app.organization().selectFirstOrganization();
        app.organization().inputInformation(new OrganizationData("saaa"));
        app.tutorial().clickPopupButton();
        Thread.sleep(1000);
        app.click().saveButton();
        Thread.sleep(500);
        app.click().closeButton();
        Thread.sleep(500);
        app.tutorial().clickOverTutorialStepHelp();
    }

}
