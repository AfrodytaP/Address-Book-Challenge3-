package com.dfcorp.addressbook;

import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactTest {

    @Nested
    @DisplayName("Contact Constructor Tests")
    class ConstructorTests{

        @Test
        @Description("Requirement 1 - Test 1) Tests the contact constructor sets values when valid")
        public void testConstructorSetsValuesWhenValid() {
            // Arrange
            String testFirstName = "Afrodyta";
            String testLastName = "Pudlo";
            String testPhoneNumber = "07878765342";
            String testEmail = "afrodyta@hotmail.com";

            // Act
            Contact testContact = new Contact(testFirstName, testLastName, testPhoneNumber, testEmail);

            // Assert
            assertAll("Constructor sets values when valid",
                    () -> assertEquals(testFirstName, testContact.getFirstName()),
                    () -> assertEquals(testLastName, testContact.getLastName()),
                    () -> assertEquals(testPhoneNumber, testContact.getPhoneNumber()),
                    () -> assertEquals(testEmail, testContact.getEmail()));
        }

    }

}

