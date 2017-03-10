package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactInformation;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        app.contact().check();
    }

    @Test
    public void testContactModification(){
        Contacts before = app.contact().all();
        ContactInformation modifiedContact = before.iterator().next();
        ContactInformation contact = new ContactInformation()
                .withId(modifiedContact.getId()).withFirstname("Imya").withLastname("Familiya")
                .withTelephone("telefon").withEmail("kakoy-to@email.com").withAddress("Gde contact givet");
        app.contact().modify(contact);
        Contacts after = app.contact().all();
        assertEquals(after.size(), before.size());

        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    }


}
