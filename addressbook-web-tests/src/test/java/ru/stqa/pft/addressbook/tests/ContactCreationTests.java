package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactInformation;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation() {
        app.goTo().gotoHomePage();
        List<ContactInformation> before = app.getContactHelper().getContactList();
        ContactInformation contact = new ContactInformation("Alex",
                "Javov", "89876543210", "anymail@mail.com",
                "Any Town, Any Street, Any number house", "[none]");
        app.getContactHelper().createContact(contact);
        List<ContactInformation> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(contact);
        Comparator<? super ContactInformation> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }

}