package MainMenu;

import java.util.ArrayList;
import MainMenu.UserData;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
	private Scanner keyboardIn;
	private UserData userData;
	
	public static void main(String[] args) {
		MainMenu myStartingMenu = new MainMenu();
	}
	
	public MainMenu() {
		
		keyboardIn = new Scanner(System.in);
		UserData userData = new UserData();
		this.userData = userData; 
		displayMainMenu();
		
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
		List<Integer> validInputs = new ArrayList<Integer>();
		
		System.out.println("Welcome to the Caloric/Activity Tracker: ");
		System.out.println();
		System.out.println("1. Press ‘1’ if you are a new user of the program");
		System.out.println("2. Press ‘2’ if you are a returning user");
		System.out.println();
		
		validInputs.add(1);
		validInputs.add(2);
		int selection = getInput(validInputs);
		if (selection == 1) { 
			displayNewUserMenu();
		}
		else if (selection ==2) { 
			displayExistingUserMenu(); 
		}

	}
	
	private void displayNewUserMenu() {
		List<Integer> validInputs = new ArrayList<Integer>();
		validInputs.add(1);
		validInputs.add(2);
		System.out.println();
		System.out.println("1. Press '1' to enter your weekly caloric intake goal (in calories)");
		System.out.println("2. Press '2' to enter your weekly activity level goal (in minutes)");
		System.out.println();
		
		int selection = this.getInput(validInputs);
		if (selection == 1) { 
			enterWeeklyCaloricIntakeGoal(); 
		} else if (selection == 2) { 
			enterWeeklyActivityGoal(); 
		}

	}
	
	private void displayExistingUserMenu() {
		try {
			this.userData.loadData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("1. Press ‘1’ to enter your caloric intake for the day (calories)");
		System.out.println("2. Press ‘2’ to enter your activity/workout for the day (minutes)");
		System.out.println("3. Press ‘3’ to check your caloric intake for the past week ");
		System.out.println("4. Press ‘4’ to check your activity over the past week ");
		System.out.println("5. Press ‘5’ to reset your caloric intake and activity level goals");
		System.out.println();
		
		List<Integer> validInputs = new ArrayList<Integer>();
		for (int i = 1; i <= 5; i++) {
			validInputs.add(i);
		}
		
		int selection = this.getInput(validInputs);
		
		if (selection == 1) {
			enterDailyCaloricIntake();
		} else if (selection == 2) {
			enterDailyActivity();
		} else if (selection == 3) {
			checkCaloricIntake();
		} else if (selection == 4) { 
			checkActivity(); 
		} else if (selection == 5) { 
			clearGoals(); 
		}
		
		
	}
	
	private void enterWeeklyCaloricIntakeGoal() { 
		System.out.println("Enter your weekly calorinc intake goal (in calories)");
		System.out.println(); 
		List<Integer> allIntegers = new ArrayList<Integer>();
		for (int i = 0; i < 500000; i++) {
			allIntegers.add(i);
		}
		userData.setCaloricGoal(getInput(allIntegers));
		if (userData.activityGoal == 0) {
			enterWeeklyActivityGoal();
		} else {
			displayExistingUserMenu();
		}
	}
	
	private void enterWeeklyActivityGoal() {
		
		List<Integer> allIntegers = new ArrayList<Integer>();
		for (int i = 0; i < 500000; i++) {
			allIntegers.add(i);
		}
		
		System.out.println("Enter your weekly activity goal (in minutes)"); 
		System.out.println();
		userData.setActivityGoal(getInput(allIntegers));
		
		if (this.userData.activityGoal == 0) {
			enterWeeklyCaloricIntakeGoal();
		} else {
			displayExistingUserMenu();
		}
	}
	
	private void enterDailyCaloricIntake() { 
		System.out.println("Enter your caloric intake today (in calories)");
		System.out.println(); 
		List<Integer> allIntegers = new ArrayList<Integer>();
		for (int i = 0; i < 500000; i++) {
			allIntegers.add(i);
		}
		
		userData.addCaloricIntake(getInput(allIntegers));
		displayExistingUserMenu();
	}
	
	private void enterDailyActivity() { 
		System.out.println("Enter your activity today (in minutes)");
		System.out.println(); 
		List<Integer> allIntegers = new ArrayList<Integer>();
		for (int i = 0; i < 500000; i++) {
			allIntegers.add(i);
		}
		
		userData.addActivity(getInput(allIntegers));
		displayExistingUserMenu();
	}
	
	private void checkCaloricIntake() {
		int calLength = userData.allCaloricIntake.size();
		List<Integer> lastWeek;
		if (calLength > 7) {
			lastWeek = userData.allCaloricIntake.subList(calLength - 7, calLength);
		} else {
			lastWeek = userData.allCaloricIntake;
		}
		int totalCaloriesIntakedThisWeek = 0;
		for (int i = 0; i < lastWeek.size(); i++) {
			totalCaloriesIntakedThisWeek += lastWeek.get(i);
		}
		
		System.out.println("The last seven days of calorie intake " + lastWeek);
		if (userData.caloricGoal > totalCaloriesIntakedThisWeek) {
			System.out.println("You are currently " + (userData.caloricGoal - totalCaloriesIntakedThisWeek) + " below your weekly caloric intake goal!"); 
		} else {
			System.out.println("You are currently " + (totalCaloriesIntakedThisWeek - userData.caloricGoal) + " over your weekly caloric intake goal!");
		}
		System.out.println();
		
		displayExistingUserMenu(); 
		
	}
	
	private void checkActivity() {
		int activityLength = userData.allActivities.size();
		List<Integer> lastWeek;
		if (activityLength > 7) {
			lastWeek = userData.allActivities.subList(activityLength - 7, activityLength);
		} else {
			lastWeek = userData.allActivities;
		}
		int totalActivityThisWeek = 0;
		for (int i = 0; i < lastWeek.size(); i++) {
			totalActivityThisWeek += lastWeek.get(i);
		}
		
		System.out.println("The last seven days of activity " + lastWeek);
		if (this.userData.caloricGoal > totalActivityThisWeek) {
			System.out.println("You are currently " + (userData.activityGoal - totalActivityThisWeek) + " below your weekly activity goal!"); 
		} else {
			System.out.println("You are currently " + (totalActivityThisWeek - userData.activityGoal) + " over your weekly activity goal!");
		}
		System.out.println();
		
		displayExistingUserMenu(); 
	
	}
	private void clearGoals() { 
		userData.clearGoals();
		displayNewUserMenu(); 
	}
} 