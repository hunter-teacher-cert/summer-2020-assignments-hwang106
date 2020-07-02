import java.io.*;
import java.util.*;

public class Driver{
    public static void main(String[] args) {
	Time t = new Time(11, 59, 59.9);
	System.out.println(t.getMinute());
	System.out.println(t.getHour()+t.getMinute());
	Time.printTime(t);
	System.out.println(t);
	Time t2 = t;
	Time t3 = new Time(11, 59, 59.9);
	System.out.println(t == t2);
	System.out.println(t.equals(t2));
	System.out.println(t == t3);
	System.out.println(t.equals(t3));
	Time t4 = new Time(4, 3, 32.2);
	System.out.println(t.add(t4));
    }


}