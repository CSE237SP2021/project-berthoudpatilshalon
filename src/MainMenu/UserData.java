package MainMenu;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserData {
	
	private List<Integer> allCaloricIntake;
	private List<String> allActivities;
	
	public UserData() {
		this.allCaloricIntake = new ArrayList<Integer>();
		this.allActivities = new ArrayList<String>();
	}
	
	public void persistData() throws Exception {
		Files.write(Paths.get("calories.txt"), this.allCaloricIntake.toString().getBytes());
		Files.write(Paths.get("activities.txt"), this.allActivities.toString().getBytes());
	}
	
	public void loadData() throws Exception {
		List<String> allCaloricStrings = Files.readAllLines(Paths.get("calories.txt"));
		List<String> allActivityStrings = Files.readAllLines(Paths.get("activities.txt"));
		
		String caloricString = allCaloricStrings.get(0);
		List<String> tempCaloricIntake = new ArrayList<String>(Arrays.asList(caloricString.split(" ")));
		for (int i = 0; i < tempCaloricIntake.size(); i++) {
			allCaloricIntake.set(i, Integer.parseInt(tempCaloricIntake.get(i)));
		}
		
		String activityString = allActivityStrings.get(0);
		allActivities = new ArrayList<String>(Arrays.asList(activityString.split(" ")));
	}
	
	public void addCaloricIntake(int calories) {
		allCaloricIntake.add(calories);
	}
	
	public void addActivity(String activity) {
		allActivities.add(activity);
	}
	
}
