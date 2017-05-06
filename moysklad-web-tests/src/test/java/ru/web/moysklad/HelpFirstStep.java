package ru.web.moysklad;

import org.testng.annotations.Test;


public class HelpFirstStep extends TestBase {

    @Test
    public void testHelpRequisites() throws InterruptedException {
        clickHelp();
        clickFirstStepHelp();
        goToOrganizations();
        Thread.sleep(500);
        selectFirstOrganization();
        inputOrganizationInformation(new OrganizationData("saaa"));
        clickPopupButton();
        Thread.sleep(1000);
        clickSaveButton();
        Thread.sleep(500);
        clickCloseButton();
        Thread.sleep(500);
        clickOverTutorialStepHelp();
    }

}
