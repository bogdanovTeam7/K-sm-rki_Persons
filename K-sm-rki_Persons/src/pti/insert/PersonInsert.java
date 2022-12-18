package pti.insert;

import java.util.Scanner;

import pti.db.Database;
import pti.input.InputHandler;
import pti.model.Person;

public class PersonInsert {
	private Scanner scanner;

	public PersonInsert(Scanner scanner) {
		super();
		this.scanner = scanner;
	}

	public void run() {
		Database db = new Database();
		System.out.println("\n\tÚj személy:");

		String name = new InputHandler(scanner).getString("Kérem, adjon meg a nevét: ");
		Person person = new Person(name);
		db.insertPerson(person);
		System.out.println("Új személy sikeresen el van mentve");
		db.close();

	}

}
