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
        try {
            Validation.isContactNull(contact);
            contacts.add(contact);
        }catch (IllegalArgumentException e){
            System.out.println("Contact was not added: " + e.getMessage() + " please try again.");
        }

    }
}
