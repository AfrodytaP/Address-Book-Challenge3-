package com.dfcorp.addressbook;

import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
            assertEquals(expectedMessage,Validation.validatePhoneNumber(testString));
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

}
