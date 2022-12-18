package pti.insert;

import java.util.Scanner;

import pti.db.Database;
import pti.input.InputHandler;
import pti.model.Address;

public class ContactInsert {
	private Scanner scanner;

	public ContactInsert(Scanner scanner) {
		super();
		this.scanner = scanner;
	}

	public void run() {
		Database db = new Database();
		System.out.println("Új elérhetőség:");
		int addressId = 0;
		while (addressId < 1) {
			String massege = "kérem, adjon meg az elérhetőség ID-t: ";
			int value = new InputHandler(scanner).getValue(massege);
			Address address=db.getAddressById(value);
		}

		db.close();
	}

}
