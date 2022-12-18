package pti.insert;

import java.util.Scanner;

import pti.db.Database;
import pti.input.InputHandler;
import pti.model.Address;
import pti.model.Person;

public class AddressInsert {
	private Scanner scanner;

	public AddressInsert(Scanner scanner) {
		super();
		this.scanner = scanner;
	}

	public void run() {
		Database db = new Database();
		System.out.println("\n\tÚj cím:");
		int personId = -1;
		while (personId < 0) {
			int value = new InputHandler(scanner).getInt("Kérem, adjon meg az címhez tartozó személynek az ID-ját: ");
			Person person = db.getPersonById(value);
			if (person != null) {
				personId = person.getId();
				System.out.println("\t" + person);
			} else {
				System.out.println(">>>OLYAN ID-VEL SZEMÉLY NEM LÉTEZIK!<<<");
			}
		}

		String addressAsString = new InputHandler(scanner).getString("Kérem, adjon meg a címet: ");
		Address address = new Address(addressAsString, personId);
		db.insertAddress(address);
		System.out.println("Új cím sikeresen el van mentve");
		db.close();

	}

}
