package com.dfcorp.addressbook;

import java.util.ArrayList;

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

        contacts.add(contact);
    }
}
