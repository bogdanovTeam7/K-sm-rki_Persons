package pti.input;

import java.util.Scanner;

public class InputHandler {
	private Scanner scanner;

	public InputHandler(Scanner scanner) {
		super();
		this.scanner = scanner;
	}

	public int getInt(String massege) {
		int value = 0;
		while (value < 1) {
			System.out.print(massege);
			try {
				value = scanner.nextInt();
			} catch (Exception e) {
				System.out.println(">>>CSAK EGÉSZ SZÁMOT ADHAT!<<<");
			}
			scanner.nextLine();
		}

		return value;
	}

	public String getString(String massege) {
		String value = "";
		while (value.length() < 1) {
			System.out.println(massege);
			value = scanner.nextLine().trim();
		}
		return value;
	}

}
