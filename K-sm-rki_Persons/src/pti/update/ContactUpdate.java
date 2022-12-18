package pti.update;

import java.util.Scanner;

import pti.db.Database;
import pti.input.InputHandler;
import pti.model.Address;
import pti.model.Contact;

public class ContactUpdate {
	private Scanner scanner;

	public ContactUpdate(Scanner scanner) {
		super();
		this.scanner = scanner;
	}

	public void run() {
		Database db = new Database();
		System.out.println("\n\tElérhetőség modosítása:");
		Contact contact = null;
		while (contact == null) {
			int value = new InputHandler(scanner).getInt("Kérem, adjon meg az elérhetőség ID-ját: ");
			contact = db.getContactById(value);
			if (contact != null) {
				System.out.println("\t" + contact);
			} else {
				System.out.println(">>>OLYAN ID-VEL ELÉRHETÖSÉG NEM LÉTEZIK!<<<");
			}
		}

		String contactAsString = new InputHandler(scanner).getString("Kérem, adjon meg az elérhetőséget: ");
		
		int addressId = -1;
		while (addressId < 0) {
			int value = new InputHandler(scanner).getInt("Kérem, adjon meg az elérhetőség címének az ID-ját: ");
			Address address = db.getAddressById(value);
			if (address != null) {
				addressId = address.getId();
				System.out.println("\t" + address);
			} else {
				System.out.println(">>>OLYAN ID-VEL CÍM NEM LÉTEZIK!<<<");
			}
		}
		contact.setContact(contactAsString);
		contact.setAddressId(addressId);
		db.updateContact(contact);
		System.out.println("Elérhetőség sikeresen modosült");
		db.close();
	}

}
