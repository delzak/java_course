package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactInformation;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactInformationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        app.contact().check();
    }

    @Test
    public void testContactInformation() {
        app.goTo().homePage();
        ContactInformation contact = app.contact().all().iterator().next();
        ContactInformation contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        ContactInformation contactInfoFromDetailsForm = app.contact().infoFromDetailsForm(contact);

        assertThat(cleaned(contactInfoFromDetailsForm.getFullInformation()), equalTo(mergeFullInformation(contactInfoFromEditForm)));
    }

    private String mergeFullInformation(ContactInformation contact) {
        return Arrays.asList(contact.getFirstname(), contact.getLastname(), contact.getAddress(), "H:" + contact.getHomePhone(),
           "M:" + contact.getMobilePhone(), "W:" + contact.getWorkPhone(), contact.getEmail(), contact.getEmail2(), contact.getEmail3())
                .stream().filter((s) -> ! s.equals(""))
                .map(ContactInformationTests::cleaned)
                .collect(Collectors.joining(""));
    }

    public static String cleaned (String fullName) {
        return fullName.replaceAll("\n","").replaceAll("\\s","").replaceAll("[-()]", "");
    }
}
