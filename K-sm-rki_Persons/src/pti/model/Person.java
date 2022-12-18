package pti.model;

import java.util.ArrayList;
import java.util.List;

public class Person {
	private int id;
	private String name;
	private List<Address> addresses;

	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.addresses = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addAddress(Address address) {
		addresses.add(address);
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", addresses=" + addresses + "]";
	}
	
	

}
