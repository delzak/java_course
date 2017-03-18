package ru.stqa.pft.addressbook.generators;

import ru.stqa.pft.addressbook.model.ContactInformation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactInformationGenerator {

    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(args[0]);
        File file = new File(args[1]);
        List<ContactInformation> contacts = generateContacts(count);
        save(contacts, file);
    }

    private static void save(List<ContactInformation> contacts, File file) throws IOException {
        System.out.println(new File(".").getAbsoluteFile());
        Writer writer = new FileWriter(file);
        for (ContactInformation contact : contacts) {
            writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s\n", contact.getFirstname(),
                    contact.getLastname(), contact.getAddress(), contact.getEmail(), contact.getEmail2(),
                    contact.getEmail3(), contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone()));
        }
        writer.close();
    }

    private static List<ContactInformation> generateContacts(int count) {
        List<ContactInformation> contacts = new ArrayList<ContactInformation>();
        for (int i = 0; i < count; i++) {
            contacts.add(new ContactInformation().withFirstname(String.format("firstName %s", i))
            .withLastname(String.format("lastName %s", i)).withAddress(String.format("address %s", i))
            .withEmail(String.format("email %s", i)).withEmail2(String.format("email2 %s", i))
            .withEmail3(String.format("email3 %s", i)).withHomePhone(String.format("homePhone %s", i))
            .withMobilePhone(String.format("mobilePhone %s", i)).withWorkPhone(String.format("workPhone %s", i)));
        }
        return contacts;
    }

}
