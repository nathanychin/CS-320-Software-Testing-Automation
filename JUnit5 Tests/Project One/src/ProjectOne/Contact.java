package ProjectOne;

public class Contact {

	  private static final String INITIALIZER = "Initial";
	  private String contactId;
	  private String firstName;
	  private String lastName;
	  private String phoneNumber;
	  private String address;

	  Contact() {
	    this.contactId = INITIALIZER;
	    this.firstName = INITIALIZER;
	    this.lastName = INITIALIZER;
	    this.phoneNumber = "1234567890";
	    this.address = INITIALIZER;
	  }

	  Contact(String contactId) {
	    updateContactId(contactId);
	    this.firstName = INITIALIZER;
	    this.lastName = INITIALIZER;
	    this.phoneNumber = "1234567890";
	    this.address = INITIALIZER;
	  }

	  Contact(String contactId, String firstName) {
	    updateContactId(contactId);
	    updateFirstName(firstName);
	    this.lastName = INITIALIZER;
	    this.phoneNumber = "1234567890";
	    this.address = INITIALIZER;
	  }

	  Contact(String contactId, String firstName, String lastName) {
	    updateContactId(contactId);
	    updateFirstName(firstName);
	    updateLastName(lastName);
	    this.phoneNumber = "1234567890";
	    this.address = INITIALIZER;
	  }

	  Contact(String contactId, String firstName, String lastName,
	          String phoneNumber) {
	    updateContactId(contactId);
	    updateFirstName(firstName);
	    updateLastName(lastName);
	    updatePhoneNumber(phoneNumber);
	    this.address = INITIALIZER;
	  }

	  Contact(String contactId, String firstName, String lastName,
	          String phoneNumber, String address) {
	    updateContactId(contactId);
	    updateFirstName(firstName);
	    updateLastName(lastName);
	    updatePhoneNumber(phoneNumber);
	    updateAddress(address);
	  }

	  protected final String getContactId() { return contactId; }

	  protected final String getFirstName() { return firstName; }

	  protected final String getLastName() { return lastName; }

	  protected final String getPhoneNumber() { return phoneNumber; }

	  protected final String getAddress() { return address; }

	  protected void updateFirstName(String firstName) {
	    if (firstName == null) {
	      throw new IllegalArgumentException("First name is empty.");
	    } else if (firstName.length() > 10) {
	      throw new IllegalArgumentException("First name cannot be longer than 10 characters");
	    } else {
	      this.firstName = firstName;
	    }
	  }

	  protected void updateLastName(String lastName) {
	    if (lastName == null) {
	      throw new IllegalArgumentException("Last name is empty");
	    } else if (lastName.length() > 10) {
	      throw new IllegalArgumentException("Last name cannot be longer than 10 characters");
	    } else {
	      this.lastName = lastName;
	    }
	  }

	  protected void updatePhoneNumber(String phoneNumber) {
	    String regex = "[0-9]+";
	    if (phoneNumber == null) {
	      throw new IllegalArgumentException("Invalid phone number.");
	    } else if (phoneNumber.length() != 10) {
	      throw new IllegalArgumentException(
	          "Phone number length invalid. Must be 10 digits.");
	    } else if (!phoneNumber.matches(regex)) {
	      throw new IllegalArgumentException(
	          "Invalid phone number");
	    } else {
	      this.phoneNumber = phoneNumber;
	    }
	  }

	  protected void updateAddress(String address) {
	    if (address == null) {
	      throw new IllegalArgumentException("Address is empty");
	    } else if (address.length() > 30) {
	      throw new IllegalArgumentException("Address cannot be longer than30 characters");
	    } else {
	      this.address = address;
	    }
	  }

	  protected void updateContactId(String contactId) {
	    if (contactId == null) {
	      throw new IllegalArgumentException("Contact ID is empty");
	    } else if (contactId.length() > 10) {
	      throw new IllegalArgumentException("Contact ID cannot be longer than 10 characters");
	    } else {
	      this.contactId = contactId;
	    }
	  }
	}