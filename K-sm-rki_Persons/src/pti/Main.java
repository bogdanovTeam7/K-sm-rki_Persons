package pti;

import java.util.Scanner;

import pti.menu.MainMenu;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean isRunning = true;
		while (isRunning) {
			isRunning = new MainMenu(scanner).run();
		}
		scanner.close();
	}

}
