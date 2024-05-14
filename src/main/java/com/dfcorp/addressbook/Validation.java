package com.dfcorp.addressbook;

public class Validation {

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



}
