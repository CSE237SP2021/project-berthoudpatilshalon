package MainMenu;

import java.util.ArrayList;
import MainMenu.UserData;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
	private Scanner keyboardIn;
	
	public static void main(String[] args) {
		MainMenu myStartingMenu = new MainMenu();
	}
	
	public MainMenu() {
		
		keyboardIn = new Scanner(System.in);
		UserData userData = new UserData();
		displayMainMenu();
		
		List<Integer> validInputs = new ArrayList<Integer>();
		List<Integer> allIntegers = new ArrayList<Integer>();
		for (int i = 0; i < 5000; i++) {
			allIntegers.add(i);
		}
		
		validInputs.add(1);
		validInputs.add(2);
		
		int selection = this.getInput(validInputs);
		
		if (selection == 1) {
			displayNewUserMenu();
			int newSelection = this.getInput(validInputs);
			if (newSelection == 1) {
				System.out.println("Enter your weekly calorinc intake goal (in calories)"); 
				userData.setCaloricGoal(this.getInput(allIntegers));
			} else if (newSelection == 2) {
				System.out.println("Enter your weekly activity goal (in minutes)"); 
				userData.setActivityGoal(this.getInput(allIntegers));
			}
			
		} else {
			displayExistingUserMenu();
			validInputs.add(3);
			validInputs.add(4);
			validInputs.add(5);
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
		System.out.println("1. Press ‘1’ if you are a new user of the program");
		System.out.println("2. Press ‘2’ if you are a returning user");
		System.out.println();
	}
	
	private void displayNewUserMenu() {
		System.out.println();
		System.out.println("1. Press '1' to enter your weekly caloric intake goal (in calories)");
		System.out.println("2. Press '2' to enter your weekly activity level goal (in minutes)");
		System.out.println();
	}
	
	private void displayExistingUserMenu() {
		System.out.println("1. Press ‘1’ to enter your caloric intake for the day (calories)");
		System.out.println("2. Press ‘2’ to enter your activity/workout for the day (minutes)");
		System.out.println("3. Press ‘3’ to check your caloric intake for the past week ");
		System.out.println("4. Press ‘4’ to check your activity over the past week ");
		System.out.println("5. Press ‘5’ to reset your caloric intake and activity level goals");
		System.out.println();
	}
	
}