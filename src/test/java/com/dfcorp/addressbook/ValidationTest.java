package com.dfcorp.addressbook;

import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidationTest {
    @Nested
    @DisplayName("Validation Tests")
    class ValidationTests{

        @Test
        @Description("Requirement 1 - Test 2) Tests the isStringNullOrEmpty() return true when null input")
        public void testIsStringNullOrEmptyInputIsNotValid() {
            // Arrange
            // Act
            // Assert
            assertTrue(Validation.isStringNullOrEmpty(null));
        }

    }
}
