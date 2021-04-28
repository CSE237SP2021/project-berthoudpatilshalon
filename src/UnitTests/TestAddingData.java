package UnitTests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import MainMenu.UserData;

class TestAddingData {
	@Test
	void testAddingCaloricData()
	{
UserData myUserData = new UserData(); 
		
		List<Integer> testCalorieList = new ArrayList<Integer>();
		
		testCalorieList.add(3000); 
		myUserData.addCaloricIntake(3000);
		testCalorieList.add(2750); 
		myUserData.addCaloricIntake(2750);
		testCalorieList.add(2950); 
		myUserData.addCaloricIntake(2950);
		
		String message = null;
		try {
			message = Files.readAllLines(Paths.get("calories.txt")).get(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		assertTrue(message.equals(testCalorieList.toString()), message + ", " + testCalorieList.toString());
	}
	
	
	@Test
	void testAddingActivityData()
	{
		UserData myUserData = new UserData(); 
		
		List<Integer> testActivityList = new ArrayList<Integer>();
		
		testActivityList.add(3000); 
		myUserData.addActivity(3000);
		testActivityList.add(2750); 
		myUserData.addActivity(2750);
		testActivityList.add(2950); 
		myUserData.addActivity(2950);
		
		String message = null;
		try {
			message = Files.readAllLines(Paths.get("activities.txt")).get(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		assertTrue(message.equals(testActivityList.toString()), message + ", " + testActivityList.toString());
	}
}
