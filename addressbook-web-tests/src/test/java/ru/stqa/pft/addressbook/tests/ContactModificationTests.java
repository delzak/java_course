package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactInformation;

import java.util.HashSet;
import java.util.List;

/**
 * Created by Алексей on 20.02.2017.
 */
public class ContactModificationTests extends TestBase{

    @Test
    public void testContactModification(){
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().checkContact();
        List<ContactInformation> before = app.getContactHelper().getContactList();
        app.getContactHelper().initContactModification(before.size() - 1);
        ContactInformation contact = new ContactInformation(before.get(before.size() - 1).getId(),"Imya", "Familiya",
                "telefon", "kakoy-to@email.com", "Gde contact givet", null);
        app.getContactHelper().inputContactInformation(contact, false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToContactPage();
        List<ContactInformation> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(contact);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }
}
