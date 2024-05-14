package com.dfcorp.addressbook;

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

    public static Contact isContactValid(Contact contact) {
        if(contact == null) throw new IllegalArgumentException("Contact cannot be null");
        return contact;
    }



}
