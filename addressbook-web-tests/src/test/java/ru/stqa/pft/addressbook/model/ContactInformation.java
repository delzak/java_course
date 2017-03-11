package ru.stqa.pft.addressbook.model;

public class ContactInformation {
    private int id = Integer.MAX_VALUE;
    private String firstname;
    private String lastname;
    private String homePhone;
    private String mobilePhone;
    private String workPhone;
    private String allPhones;
    private String email;
    private String email2;
    private String email3;
    private String allEmails;
    private String address;
    private String group;

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
