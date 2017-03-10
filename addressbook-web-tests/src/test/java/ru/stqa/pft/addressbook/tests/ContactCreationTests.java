package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactInformation;

import java.util.Set;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation() {
        app.goTo().homePage();
        Set<ContactInformation> before = app.contact().all();
        ContactInformation contact = new ContactInformation()
                .withFirstname("Alex").withLastname("Javov").withTelephone("89876543210")
                .withEmail("anymail@mail.com").withAddress("Any Town, Any Street, Any number house").withGroup("[none]");
        app.contact().create(contact);
        Set<ContactInformation> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() + 1);

        contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
        before.add(contact);
        Assert.assertEquals(before, after);
    }

}