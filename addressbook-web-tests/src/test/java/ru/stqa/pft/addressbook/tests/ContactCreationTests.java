package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactInformation;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation() {
        app.gotoHomePage();
        app.clickAddNewContact();
        app.inputContactInformation(new ContactInformation("Alex", "Javov", "89876543210", "anemail@mail.com", "Any Town, Any Street, Any number house"));
        app.submitContactInformation();
        app.returnToContactPage();
    }

}