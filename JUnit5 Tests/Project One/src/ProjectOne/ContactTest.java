package ProjectOne;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactTest {
  protected String contactId, firstNameTest, lastNameTest, phoneNumberTest,
      addressTest;
  protected String longContactId, longFirstName, longLastName,
      longPhoneNumber, invalidPhoneNumber, longAddress;

  @BeforeEach
  void testInfo() {
    contactId = "123456789";
    firstNameTest = "John";
    lastNameTest = "Doe";
    phoneNumberTest = "1234567890";
    addressTest = "123 Test Street";
    longContactId = "1234567890000001";
    longFirstName = "VeryVeryVeryLongFirstName";
    longLastName = "VeryVeryVeryLongLastName";
    longPhoneNumber = "12345678900001";
    invalidPhoneNumber = "1234567";
    longAddress = "You are seeing this because the address is too long";
  }

  @Test
  void contactTest() {
    Contact contact = new Contact();
    assertAll("Constructor Test",
              () -> assertNotNull(contact.getContactId()),
              () -> assertNotNull(contact.getFirstName()),
              () -> assertNotNull(contact.getLastName()),
              () -> assertNotNull(contact.getPhoneNumber()),
              () -> assertNotNull(contact.getAddress()));
  }

  @Test
  void contactIdConstructorTest() {
    Contact contact = new Contact(contactId);
    assertAll("Test one",
              () -> assertEquals(contactId, contact.getContactId()),
              () -> assertNotNull(contact.getFirstName()),
              () -> assertNotNull(contact.getLastName()),
              () -> assertNotNull(contact.getPhoneNumber()),
              () -> assertNotNull(contact.getAddress()));
  }

  @Test
  void contactIdAndFirstNameConstructorTest() {
    Contact contact = new Contact(contactId, firstNameTest);
    assertAll("Test Two",
              () -> assertEquals(contactId, contact.getContactId()),
              () -> assertEquals(firstNameTest, contact.getFirstName()),
              () -> assertNotNull(contact.getLastName()),
              () -> assertNotNull(contact.getPhoneNumber()),
              () -> assertNotNull(contact.getAddress()));
  }

  @Test
  void contactIdAndFullNameConstructorTest() {
    Contact contact = new Contact(contactId, firstNameTest, lastNameTest);
    assertAll("Test Three",
              () -> assertEquals(contactId, contact.getContactId()),
              () -> assertEquals(firstNameTest, contact.getFirstName()),
              () -> assertEquals(lastNameTest, contact.getLastName()),
              () -> assertNotNull(contact.getPhoneNumber()),
              () -> assertNotNull(contact.getAddress()));
  }

  @Test
  void contactIdFullNamePhoneNumberConstructorTest() {
    Contact contact =
        new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest);
    assertAll("Test Four",
              ( )-> assertEquals(contactId, contact.getContactId()),
              () -> assertEquals(firstNameTest, contact.getFirstName()),
              () -> assertEquals(lastNameTest, contact.getLastName()),
              () -> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
              () -> assertNotNull(contact.getAddress()));
  }

  @Test
  void fullConstructorTest() {
    Contact contact = new Contact(contactId, firstNameTest, lastNameTest,phoneNumberTest, addressTest);
    assertAll("Test Five",
              () -> assertEquals(contactId, contact.getContactId()),
              () -> assertEquals(firstNameTest, contact.getFirstName()),
              () -> assertEquals(lastNameTest, contact.getLastName()),
              () -> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
              () -> assertEquals(addressTest, contact.getAddress()));
  }

  @Test
  void updateFirstNameTest() {
    Contact contact = new Contact();
    contact.updateFirstName(firstNameTest);
    assertAll("First Name",
        () -> assertEquals(firstNameTest, contact.getFirstName()),
        () -> assertThrows(IllegalArgumentException.class,
        () -> contact.updateFirstName(null)),
        () -> assertThrows(IllegalArgumentException.class,
        () -> contact.updateFirstName(longFirstName)));
  }

  @Test
  void updateLastNameTest() {
    Contact contact = new Contact();
    contact.updateLastName(lastNameTest);
    assertAll(
        "Last Name",
        () -> assertEquals(lastNameTest, contact.getLastName()),
        () -> assertThrows(IllegalArgumentException.class,
        () -> contact.updateLastName(null)),
        () -> assertThrows(IllegalArgumentException.class,
        () -> contact.updateLastName(longFirstName)));
  }

  @Test
  void updatePhoneNumberTest() {
    Contact contact = new Contact();
    contact.updatePhoneNumber(phoneNumberTest);
    assertAll("Phone Number Test One",
              () -> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
              () -> assertThrows(IllegalArgumentException.class,
              () -> contact.updatePhoneNumber(null)),
              () -> assertThrows(IllegalArgumentException.class,
              () -> contact.updatePhoneNumber(longPhoneNumber)),
              () -> assertThrows(IllegalArgumentException.class,
              () -> contact.updatePhoneNumber(invalidPhoneNumber)),
              () -> assertThrows(IllegalArgumentException.class,
              () -> contact.updatePhoneNumber(contactId)));
  }

  @Test
  void updateAddressTest() {
    Contact contact = new Contact();
    contact.updateAddress(addressTest);
    assertAll("Phone Number Test Two",
              () -> assertEquals(addressTest, contact.getAddress()),
              () -> assertThrows(IllegalArgumentException.class,
              () -> contact.updateAddress(null)),
              () -> assertThrows(IllegalArgumentException.class,
              () -> contact.updateAddress(longAddress)));
  }

  @Test
  void updateContactIdTest() {
    Contact contact = new Contact();
    contact.updateContactId(contactId);
    assertAll("Contact ID",
        () -> assertEquals(contactId, contact.getContactId()),
        () -> assertThrows(IllegalArgumentException.class,
        () -> contact.updateContactId(null)),
        () -> assertThrows(IllegalArgumentException.class,
        () -> contact.updateContactId(longContactId)));
  }
}