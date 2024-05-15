package com.dfcorp.addressbook;

import jdk.jfr.Description;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AddressBookTest {
    @Nested
    @DisplayName("Address Constructor Tests")
    class ConstructorTests{

        @Test
        @Description("Requirement 2 - Test 1) Tests the addressBook constructor sets values when valid")
        public void testConstructorSetsValuesWhenValid() {
            // Arrange
            AddressBook testAddressBook = new AddressBook();
            // Act
            // Assert
            assertEquals(testAddressBook.getContacts().size(), 0);
        }

        @Test
        @Description("Requirement 2 - Test 2) Tests the addressBook UserID changes when a new address book is instantiated")
        public void testUserIdIncrementsWhenNewAddressBookIsInstantiated() {
            // Arrange
            AddressBook testAddressBook = new AddressBook();
            AddressBook testAddressBook2 = new AddressBook();
            // Act
            // Assert
            assertEquals(testAddressBook2.getUserId(), 2);
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
            // Act
            testAddressBook.addContact(mockContact);
            // Assert
            assertEquals(0, testAddressBook.getContacts().size());

        }

    }

}
