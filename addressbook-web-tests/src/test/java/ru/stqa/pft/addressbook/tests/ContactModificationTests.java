package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactInformation;

import java.util.Comparator;
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
        Comparator<? super ContactInformation> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
