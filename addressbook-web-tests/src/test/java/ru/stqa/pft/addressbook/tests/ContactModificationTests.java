package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactInformation;

/**
 * Created by Алексей on 20.02.2017.
 */
public class ContactModificationTests extends TestBase{

    @Test
    public void testContactModification(){
        app.getNavigationHelper().gotoHomePage();
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().checkContact();
        app.getContactHelper().initContactModification(before - 1);
        app.getContactHelper().inputContactInformation(new ContactInformation("Imya", "Familiya",
                "telefon", "kakoy-to@email.com", "Gde contact givet", null), false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToContactPage();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before);
    }
}
