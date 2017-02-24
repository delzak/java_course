package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactInformation;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().createContact(new ContactInformation("Alex",
                "Javov", "89876543210", "anymail@mail.com",
                "Any Town, Any Street, Any number house", "[none]"));
    }

}