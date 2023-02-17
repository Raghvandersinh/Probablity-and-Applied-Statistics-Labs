package birthdayProbablity;
import java.util.ArrayList;
import statsLibraryAndSetOperations.SetOperation;
import java.util.Random;

public class Person {

	private int month;
	private int day;
	
	public Person(int inputMonth, int inputDay)
	{
		month = inputMonth;
		day = inputDay;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
	public String toString()
	{
		return "Month: " + month + " Day: " + day;
	}
	
}
