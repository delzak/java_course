package ru.web.moysklad.tests;

import org.testng.annotations.Test;
import ru.web.moysklad.model.OrganizationData;


public class HelpFirstStep extends TestBase {

    @Test
    public void testHelpRequisites() throws InterruptedException {
        app.getClickHelper().clickHelp();
        app.getClickHelper().clickFirstStepHelp();
        app.getNavigationHelper().goToTutorialOrganizations();
        Thread.sleep(500);
        app.getOrganizationHelper().selectFirstOrganization();
        app.getOrganizationHelper().inputOrganizationInformation(new OrganizationData("saaa"));
        app.getClickHelper().clickPopupButton();
        Thread.sleep(1000);
        app.getClickHelper().clickSaveButton();
        Thread.sleep(500);
        app.getClickHelper().clickCloseButton();
        Thread.sleep(500);
        app.getClickHelper().clickOverTutorialStepHelp();
    }

}
