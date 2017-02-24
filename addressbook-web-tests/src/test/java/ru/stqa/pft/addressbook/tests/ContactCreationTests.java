package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactInformation;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().clickAddNewContact();
        app.getContactHelper().inputContactInformation(new ContactInformation("Alex", "Javov", "89876543210", "anemail@mail.com", "Any Town, Any Street, Any number house", "test1"), true);
        app.getContactHelper().submitContactInformation();
        app.getContactHelper().returnToContactPage();
    }

}