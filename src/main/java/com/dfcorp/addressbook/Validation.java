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



}
