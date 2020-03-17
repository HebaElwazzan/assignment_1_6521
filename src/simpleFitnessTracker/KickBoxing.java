package simpleFitnessTracker;

public class KickBoxing extends Activity {
	public KickBoxing() {
		super();
	}

	{
		setCaloriesBurntPerMinute(3);
		setHeartRateIncreasePerMinute(0.005);
	}
	@Override
	public String toString() {
		return "Kick Boxing";
	}

}
