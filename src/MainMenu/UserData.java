package MainMenu;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserData {
	
	private List<Integer> allCaloricIntake;
	private List<Integer> allActivities;
	private int caloricGoal;
	private int activityGoal;
	
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
		List<String> tempCaloricIntake = new ArrayList<String>(Arrays.asList(caloricString.split(" ")));
		allCaloricIntake.clear();
		for (int i = 0; i < tempCaloricIntake.size(); i++) {
			allCaloricIntake.set(i, Integer.parseInt(tempCaloricIntake.get(i)));
		}
		
		
		String activityString = allActivityStrings.get(0);
		List<String> tempActivities = new ArrayList<String>(Arrays.asList(activityString.split(" ")));
		allActivities.clear();
		for (int i = 0; i < tempActivities.size(); i++) {
			allActivities.set(i, Integer.parseInt(tempActivities.get(i)));
		}
		
		// load goals
		List<String> caloricGoalStrings = Files.readAllLines(Paths.get("caloric_goal.txt"));
		List<String> activityGoalStrings = Files.readAllLines(Paths.get("activity_goal.txt"));
		caloricGoal = Integer.parseInt(caloricGoalStrings.get(0));
		activityGoal = Integer.parseInt(activityGoalStrings.get(0));
	}
	
	public void addCaloricIntake(int calories) {
		allCaloricIntake.add(calories);
	}
	
	public void addActivity(int activity) {
		allActivities.add(activity);
	}
	
	public void setCaloricGoal(int calories) {
		caloricGoal = calories;
	}
	
	public void setActivityGoal(int minutes) {
		caloricGoal = minutes;
	}
}
