package pti.model;

public class Contact {
	private int id;
	private String contact;
	private int addressId;

	public Contact(int id, String contact, int addressId) {
		super();
		this.id = id;
		this.contact = contact;
		this.addressId = addressId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", contact=" + contact + ", addressId=" + addressId + "]";
	}

}
