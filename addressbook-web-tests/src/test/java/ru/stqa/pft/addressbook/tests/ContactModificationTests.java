package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactInformation;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Алексей on 20.02.2017.
 */
public class ContactModificationTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().gotoHomePage();
        app.getContactHelper().checkContact();
    }

    @Test
    public void testContactModification(){
        List<ContactInformation> before = app.getContactHelper().getContactList();
        int index = before.size() - 1;
        ContactInformation contact = new ContactInformation(before.get(index).getId(),"Imya", "Familiya",
                "telefon", "kakoy-to@email.com", "Gde contact givet", null);
        app.getContactHelper().modifyContact(index, contact);
        List<ContactInformation> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(contact);
        Comparator<? super ContactInformation> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }


}
