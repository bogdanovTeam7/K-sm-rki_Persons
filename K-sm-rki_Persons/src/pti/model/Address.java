package pti.model;

import java.util.ArrayList;
import java.util.List;

public class Address {
	private int id;
	private String address;
	private int personId;
	private List<Contact> contacts;

	public Address(int id, String address, int personId) {
		super();
		this.id = id;
		this.address = address;
		this.personId = personId;
		this.contacts = new ArrayList<>();
	}

	public Address(String address, int personId) {
		this.id = 0;
		this.address = address;
		this.personId = personId;
		this.contacts = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void addContact(Contact contact) {
		contacts.add(contact);
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", address=" + address + ", personId=" + personId + ", contacts=" + contacts + "]";
	}

}
