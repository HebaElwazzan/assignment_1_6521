package simpleFitnessTracker;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;



public class Main extends Application{
	
	List<Activity> activitiesList = new ArrayList<>();
	Swimming swimmingActivity = new Swimming();
	Running runningActivity = new Running();
	KickBoxing kickBoxingActivity = new KickBoxing();
	StrengthTraining strengthTrainingActivity = new StrengthTraining();
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		activitiesList.add(swimmingActivity);
		activitiesList.add(runningActivity);
		activitiesList.add(kickBoxingActivity);
		activitiesList.add(strengthTrainingActivity);
		
		DecimalFormat df = new DecimalFormat("#.###");
		
		//Creating the start screen using the grid layout
		primaryStage.setTitle("Fitness Tracker");
		Label caloriesBurntHeaderLabel = new Label("Calories burnt  ");
		Label heartRateHeaderLabel = new Label("Heart Rate  ");
		Label caloriesBurntLabel = new Label("0");
		Label heartRateLabel = new Label("80");
		Label beatsPerMin = new Label("\tbeats/minute");
		Label choiceLabel = new Label("Choose an activity  ");
		ChoiceBox<String> activitiesChoiceBox= new ChoiceBox<>();
		activitiesChoiceBox.getItems().addAll("Activity", "Swimming", "Running", "Kick Boxing", "Strength Training");
		activitiesChoiceBox.setValue("Activity");
		Label timeLabel = new Label("Time taken");
		TextField timeText = new TextField();
		Label minutes = new Label("\tminutes");
		Label notification = new Label();
		Button addButton = new Button("Add");
		Button sortButton = new Button("View Ranking");
		Button exitButton = new Button("Exit");
		
		GridPane grid = new GridPane();
		
		grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        
		grid.add(caloriesBurntHeaderLabel, 0, 0);
		grid.add(heartRateHeaderLabel, 0, 1);
		grid.add(choiceLabel, 0, 3);
		grid.add(timeLabel, 0, 4);
		grid.add(notification, 0, 7);
		
		grid.add(caloriesBurntLabel, 1, 0);
		grid.add(heartRateLabel, 1, 1);
		grid.add(beatsPerMin, 2, 1);
		grid.add(activitiesChoiceBox, 1, 3);
		grid.add(timeText, 1, 4);
		grid.add(minutes, 2, 4);
		grid.add(addButton, 1, 5);
		grid.add(sortButton, 1, 5);
		grid.add(exitButton, 2, 8);
		
		GridPane.setHalignment(caloriesBurntLabel, HPos.CENTER);
		GridPane.setHalignment(heartRateLabel, HPos.CENTER);
		GridPane.setHalignment(sortButton, HPos.RIGHT);
		GridPane.setHalignment(exitButton, HPos.CENTER);

		grid.getColumnConstraints().add(new ColumnConstraints(200));
		
		//Code to calculate new values whenever user adds an activity
		addButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				try {
					int time = Integer.parseInt(timeText.getText());
					if (time <= 0) {
						throw new NumberFormatException();
					} else {
						String activityChoice = activitiesChoiceBox.getValue();
						int caloriesBurnt = Integer.parseInt(caloriesBurntLabel.getText());
						double heartRate = Double.parseDouble(heartRateLabel.getText());
						
						if (activityChoice.equals("Activity")) {
							notification.setText("Please choose an activity");
							notification.setTextFill(Color.web("#ff0000", 0.8));
							
						} else {
							if (activityChoice.equals("Swimming")) {
							swimmingActivity.setTime(time);
							caloriesBurnt += swimmingActivity.calcCaloriesBurnt(caloriesBurnt);
							heartRate += swimmingActivity.calcHeartRate(heartRate);
							
						} else if (activityChoice.equals("Running")) {
							runningActivity.setTime(time);
							caloriesBurnt += runningActivity.calcCaloriesBurnt(caloriesBurnt);
							heartRate += runningActivity.calcHeartRate(heartRate);
							
						} else if (activityChoice.equals("Kick Boxing")) {
							kickBoxingActivity.setTime(time);
							caloriesBurnt += kickBoxingActivity.calcCaloriesBurnt(caloriesBurnt);
							heartRate += kickBoxingActivity.calcHeartRate(heartRate);

							
						} else if (activityChoice.equals("Strength Training")) {
							strengthTrainingActivity.setTime(time);
							caloriesBurnt += strengthTrainingActivity.calcCaloriesBurnt(caloriesBurnt);
							heartRate += strengthTrainingActivity.calcHeartRate(heartRate);

						}
						caloriesBurntLabel.setText(Integer.toString(caloriesBurnt));
						heartRateLabel.setText(df.format(heartRate));
						notification.setText("Activity added successfully");
						notification.setTextFill(Color.web("#008000", 0.8));
						
						}
						
					}
				} catch(NumberFormatException e){
					notification.setText("Invalid time");
					notification.setTextFill(Color.web("#ff0000", 0.8));
				
				}
				
			}
		});
		
		sortButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				SortingStage.display(activitiesList);
				
			}
		});
		

		exitButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				primaryStage.close();
				
			}
		});
		
		Scene scene = new Scene(grid, 600, 400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
