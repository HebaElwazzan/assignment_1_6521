package simpleFitnessTracker;
public abstract class Activity implements Comparable<Activity> { 
	//Fields 
	
	//fields for constant value for each activity class (set inside subclasses)
	private int caloriesBurntPerMinute; 
	private double heartRateIncreasePerMinute;
	
	//fields to record time and total calories burnt and heart rate increase due to one activity
	private int time;
	private int caloriesBurnt = 0;
	private double heartRateIncrease = 0;
	
	//Default constructor
	public Activity() {
		super();
	}
	
	//Setters and getters for fields
	public int getCaloriesBurntPerMinute() {
		return caloriesBurntPerMinute;
	}
	public void setCaloriesBurntPerMinute(int caloriesBurntPerMinute) {
		this.caloriesBurntPerMinute = caloriesBurntPerMinute;
	}
	
	
	public double getHeartRateIncreasePerMinute() {
		return heartRateIncreasePerMinute;
	}
	public void setHeartRateIncreasePerMinute(double heartRateIncreasePerMinute) {
		this.heartRateIncreasePerMinute = heartRateIncreasePerMinute;
	}
	
	
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	
	
	public int getCaloriesBurnt() {
		return caloriesBurnt;
	}
	public void setCaloriesBurnt(int caloriesBurnt) {
		this.caloriesBurnt = caloriesBurnt;
	}
	
	
	public double getHeartRateIncrease() {
		return heartRateIncrease;
	}
	public void setHeartRateIncrease(int heartRate) {
		this.heartRateIncrease = heartRate;
	}
	
	
	//Overriding Object class methods using Eclipse IDE
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + caloriesBurnt;
		long temp;
		temp = Double.doubleToLongBits(heartRateIncrease);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + time;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Activity other = (Activity) obj;
		if (caloriesBurnt != other.caloriesBurnt)
			return false;
		if (Double.doubleToLongBits(heartRateIncrease) != Double.doubleToLongBits(other.heartRateIncrease))
			return false;
		if (time != other.time)
			return false;
		return true;
	} //we don't really use .equals so maybe overriding it was unnecessary
	  //but it is good practice nonetheless (we don't use most of the getters and setters either)

	//Methods to calculate calories burnt and heart rate increase due to an activity in specified time
	public int calcCaloriesBurnt(int caloriesBurnt) {
		caloriesBurnt = time * caloriesBurntPerMinute;
		this.caloriesBurnt += caloriesBurnt;
		return caloriesBurnt;
	}
	public double calcHeartRate(double heartRate) {
		heartRate = (heartRate * time * heartRateIncreasePerMinute); //these values are added to the original inside the Main class
		this.heartRateIncrease += heartRate;
		return heartRate; 
	}
	//Overriding method from comparable interface to allow for sorting
	@Override
	public int compareTo(Activity activity) {
		if (this.caloriesBurnt < activity.caloriesBurnt)
			return 1;
		else if (this.caloriesBurnt > activity.caloriesBurnt)
			return -1;
		else if (this.heartRateIncrease < activity.heartRateIncrease)
			return 1;
		else if (this.heartRateIncrease > activity.heartRateIncrease)
			return -1;
		else return 0;
	}
}