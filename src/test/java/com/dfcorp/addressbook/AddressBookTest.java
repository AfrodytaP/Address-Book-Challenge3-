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

        @BeforeEach
        public void setUp() {
            testAddressBook = new AddressBook();
            mockContact = mock(Contact.class);
        }

        @AfterEach
        public void tearDown() {
            testAddressBook = null;
            mockContact = null;
        }

        @Test
        @Description("Requirement 2 - Test 3) Tests the addContact() throw IllegalArgumentException when contact is null")
        public void testAddContactSetsContactToNull() {
            // Arrange
            mockContact = null;
            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () ->{
                testAddressBook.addContact(mockContact);
            });
        }

    }

}
