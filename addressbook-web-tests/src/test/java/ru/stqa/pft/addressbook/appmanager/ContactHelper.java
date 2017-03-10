package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactInformation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Алексей on 20.02.2017.
 */
public class ContactHelper extends HelperBase{

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToContactPage() {
        click(By.linkText("home page"));
    }

    public void submitContactInformation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void inputContactInformation(ContactInformation contactInformation, boolean creation) {
        type(By.name("firstname"), contactInformation.getFirstname());
        type(By.name("lastname"), contactInformation.getLastname());
        type(By.name("home"), contactInformation.getTelephone());
        type(By.name("email"), contactInformation.getEmail());
        type(By.name("address"), contactInformation.getAddress());

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactInformation.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void clickAddNewContact() {
        click(By.linkText("add new"));
    }

    public void deleteSelectedContacts() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void initContactModification() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public void check() {
        if (! isElementPresent(By.name("selected[]"))){
            create(new ContactInformation().withFirstname("test").withGroup("[none]"));
        }
    }

    public void create(ContactInformation contact) {
        clickAddNewContact();
        inputContactInformation(contact, true);
        submitContactInformation();
        returnToContactPage();
    }

    public void modify(ContactInformation contact) {
        initContactModification();
        inputContactInformation(contact, false);
        submitContactModification();
        returnToContactPage();
    }

    public void delete(ContactInformation contact) {
        selectContactById(contact.getId());
        deleteSelectedContacts();
        acceptForm();
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public Set<ContactInformation> all() {
        Set<ContactInformation> contacts = new HashSet<ContactInformation>();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            String lastName = element.findElement(By.xpath(".//td[2]")).getText();
            String firstName = element.findElement(By.xpath(".//td[3]")).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            contacts.add(new ContactInformation().withId(id).withFirstname(firstName).withLastname(lastName));
        }
        return contacts;
    }
}
