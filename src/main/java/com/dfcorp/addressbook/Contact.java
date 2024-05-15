package com.dfcorp.addressbook;

public class Contact {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    public Contact(String firstName, String lastName, String phoneNumber, String email) {
        this.firstName = Validation.validateName(firstName);
        this.lastName = Validation.validateName(lastName);
        this.phoneNumber = Validation.validatePhoneNumber(phoneNumber);
        this.email = Validation.validateEmail(email);
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
}
