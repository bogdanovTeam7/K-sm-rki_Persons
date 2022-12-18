package pti.delete;

import java.util.Scanner;

import pti.db.Database;
import pti.input.InputHandler;
import pti.model.Person;

public class PersonDelete {
	private Scanner scanner;

	public PersonDelete(Scanner scanner) {
		super();
		this.scanner = scanner;
	}

	public void run() {
		Database db = new Database();
		System.out.println("\n\tSzemély törlése:");
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
		boolean isConfirm = new InputHandler(scanner).getBoolean(
				"Biztosan el akar törölni ezt a személyt és hozzatartozó  címeket és elérhetőségeket is? (I/N): ");

		if (isConfirm) {
			db.deletePerson(person);
		}
		System.out.println("Személy adatok törölve vannak");
		db.close();

	}
}
