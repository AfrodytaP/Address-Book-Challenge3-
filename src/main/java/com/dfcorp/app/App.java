package com.dfcorp.app;

import com.dfcorp.addressbook.AddressBook;
import com.dfcorp.addressbook.Contact;

import java.util.Random;
import java.util.Scanner;

import static com.dfcorp.addressbook.Validation.*;

public class App {
    private static AddressBook addressBook = new AddressBook();

    public static void setAddressBook(AddressBook addressBook) {
        App.addressBook = addressBook;
    }

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
//                case 2:
//                    searchContact();
//                    break;
//                case 3:
//                    editContact();
//                    break;
//                case 4:
//                    deleteContact();
//                    break;
//                case 5:
//                    displayContacts();
//                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose an option from 1 to 6.\n");
            }
        }
    }

    public static void displayMenu() {
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

    public static void addContact() {
        Contact contact;
        Scanner input = new Scanner(System.in);
        System.out.println("Adding a new contact to the address book, please enter the following details:");

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

        try {
            contact = new Contact(firstName, lastName, phoneNumber, email);
            addressBook.addContact(contact);
            System.out.println("Contact added successfully!\n");
        } catch (IllegalArgumentException e) {
            System.out.println("Error " + e.getMessage() + " Please try again.\n");
            addContact();

        }
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