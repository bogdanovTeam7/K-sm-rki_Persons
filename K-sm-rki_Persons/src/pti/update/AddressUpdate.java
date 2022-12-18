package pti.update;

import java.util.Scanner;

import pti.db.Database;
import pti.input.InputHandler;
import pti.model.Address;
import pti.model.Person;

public class AddressUpdate {
	private Scanner scanner;

	public AddressUpdate(Scanner scanner) {
		super();
		this.scanner = scanner;
	}

	public void run() {
		Database db = new Database();
		System.out.println("\n\tCím modosítása:");
		Address address = null;
		while (address == null) {
			int value = new InputHandler(scanner).getInt("Kérem, adjon meg a cím ID-ját: ");
			address = db.getAddressById(value);
			if (address != null) {
				System.out.println("\t" + address);
			} else {
				System.out.println(">>>OLYAN ID-VEL CÍM NEM LÉTEZIK!<<<");
			}
		}

		String addressAsString = new InputHandler(scanner).getString("Kérem, adjon meg a címet: ");
		int personId = -1;
		while (personId < 0) {
			int value = new InputHandler(scanner).getInt("Kérem, adjon meg a címhez tartozó személynek az ID-ját: ");
			Person person = db.getPersonById(value);
			if (person != null) {
				personId = person.getId();
				System.out.println("\t" + person);
			} else {
				System.out.println(">>>OLYAN ID-VEL SZEMÉLY NEM LÉTEZIK!<<<");
			}
		}

		address.setAddress(addressAsString);
		address.setPersonId(personId);
		db.updateAddress(address);
		System.out.println("Cím sikeresen modosült");
		db.close();

	}

}
