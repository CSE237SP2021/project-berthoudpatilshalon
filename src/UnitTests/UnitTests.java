package UnitTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import MainMenu.UserData;

class UnitTests {

	@Test
	void testCaloricIntakeStorage() {
		
		UserData myUnitTestData = new UserData();
		
		List<Integer> testCalorieList = new ArrayList<Integer>();
		testCalorieList.add(1);
		testCalorieList.add(2);
		testCalorieList.add(3);
		testCalorieList.add(4);
		
		for (int i = 0; i < testCalorieList.size(); i++) {
			myUnitTestData.addCaloricIntake(testCalorieList.get(i));
		}
		
		try {
			myUnitTestData.persistData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Inability to persist data " + e);
		}
		
		try {
			myUnitTestData.loadData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Inability to load former data" + e);
		}
		
		boolean allContentsMatch = true;
		for (int i = 0; i < testCalorieList.size(); i++) {
			allContentsMatch &= (myUnitTestData.allCaloricIntake.get(i) == testCalorieList.get(i));
		}
		
		assertTrue(allContentsMatch);
	}
	
	@Test
	void testActivityMonitorStorage() {
		UserData myUnitTestData = new UserData(); 
		
		List<Integer> testActivityTimeList = new ArrayList<Integer>(); 
		testActivityTimeList.add(30); 
		testActivityTimeList.add(75); 
		testActivityTimeList.add(95); 
		
		for (int i = 0; i < testActivityTimeList.size(); i++) { 
			myUnitTestData.addActivity(testActivityTimeList.get(i));
			
		}
		
		try {
			myUnitTestData.persistData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Inability to persist data " + e);
		}
		
		try {
			myUnitTestData.loadData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Inability to load data" + e);
		}
		
		boolean allContentsMatch = true;
		for (int i = 0; i < testActivityTimeList.size(); i++) {
			allContentsMatch &= (myUnitTestData.allCaloricIntake.get(i) == testActivityTimeList.get(i));
		}
		assertTrue(allContentsMatch);
	}
	

}
