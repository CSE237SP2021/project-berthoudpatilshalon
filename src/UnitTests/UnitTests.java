package UnitTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import MainMenu.UserData;

class UnitTests {

	@Test
	void testCaloricIntakeStorage() {
		
		UserData myData = new UserData();
		
		List<Integer> testCalorieList = new ArrayList<Integer>();
		testCalorieList.add(1);
		testCalorieList.add(2);
		testCalorieList.add(3);
		testCalorieList.add(4);
		
		for (int i = 0; i < testCalorieList.size(); i++) {
			myData.addCaloricIntake(testCalorieList.get(i));
		}
		
		try {
			myData.persistData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("You suck! " + e);
		}
		
		try {
			myData.loadData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Illiteracy" + e);
		}
		
		boolean allContentsMatch = true;
		for (int i = 0; i < testCalorieList.size(); i++) {
			allContentsMatch &= (myData.allCaloricIntake.get(i) == testCalorieList.get(i));
		}
		
		assertTrue(allContentsMatch);
	}

}
