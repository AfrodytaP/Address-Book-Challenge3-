package com.dfcorp.addressbook;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {
    private static int nextID = 1;
    protected int userId;
    private ArrayList<Contact> contacts = new ArrayList<>();

    public AddressBook(){
        this.userId = nextID++;
        contacts = new ArrayList<>();
    }

    public ArrayList<Contact>getContacts(){
        return contacts;
    }

    public int getUserId() {
        return userId;
    }

    public void addContact(Contact contact) {
        if((Validation.isContactNull(contact))){ throw new IllegalArgumentException("Contact cannot be null");}
        if((Validation.isPhoneNumberDuplicate(contacts, contact))){ throw new IllegalArgumentException("Phone number already exists, duplicate phone numbers are not allowed");}
        if((Validation.isEmailDuplicate(contacts, contact))){ throw new IllegalArgumentException("Email already exists, duplicate emails are not allowed");}
        contacts.add(contact);
    }

    public List<Contact> searchContactsByName(String firstName, String lastName) {
        if(Validation.isStringNullOrEmpty(firstName) || Validation.isStringNullOrEmpty(lastName)) {
            throw new IllegalArgumentException("First name and last name cannot be null or empty");
        }
        List<Contact> matchesFound;
        matchesFound = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getFirstName().contains(firstName) && contact.getLastName().contains(lastName)) {
                matchesFound.add(contact);
            }
        }
        return matchesFound;
    }
}
