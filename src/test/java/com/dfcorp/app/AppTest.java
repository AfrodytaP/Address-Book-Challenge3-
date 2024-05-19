package com.dfcorp.app;

import com.dfcorp.addressbook.AddressBook;
import com.dfcorp.addressbook.Contact;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AppTest {
    @Nested
    @DisplayName("addContact Tests")
    class AddContactTests{

        private AddressBook mockAddressBook;
        private final InputStream systemIn = System.in;

        @BeforeEach
        public void setUp() {
            mockAddressBook = mock(AddressBook.class);
        }

        @AfterEach
        public void tearDown() {
            mockAddressBook = null;
        }

        private void provideInput(String data) {
            ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
            System.setIn(testIn);
        }

        @Test
        @Description("Requirement 9 - Test 1) Tests the addressBook app addContact method adds a contact when valid input is provided")
        public void testAddContactAddsContactWhenInputIsValid() {
            // Arrange
            String input = "John\nDoe\n07123456709\njohn@example.com";
            provideInput(input);
            App.setAddressBook(mockAddressBook);
            // Act
            App.addContact();
            // Assert
            verify(mockAddressBook, times(1)).addContact(any(Contact.class));
        }

    }
}