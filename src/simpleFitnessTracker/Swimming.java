package simpleFitnessTracker;

public class Swimming extends Activity {
	public Swimming() {
		super();
	}
	//initializer to set the values of calories burnt per minute and heart rate increase per minute
	//for each kind of activity
	{
		setCaloriesBurntPerMinute(4);
		setHeartRateIncreasePerMinute(0.002);
	}
	@Override
	public String toString() {
		return "Swimming"; //this is for easier printing
	}

}
