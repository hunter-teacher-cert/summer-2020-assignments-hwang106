import java.io.*;
import java.util.*;


public class Time{
	//these are private instance variables to prevent them from being accessed outside of the Time class.
	//called instance variables since each instance has its own variables (as opposed to class variables, which are static/constant throughout)
	//this is a form of information hiding to simplify the use of this class by other programmers.
	private int hour; 
	private int minute;
	private double second;
	
	//constructor that initializes the instance variables to 0
    public Time() {
		this.hour = 0;
		this.minute = 0;
		this.second = 0.0;
	}
	
	//value constructor that copyies values from the parameters to the instance variables 
	public Time(int hour, int minute, double second){
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	//"accessor" or "getter"  methods
	public int getHour() {
		return this.hour;
	}
	
	public int getMinute() {
		return this.minute;
	}
	
	public double getSecond() {
		return this.second;
	}
	
	//"mutator" or "setter" methods
	public void setHour(int hour) {
		this.hour = hour;
	}
	
	public void setMinute(int minute) {
		this.minute = minute;
	}
	
	public void setSecond(double second) {
		this.second = second;
	}
	
	//static method to print the time
	public static void printTime(Time t) {
		String ampm;
		int hour;
		
		if (t.hour >= 12) {
			ampm = "PM";
		}
		else {
			ampm = "AM";
		}
		
		if (t.hour > 12) {
			hour = t.hour - 12;
		}
		else {
			hour = t.hour;
		}
		
		System.out.printf("%02d:%02d:%04.1f %S\n", hour, t.minute, t.second, ampm);
	}
	
	//instance method (depends on instance of class Time; uses this. to refer to that instance) to print time by overriding the default toString method
	public String toString() {
		
		String ampm;
		int hour;
		
		if (this.hour >= 12) {
			ampm = "PM";
		}
		else {
			ampm = "AM";
		}
		
		if (this.hour > 12) {
			hour = this.hour - 12;
		}
		else {
			hour = this.hour;
		}		
		return String.format("%02d:%02d:%04.1f %S", hour, this.minute, this.second, ampm);
	}
	
	//equals method that checks for equivalence instead of an identical reference (==); overwrites existing, inherited equals method that actually tests for identical references as well?
	public boolean equals(Time that) {
		return this.hour == that.hour && this.minute == that.minute && this.second == that.second;
	}
	
	//method to add time to existing time (this is known as a pure method, since it doesn't modify the original objects, creating a new one instead; this can be less efficient but also less prone to bugs)
	public Time add(Time t2){
		Time sum = new Time(); //initializes new Time variable set at 0h0m0s
		sum.hour = this.hour + t2.hour;
		sum.minute = this.minute + t2.minute;
		sum.second = this.second + t2.second;
		
		//for cases where the seconds or minutes sum past 60
		
		if (sum.second >= 60) {
			sum.second -= 60;
			sum.minute += 1;
		}
		
		if (sum.minute >= 60) {
			sum.minute -= 60;
			sum.hour += 1;
		}
		
		return sum;
	}
	
	//method to add a number of minutes to an instance of time
	public void addMinutes(int min) {
		this.minute += min;
	}
	
	//method that returns the number of seconds between the original time and other
	public double differencesec(Time other) {
		
		
		double diff = this.second - other.second;
		
		if (diff < 0) {
			diff = -diff;
		}
		
		return diff;
	}
	
	public Time difference(Time other) {
		
		Time timeElapsed = new Time();
		
		if (this.hour < other.hour || (this.hour == other.hour && this.minute < other.minute) || (this.hour == other.hour && this.minute == other.minute && this.second < other.second)) {
				
			timeElapsed.second = other.second - this.second;
			timeElapsed.minute = other.minute - this.minute;
			timeElapsed.hour = other.hour - this.hour;
		}
		
		else {
			timeElapsed.second = this.second - other.second;
			timeElapsed.minute = this.minute - other.minute;
			timeElapsed.hour = this.hour - other.hour;
		}
		
		if (timeElapsed.second < 0) {
			timeElapsed.second += 60.0;
			timeElapsed.minute--;
		}
		
		if (timeElapsed.minute < 0) {
			timeElapsed.minute += 60;
			timeElapsed.hour--;
		}
		
		return timeElapsed;
		
	}
}