package com.dfcorp.addressbook;

import java.util.ArrayList;

public class AddressBook {
    private static int nextID = 1;
    protected int userId;
    private ArrayList<String> contacts = new ArrayList<>();

    public AddressBook(){
        this.userId = nextID++;
        contacts = new ArrayList<>();
    }

    public ArrayList<String>getContacts(){
        return contacts;
    }

    public int getUserId() {
        return userId;
    }



}
