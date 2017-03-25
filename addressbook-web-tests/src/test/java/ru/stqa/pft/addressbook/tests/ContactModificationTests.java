package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactInformation;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        if  (app.db().contacts().size() == 0) {
            app.goTo().homePage();
            app.contact().check();
        }
    }

    @Test
    public void testContactModification(){
        app.goTo().homePage();
        Contacts before = app.db().contacts();
        ContactInformation modifiedContact = before.iterator().next();
        ContactInformation contact = new ContactInformation()
                .withId(modifiedContact.getId()).withFirstname("Imya").withLastname("Familiya")
                .withHomePhone("domashTel").withMobilePhone("mobila").withWorkPhone("rabTel").withEmail("kakoy-to@email.com")
                .withAddress("Gde contact givet");
        app.contact().modify(contact);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    }


}
