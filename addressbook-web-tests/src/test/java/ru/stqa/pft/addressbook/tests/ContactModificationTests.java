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
        app.goTo().homePage();
        app.contact().check();
    }

    @Test
    public void testContactModification(){
        List<ContactInformation> before = app.contact().list();
        int index = before.size() - 1;
        ContactInformation contact = new ContactInformation()
                .withId(before.get(index).getId()).withFirstname("Imya").withLastname("Familiya")
                .withTelephone("telefon").withEmail("kakoy-to@email.com").withAddress("Gde contact givet");
        app.contact().modify(index, contact);
        List<ContactInformation> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(contact);
        Comparator<? super ContactInformation> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }


}
