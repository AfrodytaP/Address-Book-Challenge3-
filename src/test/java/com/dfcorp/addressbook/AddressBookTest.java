package com.dfcorp.addressbook;

import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

}
