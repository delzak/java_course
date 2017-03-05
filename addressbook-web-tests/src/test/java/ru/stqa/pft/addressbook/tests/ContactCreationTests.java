package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactInformation;

import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().gotoHomePage();
        List<ContactInformation> before = app.getContactHelper().getContactList();
        ContactInformation contact = new ContactInformation("Alex",
                "Javov", "89876543210", "anymail@mail.com",
                "Any Town, Any Street, Any number house", "[none]");
        app.getContactHelper().createContact(contact);
        List<ContactInformation> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);

        contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.add(contact);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }

}