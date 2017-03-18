package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.addressbook.model.ContactInformation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactInformationGenerator {

    @Parameter(names = "-c", description = "Contact count")
    public int count;

    @Parameter(names = "-f", description = "Target file")
    public String file;

    @Parameter(names = "-d", description = "Data format")
    public String format;

    public static void main(String[] args) throws IOException {
        ContactInformationGenerator generator = new ContactInformationGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex) {
            jCommander.usage();
            return;
        }
        generator.run();
    }

    private void run() throws IOException {
        List<ContactInformation> contacts = generateContacts(count);
        if (format.equals("csv")){
            saveAsCsv(contacts, new File(file));
        } else if (format.equals("xml")){
            saveAsXml(contacts, new File(file));
        } else if (format.equals("json")){
            saveAsJson(contacts, new File(file));
        } else {
            System.out.println("Unrecognized format" + format);
        }

    }

    private void saveAsJson(List<ContactInformation> contacts, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(contacts);
        try (Writer writer = new FileWriter(file)) {
            writer.write(json);
        }
    }

    private void saveAsXml(List<ContactInformation> contacts, File file) throws IOException {
        XStream xstream = new XStream();
        xstream.processAnnotations(ContactInformation.class);
        String xml = xstream.toXML(contacts);
        try (Writer writer = new FileWriter(file)) {
            writer.write(xml);
        }
    }

    private void saveAsCsv(List<ContactInformation> contacts, File file) throws IOException {
        System.out.println(new File(".").getAbsoluteFile());
        try (Writer writer = new FileWriter(file)) {
            for (ContactInformation contact : contacts) {
                writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s\n", contact.getFirstname(), contact.getLastname(),
                    contact.getAddress(), contact.getEmail(), contact.getEmail2(), contact.getEmail3(),
                    contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone(), contact.getGroup(), contact.getPhoto()));
            }
        }
    }

    private List<ContactInformation> generateContacts(int count) {
        List<ContactInformation> contacts = new ArrayList<ContactInformation>();
        for (int i = 0; i < count; i++) {
            contacts.add(new ContactInformation().withFirstname(String.format("firstName %s", i))
            .withLastname(String.format("lastName %s", i)).withAddress(String.format("address %s", i))
            .withEmail(String.format("email %s", i)).withEmail2(String.format("email2 %s", i))
            .withEmail3(String.format("email3 %s", i)).withHomePhone(String.format("homePhone %s", i))
            .withMobilePhone(String.format("mobilePhone %s", i)).withWorkPhone(String.format("workPhone %s", i)).withGroup("[none]")
            .withPhoto(new File("src/test/resources/picture.png")));
        }
        return contacts;
    }

}
