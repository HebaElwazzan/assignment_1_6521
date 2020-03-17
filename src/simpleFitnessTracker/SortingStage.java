package simpleFitnessTracker;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SortingStage {
	public static void display(List<Activity> activitiesList) {
		 Stage sortingWindow = new Stage();
		 sortingWindow.initModality(Modality.APPLICATION_MODAL); //to block out other window while this window is running
	     sortingWindow.setTitle("Sort");
	     
	     DecimalFormat df = new DecimalFormat("#.###"); //to format the double heart rate value to 3 decimal places
	     
	     Collections.sort(activitiesList);
	     
	     Label activityHeader = new Label("Activity");
	     Label caloriesHeader = new Label("Calories Burnt");
	     Label heartRateHeader = new Label("Heart Rate Increase\n(beats/minute)");
	     
	     Label firstActivity = new Label(activitiesList.get(0).toString());
	     Label firstCal = new Label(Integer.toString(activitiesList.get(0).getCaloriesBurnt()));
	     Label firstHeartRate = new Label(df.format(activitiesList.get(0).getHeartRateIncrease()));
	     //I used a wrapper class Integer to convert the int value into string (I could have used decimal format df instead)
	     
	     Label secondActivity = new Label(activitiesList.get(1).toString());
	     Label secondCal = new Label(Integer.toString(activitiesList.get(1).getCaloriesBurnt()));
	     Label secondHeartRate = new Label(df.format(activitiesList.get(1).getHeartRateIncrease()));
	     
	     Label thirdActivity = new Label(activitiesList.get(2).toString());
	     Label thirdCal = new Label(Integer.toString(activitiesList.get(2).getCaloriesBurnt()));
	     Label thirdHeartRate = new Label(df.format(activitiesList.get(2).getHeartRateIncrease()));
	     
	     Label fourthActivity = new Label(activitiesList.get(3).toString());
	     Label fourthCal = new Label(Integer.toString(activitiesList.get(3).getCaloriesBurnt()));
	     Label fourthHeartRate = new Label(df.format(activitiesList.get(3).getHeartRateIncrease()));
	     
	     Button backButton = new Button("Back");
	     
	     
	     backButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
					sortingWindow.close();
			}
		});
	     GridPane grid = new GridPane();
	     grid.setPadding(new Insets(10, 10, 10, 10));
	     grid.setVgap(8);
	     grid.setHgap(10);
	     
	     grid.add(activityHeader, 0, 0);
	     grid.add(caloriesHeader, 1, 0);
	     grid.add(heartRateHeader, 2, 0);
	     
	     grid.add(firstActivity, 0, 1);
	     grid.add(firstCal, 1, 1);
	     grid.add(firstHeartRate, 2, 1);
	     
	     grid.add(secondActivity, 0, 2);
	     grid.add(secondCal, 1, 2);
	     grid.add(secondHeartRate, 2, 2);
	     
	     grid.add(thirdActivity, 0, 3);
	     grid.add(thirdCal, 1, 3);
	     grid.add(thirdHeartRate, 2, 3);
	     
	     grid.add(fourthActivity, 0, 4);
	     grid.add(fourthCal, 1, 4);
	     grid.add(fourthHeartRate, 2, 4);
	     
	     grid.add(backButton, 3, 5);
	     //was there a more efficient way to add children to grid?
	     // I copied the way the TA did it in the video that was posted on piazza
	     
	     Scene scene = new Scene(grid, 550, 250);
	     sortingWindow.setScene(scene);
	     sortingWindow.showAndWait();
	     
	     
	     
		
	}

}
