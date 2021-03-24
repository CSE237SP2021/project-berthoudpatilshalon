package MainMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
	private Scanner keyboardIn;
	
	public static void main(String[] args) {
		MainMenu myStartingMenu = new MainMenu();
	}
	
	public MainMenu() {
		keyboardIn = new Scanner(System.in);
		displayMainMenu();
		
		List<Integer> validInputs = new ArrayList<Integer>();
		validInputs.add(1);
		validInputs.add(2);
		
		int selection = this.getInput(validInputs);
		
		if (selection == 1) {
			displayNewUserMenu();
			int newSelection = this.getInput(validInputs);
		}
		
	}
	
	private int getInput(List<Integer> validInputs) {
		try {
			int selectedOption = keyboardIn.nextInt();
			if (validInputs.contains(selectedOption)) {
				return selectedOption;
			} else {
				System.out.println("Please input one of: " + validInputs);
				return getInput(validInputs);
			}
		} catch(Exception e) {
			keyboardIn.nextLine();
			System.out.println("Please input one of: " + validInputs);
			return getInput(validInputs);
		}
		
	}
	
	private void displayMainMenu() {
		System.out.println("Welcome to the Caloric/Activity Tracker: ");
		System.out.println();
		System.out.println("1) Press ‘1’ if you are a new user of the program");
		System.out.println("2) Press ‘2’ if you are a returning user");
		System.out.println();
	}
	
	private void displayNewUserMenu() {
		System.out.println("Welcome to your new Caloric/Activity Tracker! ");
		System.out.println();
		System.out.println("1.Enter your daily caloric intake goal");
		System.out.println("2.Enter your daily activity level goal");
		System.out.println();
	}
	
}
