package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactInformation;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;

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
        type(By.name("home"), contactInformation.getHomePhone());
        type(By.name("mobile"),contactInformation.getMobilePhone());
        type(By.name("work"),contactInformation.getWorkPhone());
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

    public void submitContactModification() {
        click(By.name("update"));
    }

    public void check() {
        if (! isElementPresent(By.name("selected[]"))){
            create(new ContactInformation().withFirstname("test").withLastname("test").withHomePhone("999")
                    .withMobilePhone("888").withWorkPhone("777").withEmail("test").withAddress("test").withGroup("[none]"));
        }
    }

    public void create(ContactInformation contact) {
        clickAddNewContact();
        inputContactInformation(contact, true);
        submitContactInformation();
        returnToContactPage();
    }

    public void modify(ContactInformation contact) {
        initContactModificationById(contact.getId());
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

    public void initContactModificationById(int id) {
        WebElement checkbox = wd.findElement(By.cssSelector("input[value='" + id + "']"));
        WebElement row = checkbox.findElement(By.xpath("./../.."));
        List<WebElement> cells = row.findElements(By.tagName("td"));
        cells.get(7).findElement(By.tagName("a")).click();
    }

    public Contacts all() {
        Contacts contacts = new Contacts();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            List<WebElement> cells = element.findElements(By.tagName("td"));
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String lastName = cells.get(1).getText();
            String firstName = cells.get(2).getText();
            String allPhones = cells.get(5).getText();
            String address = cells.get(3).getText();
            contacts.add(new ContactInformation().withId(id).withFirstname(firstName).withLastname(lastName)
                    .withAllPhones(allPhones).withAddress(address));
        }
        return contacts;
    }

    public ContactInformation infoFromEditForm(ContactInformation contact) {
        initContactModificationById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getText();
        wd.navigate().back();
        return new ContactInformation().withId(contact.getId()).withFirstname(firstname).withLastname(lastname)
                .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work).withAddress(address);
    }
}