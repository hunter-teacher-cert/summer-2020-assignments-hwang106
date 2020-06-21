
public class Time{
	
	public static void main(String[] args){
		double hour = 18.0;
		double min = 2.0;
		double second = 30.0;
		double secSinceMidnight = hour * 60.0*60.0 + min * 60.0 + second;
		double secUntilMidnight = 24.0 * 60.0*60.0 - secSinceMidnight;
		double percentDay = secSinceMidnight/(24.0 * 60.0*60.0)*100;
		hour = 18.0;
		min = 11.0;
		second = 30.0;
		double timeElapsed = (hour * 60.0*60.0 + min * 60.0 + second) - secSinceMidnight;
		System.out.println("This is how many seconds have passed since midnight: " + secSinceMidnight);
		System.out.println("This is how many seconds are left until midnight: " + secUntilMidnight);
		System.out.println("This is the percent of the day that has elapsed: " + percentDay + "%");
		System.out.println("This is how many seconds have passed since I began the assignment: " + timeElapsed);
	}
	
}