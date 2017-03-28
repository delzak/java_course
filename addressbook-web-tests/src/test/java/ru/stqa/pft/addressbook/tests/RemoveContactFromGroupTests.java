package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactInformation;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class RemoveContactFromGroupTests extends TestBase{
    @BeforeMethod
    public void ensurePreconditions() {
        if  (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().check();
        }
        if  (app.db().contacts().size() == 0) {
            app.goTo().homePage();
            app.contact().checkWithGroup();
        }
        //тут нужно добавить проверку наличия группы у контакта. Хотя, я бы внес эту проверку в сам тест, а не в предусловия
    }

    @Test
    public void testRemoveContactFromGroup() {
        app.goTo().homePage();
        Groups groups = app.db().groups();
        Contacts before = app.db().contacts();
        ContactInformation contact = before.iterator().next();
        if (contact.getGroups().size()==0) {
            app.contact().addToGroup(contact, groups.iterator().next());
            app.goTo().homePage();
        }
        if (contact.getGroups().size() > 0) {
            System.out.println("Contact in group" + contact.getGroups());
            app.contact().removeFromGroup(contact, contact.getGroups().iterator().next());
            app.goTo().homePage();
        }
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before));
        //тут должна быть проверка, что контакт был удален из группы
        verifyContactListInUI();
    }
}
