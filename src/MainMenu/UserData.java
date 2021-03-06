package MainMenu;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserData {
	
	public List<Integer> allCaloricIntake;
	public List<Integer> allActivities;
	public int caloricGoal;
	public int activityGoal;
	
	public UserData() {
		this.allCaloricIntake = new ArrayList<Integer>();
		this.allActivities = new ArrayList<Integer>();
		this.caloricGoal = 0;
		this.activityGoal = 0;
	}
	
	public void persistData() throws Exception {
		Files.write(Paths.get("calories.txt"), this.allCaloricIntake.toString().getBytes());
		Files.write(Paths.get("activities.txt"), this.allActivities.toString().getBytes());
		
		Files.write(Paths.get("caloric_goal.txt"), String.valueOf(caloricGoal).toString().getBytes());
		Files.write(Paths.get("activity_goal.txt"), String.valueOf(activityGoal).toString().getBytes());
	}
	
	public void loadData() throws Exception {
		List<String> allCaloricStrings = Files.readAllLines(Paths.get("calories.txt"));
		List<String> allActivityStrings = Files.readAllLines(Paths.get("activities.txt"));
		
		String caloricString = allCaloricStrings.get(0);
		caloricString = caloricString.substring(1, caloricString.length() - 1); 
		List<String> tempCaloricIntake = new ArrayList<String>(Arrays.asList(caloricString.split(", ")));
		allCaloricIntake.clear();
		for (int i = 0; i < tempCaloricIntake.size(); i++) {
			if (!tempCaloricIntake.get(i).trim().isEmpty()) {
				allCaloricIntake.add(Integer.parseInt(tempCaloricIntake.get(i)));
			}
			
		}
		
		
		String activityString = allActivityStrings.get(0);
		activityString = activityString.substring(1, activityString.length() - 1);
		List<String> tempActivities = new ArrayList<String>(Arrays.asList(activityString.split(", ")));
		allActivities.clear();
		for (int i = 0; i < tempActivities.size(); i++) {
			if (!tempActivities.get(i).trim().isEmpty()) {
				allActivities.add(Integer.parseInt(tempActivities.get(i)));
			}
		}
		
		// load goals
		List<String> caloricGoalStrings = Files.readAllLines(Paths.get("caloric_goal.txt"));
		List<String> activityGoalStrings = Files.readAllLines(Paths.get("activity_goal.txt"));
		caloricGoal = Integer.parseInt(caloricGoalStrings.get(0));
		activityGoal = Integer.parseInt(activityGoalStrings.get(0));
	}
	
	public void addCaloricIntake(int calories) {
		allCaloricIntake.add(calories);
		try {
			persistData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	public void addActivity(int activity) {
		allActivities.add(activity);
		try {
			persistData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void setCaloricGoal(int calories) {
		caloricGoal = calories;
		try {
			persistData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void setActivityGoal(int minutes) {
		activityGoal = minutes;
		try {
			persistData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void clearGoals() {
		activityGoal = 0; 
		caloricGoal = 0; 
		try {
			persistData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
