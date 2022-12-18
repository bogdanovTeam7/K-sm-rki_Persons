package pti.input;

import java.util.Scanner;

public class InputHandler {
	private Scanner scanner;

	public InputHandler(Scanner scanner) {
		super();
		this.scanner = scanner;
	}

	public int getValue(String massege) {
		int value = -1;
		while (value < 0) {
			System.out.print(massege);
			try {
				value = scanner.nextInt();
			} catch (Exception e) {
				e.printStackTrace();
			}
			scanner.nextLine();
		}

		return value;
	}

}
