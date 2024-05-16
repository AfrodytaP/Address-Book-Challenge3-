package com.dfcorp.addressbook;

import jdk.jfr.Description;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ValidationTest {
    @Nested
    @DisplayName("Validation Tests")
    class ValidationTests {

        @Test
        @Description("Requirement 1 - Test 2) Tests the isStringNullOrEmpty() return true when null input")
        public void testIsStringNullOrEmptyInputIsNotValid() {
            // Arrange
            // Act
            // Assert
            assertTrue(Validation.isStringNullOrEmpty(null));
        }

        @Test
        @Description("Requirement 1 - Test 3) Tests the isStringNullOrEmpty() return true when input is empty")
        public void testIsStringNullOrEmptyInputIsEmpty() {
            // Arrange
            String testString = "";
            // Act
            // Assert
            assertTrue(Validation.isStringNullOrEmpty(testString));
        }

        @Test
        @Description("Requirement 1 - Test 4) Tests the isStringNullOrEmpty() return false when input is valid")
        public void testIsStringNullOrEmptyInputIsValid() {
            // Arrange
            String testString = "Afrodyta";
            // Act
            // Assert
            assertFalse(Validation.isStringNullOrEmpty(testString));
        }

        @Test
        @Description("Requirement 1 - Test 5) Tests the validateName() throws Exception when input is not valid")
        public void testValidateNameWhenInputIsNotValid() {
            // Arrange
            String testString = "";
            // Act
            // Assert
            assertThrows(IllegalArgumentException.class, () -> Validation.validateName(testString));
        }

        @Test
        @Description("Requirement 1 - Test 6) Tests the validateName() returns Exception message when input is not valid")
        public void testValidateNameReturnsMessageWhenInputIsNotValid() {
            // Arrange
            String testString = "";
            String expectedMessage = "Name cannot be null or empty";
            // Act
            // Assert
            assertEquals(expectedMessage, assertThrows(IllegalArgumentException.class, () -> Validation.validateName(testString)).getMessage());
        }

        @Test
        @Description("Requirement 1 - Test 7) Tests the validateName() returns Exception message when input is not valid")
        public void testValidateNameReturnsMessageWhenInputHasNonLetters() {
            // Arrange
            String testString = "afrodyta1!";
            String expectedMessage = "Name can only contain letters";
            // Act
            // Assert
            assertEquals(expectedMessage, assertThrows(IllegalArgumentException.class, () -> Validation.validateName(testString)).getMessage());
        }

        @Test
        @Description("Requirement 1 - Test 8) Tests the validateName() returns name when input is valid")
        public void testValidateNameReturnsNameWhenInputIsValid() {
            // Arrange
            String testString = "afrodyta";
            String expectedMessage = "afrodyta";
            // Act
            // Assert
            assertEquals(expectedMessage, Validation.validateName(testString));
        }

        @Test
        @Description("Requirement 1 - Test 9) Tests the validatePhoneNumber() returns Exception message when input is not valid")
        public void testValidatePhoneNumberReturnsMessageWhenInputIsNotValid() {
            // Arrange
            String testString = "";
            String expectedMessage = "Phone number cannot be null or empty";
            // Act
            // Assert
            assertEquals(expectedMessage, assertThrows(IllegalArgumentException.class, () -> Validation.validatePhoneNumber(testString)).getMessage());
        }

        @Test
        @Description("Requirement 1 - Test 10) Tests the validatePhoneNumber() returns Exception message when input is not valid")
        public void testValidatePhoneNumberReturnsMessageWhenInputHasNonNumbers() {
            // Arrange
            String testString = "07e23322222!";
            String expectedMessage = "Phone number can only contain numbers and must start with 07 and be 11 digits long";
            // Act
            // Assert
            assertEquals(expectedMessage, assertThrows(IllegalArgumentException.class, () -> Validation.validatePhoneNumber(testString)).getMessage());
        }

        @Test
        @Description("Requirement 1 - Test 11) Tests the validatePhoneNumber() returns phoneNumber String when input is valid")
        public void testValidatePhoneNumberReturnsPhoneNumberWhenInputIsValid() {
            // Arrange
            String testString = "07233222223";
            String expectedMessage = "07233222223";
            // Act
            // Assert
            assertEquals(expectedMessage, Validation.validatePhoneNumber(testString));
        }

        @Test
        @Description("Requirement 1 - Test 12) Tests the validateEmail() returns Exception message when input is not valid")
        public void testValidateEmailReturnsMessageWhenInputIsNotValid() {
            // Arrange
            String testString = "";
            String expectedMessage = "Email cannot be null or empty";
            // Act
            // Assert
            assertEquals(expectedMessage, assertThrows(IllegalArgumentException.class, () -> Validation.validateEmail(testString)).getMessage());
        }

        @Test
        @Description("Requirement 1 - Test 13) Tests the validateEmail() returns Exception message when input is not valid")
        public void testValidateEmailReturnsMessageWhenEmailInputIsNotValid() {
            // Arrange
            String testString = "afrodyta.com";
            String expectedMessage = "Email is not valid";
            // Act
            // Assert
            assertEquals(expectedMessage, assertThrows(IllegalArgumentException.class, () -> Validation.validateEmail(testString)).getMessage());
        }

        @Test
        @Description("Requirement 1 - Test 14) Tests the validateEmail() returns email when input is valid")
        public void testValidateEmailReturnsEmailWhenEmailInputIsValid() {
            // Arrange
            String testString = "afrodyta@outlook.com";
            String expectedMessage = "afrodyta@outlook.com";
            // Act
            // Assert
            assertEquals(expectedMessage, Validation.validateEmail(testString));
        }

        @Test
        @Description("Requirement 2 - Test 3) Tests the addContact() throw IllegalArgumentException when contact is null")
        public void testAddContactSetsContactToNull() {
            // Arrange
            // Act
            // Assert
            assertTrue(Validation.isContactNull(null));
        }
    }

    @Nested
    @DisplayName("isContactsNull and isContactsEmptyTests")
    class IsContactsNullIsContactsEmptyTests {

        private AddressBook mockAddressBook;
        private AddressBook mockAddressBook2;
        private Contact mockContact;
        private Contact mockContact2;

        @BeforeEach
        public void setUp() {
            mockAddressBook = mock(AddressBook.class);
            mockAddressBook2 = mock(AddressBook.class);
            mockContact = mock(Contact.class);
            mockContact2 = mock(Contact.class);

            when(mockContact.getFirstName()).thenReturn("Afrodyta");
            when(mockContact.getLastName()).thenReturn("Pudlo");
            when(mockContact.getPhoneNumber()).thenReturn("07878765342");
            when(mockContact.getEmail()).thenReturn("afrodyta@hotmail.com");

            when(mockContact2.getFirstName()).thenReturn("Afrodyta");
            when(mockContact2.getLastName()).thenReturn("Smith");
            when(mockContact2.getPhoneNumber()).thenReturn("07878765343");
            when(mockContact2.getEmail()).thenReturn("afrodytaSmith@hotmail.com");

            mockAddressBook.addContact(mockContact);
            mockAddressBook.addContact(mockContact2);

        }

        @AfterEach
        public void tearDown() {
            mockAddressBook = null;
            mockAddressBook2 = null;
            mockContact = null;
            mockContact2 = null;
        }

        @Test
        @Description("Requirement 6 - Test 1) Tests the isContactsNull() return true and throws IllegalArgumentException when contacts is null")
        public void testIsContactsNullReturnsTrueAndIllegalArgumentExceptionWhenContactsIsNull() {
            // Arrange
            // Act
            // Assert
            assertTrue(Validation.isContactNull(null));
        }

        @Test
        @Description("Requirement 6 - Test 2) Tests the isContactsNull() return false when contacts are Valid")
        public void testIsContactsNullReturnsFalseWhenContactsAreValid() {
            // Arrange
            ArrayList<Contact> contacts = ( mockAddressBook.getContacts());
            // Act
            // Assert
            assertFalse(Validation.isContactsNull(contacts));
        }

        @Test
        @Description("Requirement 6 - Test 3) Tests the isContactsEmpty() return true when contacts are empty")
        public void testIsContactsEmptyReturnsTrueWhenContactsAreEmpty() {
            // Arrange
            ArrayList<Contact> contacts = ( mockAddressBook2.getContacts());
            // Act
            // Assert
            assertTrue(Validation.isContactsEmpty(contacts));
        }

        @Test
        @Description("Requirement 6 - Test 4) Tests the isContactsEmpty() return false when contacts are not empty")
            public void testIsContactsEmptyReturnsFalseWhenContactsAreNotEmpty() {
            // Arrange
            ArrayList<Contact> contacts = ( mockAddressBook.getContacts());
            // Act
            // Assert
            assertTrue(Validation.isContactsEmpty(contacts));
        }
    }

    @Nested
    @DisplayName("sContactEmptyTests")
    class IsContactEmptyTests {

        private Contact mockContact;
        private Contact mockContact2;

        @BeforeEach
        public void setUp() {
            mockContact = mock(Contact.class);
            mockContact2 = mock(Contact.class);

            when(mockContact.getFirstName()).thenReturn("Afrodyta");
            when(mockContact.getLastName()).thenReturn("Pudlo");
            when(mockContact.getPhoneNumber()).thenReturn("07878765342");
            when(mockContact.getEmail()).thenReturn("afrodyta@hotmail.com");

            when(mockContact2.getFirstName()).thenReturn(null);
            when(mockContact2.getLastName()).thenReturn(null);
            when(mockContact2.getPhoneNumber()).thenReturn(null);
            when(mockContact2.getEmail()).thenReturn(null);
        }

        @AfterEach
        public void tearDown() {
            mockContact = null;
            mockContact2 = null;
        }

        @Test
        @Description("Requirement 7 - Test 2) Tests the isContactEmpty() return true when contact is empty")
        public void testIsContactEmptyReturnsTrueWhenContactIsEmpty() {
            // Arrange
            // Act
            // Assert
            assertTrue(Validation.isContactEmpty(mockContact2));
        }

        @Test
            @Description("Requirement 7 - Test 3) Tests the isContactEmpty() return false when contact is not empty")
        public void testIsContactEmptyReturnsFalseWhenContactIsNotEmpty() {
            // Arrange
            // Act
            // Assert
            assertFalse(Validation.isContactEmpty(mockContact));
        }
    }

}
