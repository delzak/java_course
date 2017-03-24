package ru.stqa.pft.addressbook.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;

@Entity
@Table(name = "addressbook")

@XStreamAlias("contact")
public class ContactInformation {
    @XStreamOmitField
    @Id
    @Column(name = "id")
    private int id = Integer.MAX_VALUE;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Transient
    private String fullInformation;

    @Column(name = "home")
    @Type(type = "text")
    private String homePhone;

    @Column(name = "mobile")
    @Type(type = "text")
    private String mobilePhone;

    @Column(name = "work")
    @Type(type = "text")
    private String workPhone;

    @Transient
    private String allPhones;

    @Column(name = "email")
    @Type(type = "text")
    private String email;

    @Column(name = "email2")
    @Type(type = "text")
    private String email2;

    @Column(name = "email3")
    @Type(type = "text")
    private String email3;

    @Transient
    private String allEmails;

    @Column(name = "address")
    @Type(type = "text")
    private String address;

    @Transient
    private String group;

    //@Column(name = "photo")
    //@Type(type = "text")
    @Transient
    private File photo;

    public File getPhoto() {
        return photo;
    }

    public ContactInformation withPhoto(File photo) {
        this.photo = photo;
        return this;
    }

    public String getFullInformation() {
        return fullInformation;
    }

    public ContactInformation withFullInfromation(String fullInformation) {
        this.fullInformation = fullInformation;
        return this;
    }

    public String getAllEmails() {
        return allEmails;
    }

    public ContactInformation withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    public String getEmail2() {
        return email2;
    }

    public ContactInformation withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public String getEmail3() {
        return email3;
    }

    public ContactInformation withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public ContactInformation withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public ContactInformation withWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public ContactInformation withMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public ContactInformation withHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public int getId() {
        return id;
    }

    public ContactInformation withId(int id) {
        this.id = id;
        return this;
    }

    public ContactInformation withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactInformation withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }



    public ContactInformation withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactInformation withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactInformation withGroup(String group) {
        this.group = group;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }



    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return "ContactInformation{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactInformation that = (ContactInformation) o;

        if (id != that.id) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;
    }
}
