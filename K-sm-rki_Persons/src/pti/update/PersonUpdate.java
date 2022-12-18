package pti.update;

import java.util.Scanner;

import pti.db.Database;
import pti.input.InputHandler;
import pti.model.Person;

public class PersonUpdate {
	private Scanner scanner;

	public PersonUpdate(Scanner scanner) {
		super();
		this.scanner = scanner;
	}

	public void run() {
		Database db = new Database();
		System.out.println("\n\tSzemély modosítása:");
		Person person = null;
		while (person == null) {
			int value = new InputHandler(scanner).getInt("Kérem, adjon meg a személy ID-ját: ");
			person = db.getPersonById(value);
			if (person != null) {
				System.out.println("\t" + person);
			} else {
				System.out.println(">>>OLYAN ID-VEL SZEMÉLY NEM LÉTEZIK!<<<");
			}
		}

		String name = new InputHandler(scanner).getString("Kérem, adjon meg a nevét: ");
		person.setName(name);
		db.updatePerson(person);
		System.out.println("Személy adatok sikeresen modosültek");
		db.close();

	}

}
