package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactInformation;

import java.util.Set;

public class ContactModificationTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        app.contact().check();
    }

    @Test
    public void testContactModification(){
        Set<ContactInformation> before = app.contact().all();
        ContactInformation modifiedContact = before.iterator().next();
        ContactInformation contact = new ContactInformation()
                .withId(modifiedContact.getId()).withFirstname("Imya").withLastname("Familiya")
                .withTelephone("telefon").withEmail("kakoy-to@email.com").withAddress("Gde contact givet");
        app.contact().modify(contact);
        Set<ContactInformation> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size());

        before.remove(modifiedContact);
        before.add(contact);
        Assert.assertEquals(before, after);
    }


}
