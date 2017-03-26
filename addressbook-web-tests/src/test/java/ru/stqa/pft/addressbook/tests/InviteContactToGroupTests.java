package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactInformation;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.Groups;

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
        Groups groups = app.db().groups();
        app.goTo().homePage();
        Contacts before = app.db().contacts();
        ContactInformation invitedContact = before.iterator().next();
        ContactInformation contact = invitedContact.inGroup(groups.iterator().next());
        app.contact().addToGroup(contact);
        app.goTo().homePage();

        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before));
        assertThat(after.iterator().next().getGroups(), equalTo(contact.getGroups()));
        verifyContactListInUI();
    }
}
