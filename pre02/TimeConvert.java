import java.util.Scanner;

public class TimeConvert{
	
	public static void main(String[] args){
		int seconds;
		int hours;
		int minutes;
		int remSeconds;
		final int secondsPerHour = 3600;
		final int secondsPerMinute = 60;
		
		System.out.print("How many seconds? ");
		Scanner in = new Scanner(System.in);		
		seconds = in.nextInt();
		hours = seconds / secondsPerHour;
		minutes = (seconds % secondsPerHour) / secondsPerMinute;
		remSeconds = (seconds % secondsPerHour) % secondsPerMinute;
		
		System.out.print(seconds + " seconds = " + hours + " hours, " + minutes + " minutes, and " + remSeconds + " seconds.");
		
	}
	
}