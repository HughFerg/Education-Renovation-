package Perceptrons;

import java.util.ArrayList;
import java.util.Scanner;

public class BasicPerceptrons {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		ArrayList<Perceptron> set = new ArrayList<Perceptron>();
		double numericalValue = 0;
		double total = 0;
		double threshold = 0;
		
		System.out.println("Should you go out right now?");
		System.out.println("---------------------------");
		
		System.out.println("Well, how is the weather? (Good, ok, or bad)");
		String value = in.nextLine();
		if (value.equals("good")) numericalValue = 2.0;
		if (value.equals("ok")) numericalValue = 1.0;
		if (value.equals("bad"))  numericalValue = 0;		
		
		Perceptron weather = new Perceptron("Weather", -2, numericalValue);
		set.add(weather);
		
		System.out.println("How much schoolwork do you have? (A lot, some, a little or none)");
		value = in.nextLine();
		if (value.equals("a lot")) numericalValue = 2.0;
		if (value.equals("some")) numericalValue = 1.0;
		if (value.equals("a little"))  numericalValue = 0.5;
		if (value.equals("none")) numericalValue = 0;
		
		Perceptron work = new Perceptron("Work", 3.5, numericalValue);
		set.add(work);
		
		System.out.println("How much activity of value have you done today? (A lot, some, a little or none)");
		value = in.nextLine();
		if (value.equals("a lot")) numericalValue = 1.5;
		if (value.equals("some")) numericalValue = 1.0;
		if (value.equals("a little")) numericalValue = .5;
		if (value.equals("none")) numericalValue = 0;
		
		Perceptron activity = new Perceptron("Activity", -4, numericalValue);
		set.add(activity);
		
		System.out.println("Did you go out yesterday?");
		value = in.nextLine();
		if (value.equals("yes")) numericalValue = 1.0;
		if (value.equals("no")) numericalValue = 0;
		
		Perceptron yesterdayActivity = new Perceptron("YesterdayActivity", 3, numericalValue);
		set.add(yesterdayActivity);
		
		System.out.println("Is today a weekday?");
		value = in.nextLine();
		if (value.equals("yes")) numericalValue = 1.0;
		if (value.equals("no")) numericalValue = 0;
		
		Perceptron weekday = new Perceptron("Weekday", 1.5, numericalValue);
		set.add(weekday);
		
		for (int s = 0; s < set.size(); s++)
		{
			total += (set.get(s).value * set.get(s).weight);
		}
		
		if (total >= threshold) System.out.println("You probably shouldn't go out, but what do I know");
		else System.out.println("You should be fine to go out");
		System.out.println("Total = " + total);
		
		
	}
}
