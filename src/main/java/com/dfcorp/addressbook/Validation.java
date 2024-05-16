package com.dfcorp.addressbook;

import java.util.ArrayList;

public abstract class Validation {

    public static boolean isStringNullOrEmpty(String string) {
        return string == null || string.trim().isEmpty();
    }

    public static String validateName(String name) {
        if (isStringNullOrEmpty(name)) throw new IllegalArgumentException("Name cannot be null or empty");
        if(!name.matches("^[a-zA-Z]+$")) throw new IllegalArgumentException("Name can only contain letters");
        return name;
    }

    public static String validatePhoneNumber(String phoneNumber) {
        if (isStringNullOrEmpty(phoneNumber)) throw new IllegalArgumentException("Phone number cannot be null or empty");
        if(!phoneNumber.matches("^07\\d{9}$")) throw new IllegalArgumentException("Phone number can only contain numbers and must start with 07 and be 11 digits long");
        return phoneNumber;
    }

    public static String validateEmail(String email) {
        if (isStringNullOrEmpty(email)) throw new IllegalArgumentException("Email cannot be null or empty");
        if(!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) throw new IllegalArgumentException("Email is not valid");
        return email;
    }

    public static boolean isContactNull( Contact contact) {
        try {
            if(contact == null) throw new IllegalArgumentException("Contact cannot be null");
        } catch (IllegalArgumentException e) {
            return true;
        }
        return false;
    }

    public static boolean isContactEmpty(Contact contacts) {
        return contacts.getFirstName() == null && contacts.getLastName() == null && contacts.getPhoneNumber() == null && contacts.getEmail() == null;
    }

    public static boolean isContactsNull( ArrayList<Contact> contacts) {
        if(contacts == null) return true;
        for (Contact contact : contacts) {
            try {
                if (contact == null) {
                    return true;
                }
            }catch (NullPointerException e) {
                return true;
            }
        }
        return false;
    }

    public static boolean isContactsEmpty( ArrayList<Contact> contacts) {
        for (Contact contact : contacts) {
            if (!(contact.getFirstName() == null && contact.getLastName() == null && contact.getPhoneNumber() == null && contact.getEmail() == null))
                return false;
        }
         return true;
    }

    public static boolean isPhoneNumberDuplicate(ArrayList<Contact> contacts, Contact contact) {
        try {
            for(Contact phoneNumber : contacts){
            if(phoneNumber.getPhoneNumber().equals(contact.getPhoneNumber())) throw new IllegalArgumentException("Phone number already exists, duplicate phone numbers are not allowed");
            }
        } catch (IllegalArgumentException e) {
            return true;
        }
        return false;
    }

    public static boolean isEmailDuplicate(ArrayList<Contact> contacts, Contact contact) {
        try {
            for(Contact email : contacts){
                if(email.getEmail().equals(contact.getEmail())) throw new IllegalArgumentException("Email already exists, duplicate emails are not allowed");
            }
        } catch (IllegalArgumentException e) {
            return true;
        }
        return false;
    }



}
