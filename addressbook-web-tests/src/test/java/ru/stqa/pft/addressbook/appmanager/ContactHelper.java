package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactInformation;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.File;
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
        type(By.name("email2"), contactInformation.getEmail2());
        type(By.name("email3"), contactInformation.getEmail3());
        type(By.name("address"), contactInformation.getAddress());
        attach(By.name("photo"), contactInformation.getPhoto());

        if (creation) {
            if (contactInformation.getGroups().size() > 0) {
                Assert.assertTrue(contactInformation.getGroups().size() == 1);
                new Select(wd.findElement(By.name("new_group")))
                        .selectByVisibleText(contactInformation.getGroups().iterator().next().getName());
            }
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
                .withMobilePhone("888").withWorkPhone("777").withEmail("test").withEmail2("test").withEmail3("test")
                .withAddress("test").withPhoto(new File("src/test/resources/picture.png")));
        }
    }

    public void checkWithGroup() {
        if (! isElementPresent(By.name("selected[]"))){
            create(new ContactInformation().withFirstname("test").withLastname("test").withHomePhone("999")
                    .withMobilePhone("888").withWorkPhone("777").withEmail("test").withEmail2("test").withEmail3("test")
                    .withAddress("test").withPhoto(new File("src/test/resources/picture.png")));
            click(By.name("selected[]"));
            click(By.name("add"));
        }
    }

    public void create(ContactInformation contact) {
        clickAddNewContact();
        inputContactInformation(contact, true);
        submitContactInformation();
        contactCache = null;
        returnToContactPage();
    }

    public void modify(ContactInformation contact) {
        initContactModificationById(contact.getId());
        inputContactInformation(contact, false);
        submitContactModification();
        contactCache = null;
        returnToContactPage();
    }

    public void delete(ContactInformation contact) {
        selectContactById(contact.getId());
        deleteSelectedContacts();
        acceptForm();
        contactCache = null;
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public void initContactModificationById(int id) {
        WebElement checkbox = wd.findElement(By.cssSelector("input[value='" + id + "']"));
        WebElement row = checkbox.findElement(By.xpath("./../.."));
        List<WebElement> cells = row.findElements(By.tagName("td"));
        cells.get(7).findElement(By.tagName("a")).click();
    }

    private Contacts contactCache = null;

    public Contacts all() {
        if (contactCache != null) {
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            List<WebElement> cells = element.findElements(By.tagName("td"));
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String lastName = cells.get(1).getText();
            String firstName = cells.get(2).getText();
            String address = cells.get(3).getText();
            String allEmails = cells.get(4).getText();
            String allPhones = cells.get(5).getText();

            contactCache.add(new ContactInformation().withId(id).withFirstname(firstName).withLastname(lastName)
                    .withAddress(address).withAllEmails(allEmails).withAllPhones(allPhones));
        }
        return new Contacts(contactCache);
    }

    public ContactInformation infoFromEditForm(ContactInformation contact) {
        initContactModificationById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getText();
        String email = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");

        wd.navigate().back();
        return new ContactInformation().withId(contact.getId()).withFirstname(firstname).withLastname(lastname)
                .withAddress(address).withEmail(email).withEmail2(email2).withEmail3(email3)
                .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work);
    }

    public ContactInformation infoFromDetailsForm(ContactInformation contact){
        seeContactDetailsById(contact.getId());
        String fullInformation = wd.findElement(By.cssSelector("div[id=content]")).getText();
        wd.navigate().back();
        return new ContactInformation().withId(contact.getId()).withFullInfromation(fullInformation);
    }

    public void seeContactDetailsById(int id) {
        WebElement checkbox = wd.findElement(By.cssSelector("input[value='" + id + "']"));
        WebElement row = checkbox.findElement(By.xpath("./../.."));
        List<WebElement> cells = row.findElements(By.tagName("td"));
        cells.get(6).findElement(By.tagName("a")).click();
    }

    public void addToGroup(ContactInformation contact, GroupData group) {
        takeContactForGroup(contact.getId());
        contactAddToGroup(group.getId());
    }

    private void contactAddToGroup(int id) {
        WebElement list = wd.findElement(By.cssSelector("select[name='to_group'"));
        WebElement element = list.findElement(By.tagName("option"));
        element.click();
        click(By.name("add"));
    }

    private void takeContactForGroup(int id) {
        WebElement checkbox = wd.findElement(By.cssSelector("input[value='" + id + "']"));
        WebElement row = checkbox.findElement(By.xpath("./../.."));
        List<WebElement> cells = row.findElements(By.tagName("td"));
        cells.get(0).click();
    }

    public void removeFromGroup(ContactInformation contact, GroupData group) {
        takeContactForGroup(contact.getId());
        goToContactGroup(group.getId());
        takeContactForGroup(contact.getId());
        removeContactFromGroup();
        returnToTableWithAllGroups();
    }

    private void returnToTableWithAllGroups() {
        click(By.linkText("home"));
        wd.findElement(By.cssSelector("option[value='']")).click();
    }

    private void removeContactFromGroup() {
        click(By.name("remove"));
    }

    private void goToContactGroup(int id) {
        wd.findElement(By.cssSelector("option[value='" + id + "']")).click();
    }
}