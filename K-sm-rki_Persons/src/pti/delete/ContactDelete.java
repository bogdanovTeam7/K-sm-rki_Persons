package pti.delete;

import java.util.Scanner;

import pti.db.Database;
import pti.input.InputHandler;
import pti.model.Contact;

public class ContactDelete {
	private Scanner scanner;

	public ContactDelete(Scanner scanner) {
		super();
		this.scanner = scanner;
	}

	public void run() {
		Database db = new Database();
		System.out.println("\n\tElérhetőség törlése:");
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

		boolean isConfirm = new InputHandler(scanner)
				.getBoolean("Biztosan el akar törölni ezt az elérhetőséget? (I/N): ");

		if (isConfirm) {
			db.deleteContact(contact);
			System.out.println("Elérhetőség törölve van");
		}
		db.close();
	}
}
