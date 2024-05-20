package com.dfcorp.app;

import com.dfcorp.addressbook.AddressBook;
import com.dfcorp.addressbook.Contact;
import com.dfcorp.addressbook.Validation;

import java.util.ArrayList;
import java.util.Scanner;

import static com.dfcorp.addressbook.Validation.*;

public class App {
    private static final AddressBook addressBook = new AddressBook();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            displayMenu();

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    searchContact();
                    break;
                case 3:
                    editContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    displayContacts();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose an option from 1 to 6.\n");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("Welcome to the Address Book Application!");
        System.out.println("Below is a list of options you can choose from:");
        System.out.println("1) To add a contact");
        System.out.println("2) To search for a contact by name and display the results");
        System.out.println("3) To edit a contact");
        System.out.println("4) To delete a contact");
        System.out.println("5) To display all contacts");
        System.out.println("6) To exit the application");
        System.out.println("Please choose an option from 1 to 6:");
    }

    private static void addContact() {
        Contact contact;
        System.out.println("Adding a new contact to the address book, please enter the following details:");

        try {
            contact = creatContact();
            addressBook.addContact(contact);
            System.out.println("Contact added successfully!\n");
        } catch (IllegalArgumentException e) {
            System.out.println("Error " + e.getMessage() + " Please try again.\n");
            addContact();
        }
    }

    private static void searchContact() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the exact first name of the contact you want to search for:");
        String firstName;
        firstName = nameInput(input);

        System.out.println("Enter the exact last name of the contact you want to search for:");
        String lastName;
        lastName = nameInput(input);


        try {
            ArrayList<Contact> foundContacts;
            foundContacts = addressBook.searchContactsByName(firstName, lastName);
            if (foundContacts.isEmpty()) {
                System.out.println("No contacts found with the name " + firstName + " " + lastName);
                return;
            }
            System.out.println("Contacts found with the name " + firstName + " " + lastName + ":");
            System.out.println(addressBook.displayContacts(foundContacts));
        } catch (IllegalArgumentException e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    private static void editContact() {
        ArrayList<Contact> contacts = addressBook.getContacts();
        System.out.println("Please enter the details of the contact you want to edit:");
        Contact oldContact;
        oldContact = creatContact();

        while (!contacts.contains(oldContact)) {
            System.out.println("Contact does not exist in the address book, please try again.");
            oldContact = creatContact();
        }

        Contact editedContact;
        boolean isPhoneNumberDuplicate;
        boolean isEmailDuplicate;

        do {
            System.out.println("Please enter the new details for the contact:");
            editedContact = creatContact();
            isPhoneNumberDuplicate = Validation.isPhoneNumberDuplicate(contacts, editedContact);
            isEmailDuplicate = Validation.isEmailDuplicate(contacts, editedContact);
            if (isPhoneNumberDuplicate) {
                System.out.println("Phone number already exists, duplicate phone numbers are not allowed. Please try again.");
            }
            if (isEmailDuplicate) {
                System.out.println("Email already exists, duplicate emails are not allowed. Please try again.");
            }
        } while (isPhoneNumberDuplicate || isEmailDuplicate);

        try {
            boolean ifEdited;
            ifEdited = addressBook.editContact(oldContact, editedContact);
            if (ifEdited) {
                System.out.println("Contact edited successfully!\n");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    private static void deleteContact() {
        System.out.println("Please enter the details of the contact you want to delete:");

        Contact deleteContact;
        deleteContact = creatContact();

        try {
            boolean ifDeleted;
            ifDeleted = addressBook.deleteContact(deleteContact);
            if (ifDeleted) {
                System.out.println("Contact deleted successfully!\n");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    private static void displayContacts() {
        try {
            ArrayList<Contact> contacts = addressBook.getContacts();
            if (contacts.isEmpty()) {
                System.out.println("No contacts found in the address book.");
                return;
            }
            System.out.println("All contacts in the address book:");
            System.out.println(addressBook.displayContacts(contacts));
        } catch (IllegalArgumentException e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    private static Contact creatContact() {
        Contact contact;
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the first name, please only use letters:");
        String firstName;
        firstName = nameInput(input);

        System.out.println("Enter the last name, please only use letters:");
        String lastName;
        lastName = nameInput(input);

        System.out.println("Enter a valid UK phone number that starts with 07 and is 11 digits long:");
        String phoneNumber;
        phoneNumber = phoneInput(input);

        System.out.println("Enter the email in this format example@example.com:");
        String email;
        email = emailInput(input);

        contact = new Contact(firstName, lastName, phoneNumber, email);
        return contact;
    }

    private static String nameInput(Scanner input) {
        while (true) {
            String name = input.nextLine().trim();
            try {
                return validateName(name);
            } catch (IllegalArgumentException e) {
                System.out.println("Error " + e.getMessage() + " Please try again.\n");
            }
        }
    }

    private static String phoneInput(Scanner input) {
        while (true) {
            String phone = input.nextLine().trim();
            try {
                return validatePhoneNumber(phone);
            } catch (IllegalArgumentException e) {
                System.out.println("Error " + e.getMessage() + " Please try again.\n");
            }
        }
    }

    private static String emailInput(Scanner input) {
        while (true) {
            String email = input.nextLine().trim();
            try {
                return validateEmail(email);
            } catch (IllegalArgumentException e) {
                System.out.println("Error " + e.getMessage() + " Please try again.\n");
            }
        }
    }
}