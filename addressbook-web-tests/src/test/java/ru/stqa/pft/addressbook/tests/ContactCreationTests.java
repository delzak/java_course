package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactInformation;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation() {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        ContactInformation contact = new ContactInformation()
                .withFirstname("Alex").withLastname("Javov").withHomePhone("8987").withMobilePhone("111").withWorkPhone("222")
                .withEmail("anymail@mail.com").withEmail2("aa@aa.aa").withEmail3("bb@bb.bb")
                .withAddress("Any Town, Any Street, Any number house").withGroup("[none]");
        app.contact().create(contact);
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size() + 1));

        assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }

}