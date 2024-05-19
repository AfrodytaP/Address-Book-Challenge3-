package com.dfcorp.addressbook;

import jdk.jfr.Description;
import org.junit.jupiter.api.*;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AddressBookTest {
    @Nested
    @DisplayName("Address Constructor Tests")
    class ConstructorTests{
        private AddressBook testAddressBook;

        @BeforeEach
        public void setUp() {
            testAddressBook = new AddressBook();
        }

        @AfterEach
        public void tearDown() {
            testAddressBook = null;
        }

        @Test
        @Description("Requirement 2 - Test 1) Tests the addressBook constructor sets values when valid")
        public void testConstructorSetsValuesWhenValid() {
            // Arrange
            // Act
            // Assert
            assertEquals(testAddressBook.getContacts().size(), 0);
        }

    }

    @Nested
    @DisplayName("AddContact Tests")
    class AddContactTests{
        private AddressBook testAddressBook;
        private Contact mockContact;
        private Contact mockContact2;

        @BeforeEach
        public void setUp() {
            testAddressBook = new AddressBook();
            mockContact = mock(Contact.class);
            mockContact2 = mock(Contact.class);
            when(mockContact2.getFirstName()).thenReturn("Afrodyta");
            when(mockContact2.getLastName()).thenReturn("Pudlo");
            when(mockContact2.getPhoneNumber()).thenReturn("07878765342");
            when(mockContact2.getEmail()).thenReturn("afrodyta@hotmail.com");
        }

        @AfterEach
        public void tearDown() {
            testAddressBook = null;
            mockContact = null;
        }

        @Test
        @Description("Requirement 2 - Test 4) Tests the addContact() contacts length increase by 1 when contact is added")
        public void testAddContactContactsArrayLengthIncreaseByOneWithValidContact() {
            // Arrange
            // Act
            testAddressBook.addContact(mockContact2);
            // Assert
            assertEquals(1, testAddressBook.getContacts().size());

        }

        @Test
        @Description("Requirement 2 - Test 5) Tests the addContact() adds given contact object to the Contacts array")
        public void testAddContactAddsGivenObjectToContacts() {
            // Arrange
            // Act
            testAddressBook.addContact(mockContact2);
            // Assert
            assertEquals(mockContact2, testAddressBook.getContacts().get(0));
        }

        @Test
        @Description("Requirement 2 - Test 6) Tests the addContact() does not add contact to Contacts array when contact is null")
        public void testAddContactDoesNotAddContactToContactsWhenNull() {
            // Arrange
            mockContact = null;
            String expectedMessage = "Contact cannot be null";
            // Act
            // Assert
            assertEquals(expectedMessage, assertThrows(IllegalArgumentException.class, () -> testAddressBook.addContact(mockContact)).getMessage());
        }

        @Test
        @Description("Requirement 3 - Test 1) Tests the addContact() dose not add given duplicate contact.getPhoneNumber object to the Contacts array")
        public void testAddContactThrowErrorWhenGivenDuplicatePhoneNumberObject() {
            // Arrange
            String expectedMessage = "Phone number already exists, duplicate phone numbers are not allowed";
            // Act
            testAddressBook.addContact(mockContact);
            when(mockContact.getPhoneNumber()).thenReturn("07878765342");
            when(mockContact2.getPhoneNumber()).thenReturn("07878765342");
            // Assert
            assertEquals(expectedMessage, assertThrows(IllegalArgumentException.class, () -> testAddressBook.addContact(mockContact2)).getMessage());
        }

        @Test
        @Description("Requirement 4 - Test 1) Tests the addContact() does not add given duplicate contact.getEmail object to the Contacts array")
        public void testAddContactThrowErrorWhenGivenDuplicateEmailObject() {
            // Arrange
            String expectedMessage = "Email already exists, duplicate emails are not allowed";
            // Act
            String email = "afrodyta@hotmail.com";
            when(mockContact.getEmail()).thenReturn(email);
            when(mockContact2.getEmail()).thenReturn(email);
            when(mockContact.getPhoneNumber()).thenReturn("07474788831");
            when(mockContact2.getPhoneNumber()).thenReturn("07356622252");
            when(mockContact2.getPhoneNumber()).thenReturn(email);
            testAddressBook.addContact(mockContact);

            // Assert
            assertEquals(expectedMessage, assertThrows(IllegalArgumentException.class, () -> testAddressBook.addContact(mockContact2)).getMessage());
        }

    }

    @Nested
    @DisplayName("searchContactsByName Tests")
    class SearchContactsByName {
        private AddressBook testAddressBook;
        private Contact mockContact;
        private Contact mockContact2;
        private Contact mockContact3;
        private Contact mockContact4;

        @BeforeEach
        public void setUp() {
            testAddressBook = new AddressBook();
            mockContact = mock(Contact.class);
            mockContact2 = mock(Contact.class);
            mockContact3 = mock(Contact.class);
            mockContact4 = mock(Contact.class);

            when(mockContact.getFirstName()).thenReturn("Afrodyta");
            when(mockContact.getLastName()).thenReturn("Pudlo");
            when(mockContact.getPhoneNumber()).thenReturn("07878765342");
            when(mockContact.getEmail()).thenReturn("afrodyta@hotmail.com");

            when(mockContact2.getFirstName()).thenReturn("Afrodyta");
            when(mockContact2.getLastName()).thenReturn("Smith");
            when(mockContact2.getPhoneNumber()).thenReturn("07878765343");
            when(mockContact2.getEmail()).thenReturn("afrodytaSmith@hotmail.com");

            when(mockContact3.getFirstName()).thenReturn("Tom");
            when(mockContact3.getLastName()).thenReturn("Smith");
            when(mockContact3.getPhoneNumber()).thenReturn("07878765344");
            when(mockContact3.getEmail()).thenReturn("tom@hotmail.com");

            when(mockContact4.getFirstName()).thenReturn("Afrodyta");
            when(mockContact4.getLastName()).thenReturn("Pudlo");
            when(mockContact4.getPhoneNumber()).thenReturn("07878765345");
            when(mockContact4.getEmail()).thenReturn("afrodytaP@hotmail.com");
            testAddressBook.addContact(mockContact);
            testAddressBook.addContact(mockContact2);
            testAddressBook.addContact(mockContact3);
            testAddressBook.addContact(mockContact4);

        }

        @AfterEach
        public void tearDown() {
            testAddressBook = null;
            mockContact = null;
            mockContact2 = null;
            mockContact3 = null;
            mockContact4 = null;
        }

        @Test
        @Description("Requirement 5 - Test 1) Tests the searchContactsByName() returns a list of contacts with matching first and last names")
        public void testSearchContactsByNameReturnsListOfContactsMatchingFirstAndLastNames() {
            // Arrange
            List<Contact> matches = testAddressBook.searchContactsByName("Afrodyta", "Pudlo");
            // Act
            // Assert
            assertEquals(2, matches.size());
        }

        @Test
        @Description("Requirement 5 - Test 2) Tests the searchContactsByName() returns O list size of matched contacts with first and last names")
        public void testSearchContactsByNameReturnsListOfSizeZeroWhenNoMatches() {
            // Arrange
            List<Contact> matches = testAddressBook.searchContactsByName("David", "P");
            // Act
            // Assert
            assertEquals(0, matches.size());
        }

        @Test
        @Description("Requirement 5 - Test 3) Tests the searchContactsByName() returns a list of contacts with matching first and last names")
        public void testSearchContactsByNameReturnsListOfContactsAPartialMatchOfFirstAndLastNames2() {
            // Arrange
            List<Contact> matches = testAddressBook.searchContactsByName("Afrod", "Pud");
            // Act
            // Assert
            assertEquals(2, matches.size());
        }

        @Test
        @Description("Requirement 5 - Test 4) Tests the searchContactsByName() throws an exception when first name is null")
        public void testSearchContactsByNameThrowsExceptionWhenFirstNameIsNull() {
            // Arrange
            String expectedMessage = "First name and last name cannot be null or empty";
            //Act
            // Assert
            assertEquals(expectedMessage, assertThrows(IllegalArgumentException.class, () -> testAddressBook.searchContactsByName(null, "Pudlo")).getMessage());
        }

        @Test
        @Description("Requirement 5 - Test 5) Tests the searchContactsByName() throws an exception when last name is empty")
        public void testSearchContactsByNameThrowsExceptionWhenLastNameIsEmpty() {
            // Arrange
            String expectedMessage = "First name and last name cannot be null or empty";
            //Act
            // Assert
            assertEquals(expectedMessage, assertThrows(IllegalArgumentException.class, () -> testAddressBook.searchContactsByName("Afrodyta", "")).getMessage());
        }
    }

    @Nested
    class DisplayContacts {
        private AddressBook testAddressBook;
        private AddressBook testAddressBook2;
        private Contact mockContact;
        private Contact mockContact2;
        private Contact mockContact3;
        private Contact mockContact4;
        private PrintStream mockPrintStream;

        @BeforeEach
        public void setUp() {
            testAddressBook = new AddressBook();
            testAddressBook2 = new AddressBook();
            mockContact = mock(Contact.class);
            mockContact2 = mock(Contact.class);
            mockContact3 = mock(Contact.class);
            mockContact4 = mock(Contact.class);
            mockPrintStream = mock(PrintStream.class);
            System.setOut(mockPrintStream);

            when(mockContact.getFirstName()).thenReturn("Afrodyta");
            when(mockContact.getLastName()).thenReturn("Pudlo");
            when(mockContact.getPhoneNumber()).thenReturn("07878765342");
            when(mockContact.getEmail()).thenReturn("afrodyta@hotmail.com");

            when(mockContact2.getFirstName()).thenReturn("Afrodyta");
            when(mockContact2.getLastName()).thenReturn("Smith");
            when(mockContact2.getPhoneNumber()).thenReturn("07878765343");
            when(mockContact2.getEmail()).thenReturn("afrodytaSmith@hotmail.com");

            when(mockContact3.getFirstName()).thenReturn("Tom");
            when(mockContact3.getLastName()).thenReturn("Smith");
            when(mockContact3.getPhoneNumber()).thenReturn("07878765344");
            when(mockContact3.getEmail()).thenReturn("tom@hotmail.com");

            when(mockContact4.getFirstName()).thenReturn("Afrodyta");
            when(mockContact4.getLastName()).thenReturn("Pudlo");
            when(mockContact4.getPhoneNumber()).thenReturn("07878765345");
            when(mockContact4.getEmail()).thenReturn("afrodytaP@hotmail.com");
            testAddressBook.addContact(mockContact);
            testAddressBook.addContact(mockContact2);
            testAddressBook.addContact(mockContact3);
            testAddressBook.addContact(mockContact4);

        }

        @AfterEach
        public void tearDown() {
            testAddressBook = null;
            testAddressBook2 = null;
            mockContact = null;
            mockContact2 = null;
            mockContact3 = null;
            mockContact4 = null;
            mockPrintStream = null;
            System.setOut(System.out);
        }

        @Test
        @Description("Requirement 6 - Test 5) Tests the displayContacts() prints out given contacts in the address book")
        public void testDisplayContactsPrintsOutGivenContactsInTheAddressBook() {
            // Arrange
            ArrayList<Contact> contacts = testAddressBook.getContacts();
            // Act
            testAddressBook.displayContacts(contacts);
            // Assert
            verify(mockPrintStream, times(1)).println("Full Name: Afrodyta Pudlo Phone Number: 07878765342 Email: afrodyta@hotmail.com");
            verify(mockPrintStream, times(1)).println("Full Name: Afrodyta Smith Phone Number: 07878765343 Email: afrodytaSmith@hotmail.com");
            verify(mockPrintStream, times(1)).println("Full Name: Tom Smith Phone Number: 07878765344 Email: tom@hotmail.com");
            verify(mockPrintStream, times(1)).println("Full Name: Afrodyta Pudlo Phone Number: 07878765345 Email: afrodytaP@hotmail.com");

        }

        @Test
        @Description("Requirement 6 - Test 6) Tests the displayContacts() throws an exception when contacts are null")
        public void testDisplayContactsThrowsExceptionWhenContactsAreNull() {
            // Arrange
            String expectedMessage = "Contacts cannot be null";
            // Act
            // Assert
            assertEquals(expectedMessage, assertThrows(IllegalArgumentException.class, () -> testAddressBook.displayContacts(null)).getMessage());
        }

        @Test
        @Description("Requirement 6 - Test 7) Tests the displayContacts() throws an exception when contacts are empty")
        public void testDisplayContactsThrowsExceptionWhenContactsAreEmpty() {
            // Arrange
            String expectedMessage = "Contacts cannot be empty";
            // Act
            // Assert
            assertEquals(expectedMessage, assertThrows(IllegalArgumentException.class, () -> testAddressBook.displayContacts(testAddressBook2.getContacts())).getMessage());
        }

        @Test
        @Description("Requirement 6 - Test 8) Tests the displayContacts() prints out contacts from searchContactsByName()")
        public void testDisplayContactsPrintsOutContactsFromSearchContactsByName() {
            // Arrange
            ArrayList<Contact> contacts = testAddressBook.searchContactsByName("Afrodyta", "Pudlo");
            // Act
            testAddressBook.displayContacts(contacts);
            // Assert
            verify(mockPrintStream, times(1)).println("Full Name: Afrodyta Pudlo Phone Number: 07878765342 Email: afrodyta@hotmail.com");
            verify(mockPrintStream, times(1)).println("Full Name: Afrodyta Pudlo Phone Number: 07878765345 Email: afrodytaP@hotmail.com");

        }
    }

    @Nested
    class DeleteContact {
        private AddressBook testAddressBook;
        private Contact mockContact;
        private Contact mockContact5;

        @BeforeEach
        public void setUp() {
            testAddressBook = new AddressBook();
            mockContact = mock(Contact.class);
            mockContact5 = mock(Contact.class);

            when(mockContact.getFirstName()).thenReturn("Afrodyta");
            when(mockContact.getLastName()).thenReturn("Pudlo");
            when(mockContact.getPhoneNumber()).thenReturn("07878765342");
            when(mockContact.getEmail()).thenReturn("afrodyta@hotmail.com");

            when(mockContact5.getFirstName()).thenReturn(null);
            when(mockContact5.getLastName()).thenReturn(null);
            when(mockContact5.getPhoneNumber()).thenReturn(null);
            when(mockContact5.getEmail()).thenReturn(null);

            testAddressBook.addContact(mockContact);

        }

        @AfterEach
        public void tearDown() {
            testAddressBook = null;
            mockContact = null;
            mockContact5 = null;
        }

        @Test
        @Description("Requirement 7 - Test 1) Tests the deletesContact() throws an exception when contact are null")
        public void testDeleteContactThrowsExceptionWhenContactAreNull() {
            // Arrange
            String expectedMessage = "Contact cannot be null";
            // Act
            // Assert
            assertEquals(expectedMessage, assertThrows(IllegalArgumentException.class, () -> testAddressBook.deleteContact(null)).getMessage());

        }

        @Test
        @Description("Requirement 7 - Test 4) Tests the deletesContact() throws an exception when contact are empty")
        public void testDeleteContactThrowsExceptionWhenContactAreEmpty() {
            // Arrange
            String expectedMessage = "Contact cannot be empty";
            // Act
            // Assert
            assertEquals(expectedMessage, assertThrows(IllegalArgumentException.class, () -> testAddressBook.deleteContact(mockContact5)).getMessage());

        }

        @Test
        @Description("Requirement 7 - Test 5) Tests the deletesContact() throws an exception when contact is not in the address book")
        public void testDeleteContactThrowsExceptionWhenContactIsNotInTheAddressBook() {
            // Arrange
            when(mockContact5.getFirstName()).thenReturn("Alex");
            when(mockContact5.getLastName()).thenReturn("Hill");
            when(mockContact5.getPhoneNumber()).thenReturn("07878765443");
            when(mockContact5.getEmail()).thenReturn("alex@outlook.com");
            // Act
            // Assert
            assertEquals("Contact does not exist in the address book please try again", assertThrows(IllegalArgumentException.class, () -> testAddressBook.deleteContact(mockContact5)).getMessage());

        }

        @Test
        @Description("Requirement 7 - Test 6) Tests the deletesContact() removes contact from the address book when contact is in the address book")
        public void testDeleteContactRemovesContactFromTheAddressBookWhenContactIsInTheAddressBook() {
            // Arrange
            // Act
            testAddressBook.deleteContact(mockContact);
            // Assert
            assertEquals(0, testAddressBook.getContacts().size());
        }

        @Test
        @Description("Requirement 7 - Test 7) Tests the deletesContact() returns true when contact is deleted")
        public void testDeleteContactReturnsTrueWhenContactIsDeleted() {
            // Arrange
            // Act
            // Assert
            assertTrue(testAddressBook.deleteContact(mockContact));
        }
    }

    @Nested
    class EditContact {
        private AddressBook testAddressBook;
        private Contact mockContact;
        private Contact mockContact2;
        private Contact mockContact5;

        @BeforeEach
        public void setUp() {
            testAddressBook = new AddressBook();
            mockContact = mock(Contact.class);
            mockContact2 = mock(Contact.class);
            mockContact5 = mock(Contact.class);

            when(mockContact.getFirstName()).thenReturn("Afrodyta");
            when(mockContact.getLastName()).thenReturn("Pudlo");
            when(mockContact.getPhoneNumber()).thenReturn("07878765342");
            when(mockContact.getEmail()).thenReturn("afrodyta@hotmail.com");

            when(mockContact2.getFirstName()).thenReturn("Ann");
            when(mockContact2.getLastName()).thenReturn("Thompson");
            when(mockContact2.getPhoneNumber()).thenReturn("07878765399");
            when(mockContact2.getEmail()).thenReturn("ann@hotmail.com");

            when(mockContact5.getFirstName()).thenReturn(null);
            when(mockContact5.getLastName()).thenReturn(null);
            when(mockContact5.getPhoneNumber()).thenReturn(null);
            when(mockContact5.getEmail()).thenReturn(null);

            testAddressBook.addContact(mockContact);

        }

        @AfterEach
        public void tearDown() {
            testAddressBook = null;
            mockContact = null;
            mockContact5 = null;
        }

        @Test
        @Description("Requirement 8 - Test 1) Tests the editContact() throws an exception when contact is null")
        public void testEditContactThrowsExceptionWhenContactIsNull() {
            // Arrange
            String expectedMessage = "Contact cannot be null";
            // Act
            // Assert
            assertEquals(expectedMessage, assertThrows(IllegalArgumentException.class, () -> testAddressBook.editContact(null,null)).getMessage());
        }

        @Test
        @Description("Requirement 8 - Test 2) Tests the editContact() throws an exception when contact is empty")
        public void testEditContactThrowsExceptionWhenContactIsEmpty() {
            // Arrange
            String expectedMessage = "Contact cannot be empty";
            // Act
            // Assert
            assertEquals(expectedMessage, assertThrows(IllegalArgumentException.class, () -> testAddressBook.editContact(mockContact, mockContact5)).getMessage());
        }

        @Test
        @Description("Requirement 8 - Test 3) Tests the editContact() throws an exception when contact is not in the address book")
        public void testEditContactThrowsExceptionWhenContactIsNotInTheAddressBook() {
            // Arrange
            String expectedMessage = "Contact does not exist in the address book please try again";
            // Act
            // Assert
            assertEquals(expectedMessage, assertThrows(IllegalArgumentException.class, () -> testAddressBook.editContact(mockContact2, mockContact)).getMessage());

        }

        @Test
        @Description("Requirement 8 - Test 4) Tests the editContact() if input is valid contact is edited and returns true")
        public void testEditContactReturnsTrueWhenContactIsEdited() {
            // Arrange
            // Act
            // Assert
            assertTrue(testAddressBook.editContact(mockContact, mockContact2));
        }

        @Test
        @Description("Requirement 8 - Test 5) Tests the editContact() checks if contact is replaced with newContact")
        public void testEditContactReplacesContactWithNewContact() {
            // Arrange
            String oldContactFirstName = testAddressBook.getContacts().get(0).getFirstName();
            // Act
            testAddressBook.editContact(mockContact, mockContact2);
            String replacedContactFirstName = testAddressBook.getContacts().get(0).getFirstName();
            // Assert
            assertNotEquals(oldContactFirstName, replacedContactFirstName);
        }
    }

}
