package simpleFitnessTracker;

public class StrengthTraining extends Activity {
	public StrengthTraining() {
		super();
	}

	{
		setCaloriesBurntPerMinute(5);
		setHeartRateIncreasePerMinute(0.006);
	}
	@Override
	public String toString() {
		return "Strength Training";
	}

}
