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

    public ArrayList<Contact> searchContactsByName(String firstName, String lastName) {
        if(Validation.isStringNullOrEmpty(firstName) || Validation.isStringNullOrEmpty(lastName)) {
            throw new IllegalArgumentException("First name and last name cannot be null or empty");
        }
        ArrayList<Contact> matchesFound;
        matchesFound = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getFirstName().contains(firstName) && contact.getLastName().contains(lastName)) {
                matchesFound.add(contact);
            }
        }
        return matchesFound;
    }

    public void displayContacts(ArrayList<Contact> contacts) {
        if(Validation.isContactsNull(contacts)) {throw new IllegalArgumentException("Contacts cannot be null");}
        if(Validation.isContactsEmpty(contacts)) {throw new IllegalArgumentException("Contacts cannot be empty");}
        for (Contact contact : contacts) {
            System.out.println("Full Name: " + contact.getFirstName() + " " + contact.getLastName() + " Phone Number: " + contact.getPhoneNumber() + " Email: " + contact.getEmail());
        }
    }

    public void deleteContact(Contact contact) {
        if(Validation.isContactNull(contact)) {throw new IllegalArgumentException("Contact cannot be null");}
        if(Validation.isContactEmpty(contact)) {throw new IllegalArgumentException("Contact cannot be empty");}

    }


}
