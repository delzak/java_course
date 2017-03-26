package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactInformation;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class InviteContactToGroupTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if  (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().check();
        }
        if  (app.db().contacts().size() == 0) {
            app.goTo().homePage();
            app.contact().check();
        }
    }

    @Test
    public void testInviteContactToGroup() {
        app.goTo().homePage();
        Contacts before = app.db().contacts();
        ContactInformation contact = before.iterator().next();
        app.contact().addToGroup(contact);
        app.goTo().homePage();

        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before));
        assertThat(contact.getGroups(), equalTo(after.iterator().next().getGroups()));
        verifyContactListInUI();
    }
}
