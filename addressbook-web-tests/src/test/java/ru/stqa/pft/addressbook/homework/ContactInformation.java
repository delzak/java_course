package ru.stqa.pft.addressbook.homework;

public class ContactInformation {
    private final String firstname;
    private final String lastname;
    private final String telephone;
    private final String email;
    private final String address;

    public ContactInformation(String firstname, String lastname, String telephone, String email, String address) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.telephone = telephone;
        this.email = email;
        this.address = address;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }
}
