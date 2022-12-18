package pti.insert;

import java.util.Scanner;

import pti.db.Database;
import pti.input.InputHandler;
import pti.model.Address;
import pti.model.Contact;

public class ContactInsert {
	private Scanner scanner;

	public ContactInsert(Scanner scanner) {
		super();
		this.scanner = scanner;
	}

	public void run() {
		Database db = new Database();
		System.out.println("\n\tÚj elérhetőség:");
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

		String contactAsString = new InputHandler(scanner).getString("Kérem, adjon meg az elérhetőséget: ");
		Contact contact = new Contact(contactAsString, addressId);
		db.insertContact(contact);
		System.out.println("Új elérhetőség sikeresen el van mentve");
		db.close();
	}

}
