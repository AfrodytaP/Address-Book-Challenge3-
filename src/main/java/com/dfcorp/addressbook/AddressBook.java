package com.dfcorp.addressbook;

import java.util.ArrayList;

public class AddressBook {
    private ArrayList<String> contacts = new ArrayList<>();

    public AddressBook(){
        contacts = new ArrayList<>();
    }

    public ArrayList<String>getContacts(){
        return contacts;
    }



}
