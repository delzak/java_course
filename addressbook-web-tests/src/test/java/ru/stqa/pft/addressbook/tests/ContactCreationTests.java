package ru.stqa.pft.addressbook.tests;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactInformation;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase{

    @DataProvider
    public Iterator<Object[]> validContactsFromCsv() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")))) {
            String line = reader.readLine();
            while (line != null){
                String[] split = line.split(";");
                list.add(new Object[]{new ContactInformation().withFirstname(split[0]).withLastname(split[1]).withAddress(split[2])
                    .withEmail(split[3]).withEmail2(split[4]).withEmail3(split[5]).withHomePhone(split[6]).withMobilePhone(split[7])
                    .withWorkPhone(split[8]).withPhoto(new File(split[10]))});
                line = reader.readLine();
            }
            return list.iterator();
        }
    }

    @DataProvider
    public Iterator<Object[]> validContactsFromXml() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")))) {
            String xml = "";
            String line = reader.readLine();
            while (line != null){
                xml += line;
                line = reader.readLine();
            }
            XStream xstream = new XStream();
            xstream.processAnnotations(ContactInformation.class);
            List<ContactInformation> contacts = (List<ContactInformation>) xstream.fromXML(xml);
            return contacts.stream().map((c) -> new Object[] {c}).collect(Collectors.toList()).iterator();
        }
    }

    @DataProvider
    public Iterator<Object[]> validContactsFromJson() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")))) {
            String json = "";
            String line = reader.readLine();
            while (line != null){
                json += line;
                line = reader.readLine();
            }
            Gson gson = new Gson();
            List<ContactInformation> contacts = gson.fromJson(json, new TypeToken<List<ContactInformation>>(){}.getType());
            return contacts.stream().map((c) -> new Object[] {c}).collect(Collectors.toList()).iterator();
        }
    }

    @BeforeMethod
    public void ensurePreconditions() {
        if  (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().check();
        }
    }


    @Test(dataProvider = "validContactsFromJson")
    public void testContactCreation(ContactInformation contact) {
        Groups groups = app.db().groups();
        app.goTo().homePage();
        Contacts before = app.db().contacts();
        app.contact().create(contact.inGroup(groups.iterator().next()));
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.db().contacts();

        assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
        verifyContactListInUI();
    }

    @Test
    public void testBadContactCreation() {
        Groups groups = app.db().groups();
        ContactInformation newContact = new ContactInformation().withFirstname("Alex'").inGroup(groups.iterator().next());
        app.goTo().homePage();
        Contacts before = app.db().contacts();
        app.contact().create(newContact);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.db().contacts();

        assertThat(after, equalTo(before));
        verifyContactListInUI();
    }

}