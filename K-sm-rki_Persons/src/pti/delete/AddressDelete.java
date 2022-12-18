package pti.delete;

import java.util.Scanner;

import pti.db.Database;
import pti.input.InputHandler;
import pti.model.Address;

public class AddressDelete {
	private Scanner scanner;

	public AddressDelete(Scanner scanner) {
		super();
		this.scanner = scanner;
	}

	public void run() {
		Database db = new Database();
		System.out.println("\n\tCím törlése:");
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
		boolean isConfirm = new InputHandler(scanner)
				.getBoolean("Biztosan el akar törölni ezt a címet és hozzatartozó elérhetőségeket is? (I/N): ");

		if (isConfirm) {
			db.deleteAddress(address);
		}
		System.out.println("Cím törölve van");
		db.close();

	}

}
