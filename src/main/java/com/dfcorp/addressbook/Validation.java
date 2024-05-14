package com.dfcorp.addressbook;

public class Validation {

    public static boolean isStringNullOrEmpty(String string) {
        if (string == null) {
            return true;
        }
        return false;
    }

}
