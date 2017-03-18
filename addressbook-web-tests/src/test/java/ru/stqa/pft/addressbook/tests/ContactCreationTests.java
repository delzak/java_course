package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactInformation;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase{

    @DataProvider
    public Iterator<Object[]> validContacts() {
        List<Object[]> list = new ArrayList<Object[]>();
        File photo = new File("src/test/resources/picture.png");
        list.add(new Object[] {new ContactInformation().withFirstname("Alex 1").withLastname("Javov 1")
                .withHomePhone("8987 1").withMobilePhone("111 1").withWorkPhone("222 1").withEmail("il@mail.com 1")
                .withEmail2("aa@aa.aa 1").withEmail3("bb@bb.bb 1").withAddress("Address 1").withGroup("[none]").withPhoto(photo)});
        list.add(new Object[] {new ContactInformation().withFirstname("Alex 2").withLastname("Javov 2")
                .withHomePhone("8987 2").withMobilePhone("111 2").withWorkPhone("222 2").withEmail("il@mail.com 2")
                .withEmail2("aa@aa.aa 2").withEmail3("bb@bb.bb 2").withAddress("Address 2").withGroup("[none]").withPhoto(photo)});
        list.add(new Object[] {new ContactInformation().withFirstname("Alex 3").withLastname("Javov 3")
                .withHomePhone("8987 3").withMobilePhone("111 3").withWorkPhone("222 3").withEmail("il@mail.com 3")
                .withEmail2("aa@aa.aa 3").withEmail3("bb@bb.bb 3").withAddress("Address 3").withGroup("[none]").withPhoto(photo)});
        return list.iterator();
    }

    @Test(dataProvider = "validContacts")
    public void testContactCreation(ContactInformation contact) {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        app.contact().create(contact);
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();

        assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }

    @Test
    public void testBadContactCreation() {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        ContactInformation contact = new ContactInformation().withFirstname("Alex'").withGroup("[none]");
        app.contact().create(contact);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.contact().all();


        assertThat(after, equalTo(before));
    }

}