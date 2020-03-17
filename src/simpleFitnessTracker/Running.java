package simpleFitnessTracker;

public class Running extends Activity {
	public Running() {
		super();
	}

	{
		setCaloriesBurntPerMinute(5);
		setHeartRateIncreasePerMinute(0.003);
	}
	@Override
	public String toString() {
		return "Running";
	}

}
