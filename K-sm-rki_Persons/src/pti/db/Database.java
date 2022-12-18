package pti.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pti.model.Address;
import pti.model.Contact;
import pti.model.Person;

public class Database {
	private final static String DB_URL = "jdbc:mysql://localhost:3306/k-sm-rki_persondb";
	private final static String DB_USER = "root";
	private final static String DB_PSW = "root";
	private Connection conn;

	public Database() {
		try {
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PSW);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Contact> getAllContacts() {
		List<Contact> contacts = new ArrayList<>();
		String sql = "SELECT * FROM contacts";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String contactAsString = rs.getString("contact");
				int addressId = rs.getInt("address_id");
				Contact contact = new Contact(id, contactAsString, addressId);
				contacts.add(contact);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contacts;
	}

	public List<Address> getAllAddresses() {
		List<Address> addresses = new ArrayList<>();
		String sql = "SELECT * FROM addresses";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				int id = rs.getInt("id");
				String addressAsString = rs.getString("address");
				int personId = rs.getInt("person_id");
				Address address = new Address(id, addressAsString, personId);

				setContacts(address);

				addresses.add(address);

			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return addresses;
	}

	private void setContacts(Address address) {
		List<Contact> contacts = getContactsByAddressId(address.getId());
		for (Contact contact : contacts) {
			address.addContact(contact);
		}
	}

	private List<Contact> getContactsByAddressId(int addressId) {
		List<Contact> contacts = new ArrayList<>();
		String sql = "SELECT * FROM contacts WHERE address_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, addressId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String contactAsString = rs.getString("contact");
				Contact contact = new Contact(id, contactAsString, addressId);
				contacts.add(contact);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contacts;
	}

	public List<Person> getAllPersons() {
		List<Person> persons = new ArrayList<>();
		String sql = "SELECT * FROM persons";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				Person person = new Person(id, name);

				setAddresses(person);

				persons.add(person);
			}

			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return persons;
	}

	private void setAddresses(Person person) {
		List<Address> addresses = getAddressesByPersonId(person.getId());
		for (Address address : addresses) {
			person.addAddress(address);
		}
	}

	private List<Address> getAddressesByPersonId(int personId) {
		List<Address> addresses = new ArrayList<>();
		String sql = "SELECT * FROM addresses WHERE person_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, personId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String addressAsString = rs.getString("address");
				Address address = new Address(id, addressAsString, personId);
				setContacts(address);
				addresses.add(address);

			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return addresses;
	}

	public Address getAddressById(int id) {
		Address address = null;
		String sql = "SELECT * FROM addresses WHERE id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String addressAsString = rs.getString("address");
				int personId = rs.getInt("person_id");
				address = new Address(id, addressAsString, personId);
				setContacts(address);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return address;
	}

	public void insertContact(Contact contact) {
		String sql = "INSERT INTO contacts (contact,address_id) VALUES (?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, contact.getContact());
			ps.setInt(2, contact.getAddressId());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Person getPersonById(int id) {
		Person person = null;
		String sql = "SELECT * FROM persons WHERE id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				person = new Person(id, name);
				setAddresses(person);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return person;
	}

	public void insertAddress(Address address) {
		String sql = "INSERT INTO addresses (address,person_id) VALUES (?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, address.getAddress());
			ps.setInt(2, address.getPersonId());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void insertPerson(Person person) {
		String sql = "INSERT INTO persons (name) VALUES (?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, person.getName());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Contact getContactById(int id) {
		Contact contact = null;
		String sql = "SELECT * FROM contacts WHERE id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String contactAsString = rs.getString("contact");
				int addressId = rs.getInt("address_id");
				contact = new Contact(id, contactAsString, addressId);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contact;
	}

	public void updateContact(Contact contact) {
		String sql = "UPDATE contacts SET contact=?, address_id=? WHERE id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, contact.getContact());
			ps.setInt(2, contact.getAddressId());
			ps.setInt(3, contact.getId());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void updateAddress(Address address) {
		String sql = "UPDATE addresses SET address=?, person_id=? WHERE id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, address.getAddress());
			ps.setInt(2, address.getPersonId());
			ps.setInt(3, address.getId());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void updatePerson(Person person) {
		String sql = "UPDATE persons SET name=? WHERE id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, person.getName());
			ps.setInt(2, person.getId());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void deleteContact(Contact contact) {
		String sql = "DELETE FROM contacts WHERE id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, contact.getId());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void deleteAddress(Address address) {

		List<Contact> contacts = address.getContacts();
		for (Contact contact : contacts) {
			deleteContact(contact);
		}

		String sql = "DELETE FROM addresses WHERE id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, address.getId());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void deletePerson(Person person) {
		List<Address> addresses = person.getAddresses();
		for (Address address : addresses) {
			deleteAddress(address);
		}
		String sql = "DELETE FROM persons WHERE id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, person.getId());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
