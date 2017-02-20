package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactInformation;

/**
 * Created by Алексей on 20.02.2017.
 */
public class ContactHelper extends HelperBase{

    public ContactHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void returnToContactPage() {
        click(By.linkText("home page"));
    }

    public void submitContactInformation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void inputContactInformation(ContactInformation contactInformation) {
        type(By.name("firstname"), contactInformation.getFirstname());
        type(By.name("lastname"), contactInformation.getLastname());
        type(By.name("home"), contactInformation.getTelephone());
        type(By.name("email"), contactInformation.getEmail());
        type(By.name("address"), contactInformation.getAddress());

    }

    public void clickAddNewContact() {
        click(By.linkText("add new"));
    }

    public void deleteSelectedContacts() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
        wd.switchTo().alert().accept();
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }
}
