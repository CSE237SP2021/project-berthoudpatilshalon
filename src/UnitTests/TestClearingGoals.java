package UnitTests;

import static org.junit.Assert.assertFalse;
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

class TestClearingGoals {
	
	@Test
	void clearGoals() {
		UserData myUserData = new UserData(); 
		myUserData.setActivityGoal(100);
		myUserData.setCaloricGoal(100);
		
		int firstActivityGoal = myUserData.activityGoal;
		int firstCalorieGoal = myUserData.caloricGoal;
		
		myUserData.clearGoals();
		
		assertFalse(myUserData.activityGoal == firstActivityGoal);
		assertFalse(myUserData.caloricGoal == firstCalorieGoal);
	}

}
