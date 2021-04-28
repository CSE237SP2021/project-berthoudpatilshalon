package UnitTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import MainMenu.UserData;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class TestAddingGoals {
	
	@Test
	void testAddingCaloricGoal()
	{
		UserData myUnitTestData = new UserData(); 
		int testCaloricGoal = 1000;
		myUnitTestData.setCaloricGoal(testCaloricGoal);
		
		String testCalorieGoal = "";
		
		File calorieGoalFile = new File("caloric_goal.txt");
		
		try {
			Scanner scan = new Scanner(calorieGoalFile);
			testCalorieGoal = scan.nextLine();
			scan.close();
					
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		boolean goalsMatch = false;
		
		if(testCaloricGoal == Integer.parseInt(testCalorieGoal))
		{
			goalsMatch = true;
		}
		
		assertTrue(goalsMatch);
		
	}
	
	
	@Test
	void testAddingActivityGoal()
	{
		UserData myUnitTestData = new UserData(); 
		int testActivityGoal = 60;
		myUnitTestData.setActivityGoal(testActivityGoal);
		
		String testActiveTimeGoal = "";
		
		File activityGoalFile = new File("activity_goal.txt");
		
		try {
			Scanner scan = new Scanner(activityGoalFile);
			testActiveTimeGoal = scan.nextLine();
			scan.close();
					
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		boolean goalsMatch = false;
		
		if(testActivityGoal == Integer.parseInt(testActiveTimeGoal))
		{
			goalsMatch = true;
		}
		
		assertTrue(goalsMatch);
		
	}
}
