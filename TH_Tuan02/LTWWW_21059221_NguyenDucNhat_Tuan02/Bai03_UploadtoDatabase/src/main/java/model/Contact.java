package model;

import java.io.InputStream;

public class Contact {
	private int contactId;
	private String firstName;
	private String lastName;
	private InputStream photo;

	public Contact() {
	}

	//
	public Contact(int contactId, String firstName, String lastName, InputStream photo) {
		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.photo = photo;
	}

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public InputStream getPhoto() {
		return photo;
	}

	public void setPhoto(InputStream photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", firstName=" + firstName + ", lastName=" + lastName + ", photo="
				+ photo + "]";
	}

}
