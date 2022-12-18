package pti.menu;

import java.util.List;
import java.util.Scanner;

import pti.db.Database;
import pti.input.InputHandler;
import pti.insert.ContactInsert;
import pti.model.Address;
import pti.model.Contact;
import pti.model.Person;

public class MainMenu {
	private Scanner scanner;

	public MainMenu(Scanner scanner) {
		super();
		this.scanner = scanner;
	}

	public boolean run() {
		print();
		int selectedMenuPoint = -1;
		boolean isRunning = true;
		Database db = new Database();
		while (selectedMenuPoint < 1 || selectedMenuPoint > 13) {
			String massege = "Kérem, válasszon a menüpontok között: ";
			selectedMenuPoint = new InputHandler(scanner).getValue(massege);
			switch (selectedMenuPoint) {
			case 1:
				List<Person> persons = db.getAllPersons();
				printList(persons, "Személyek");
				break;
			case 2:
				List<Address> addresses = db.getAllAddresses();
				printList(addresses, "Címek");
				break;
			case 3:
				List<Contact> contacts = new Database().getAllContacts();
				printList(contacts, "Elérhetőségek");
				break;
			case 4:

				break;
			case 5:

				break;
			case 6:
				new ContactInsert(scanner).run();
				break;
			case 7:

				break;
			case 8:

				break;
			case 9:

				break;
			case 10:

				break;
			case 11:

				break;
			case 12:

				break;
			case 13:

				break;

			}
		}
		db.close();
		return isRunning;
	}

	private <E> void printList(List<E> list, String title) {
		System.out.println(title);
		for (E e : list) {
			System.out.println("\t" + e);
		}
	}

	private void print() {
		StringBuilder builder = new StringBuilder();
		builder.append("\n1. Személyek lekérdezése\n");
		builder.append("2. Címek lekérdezése\n");
		builder.append("3. Elérhetősékek lekérdezése\n");
		builder.append("4. Új személy\n");
		builder.append("5. Új cím\n");
		builder.append("6. Új elérhetőség\n");
		builder.append("7. Személy módosítása\n");
		builder.append("8. Cím módosítása\n");
		builder.append("9. Elérhetőség módosítása\n");
		builder.append("10. Személy törlése\n");
		builder.append("11. Cím törlése\n");
		builder.append("12. Elérhetőség törlése\n");
		builder.append("13. Kilépés\n");
		System.out.println(builder);
	}

}
