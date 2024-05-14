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

    }
}
