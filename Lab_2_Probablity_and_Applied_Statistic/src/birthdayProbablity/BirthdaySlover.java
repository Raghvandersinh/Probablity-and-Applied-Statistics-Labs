package birthdayProbablity;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 * @author Raghvandersinh Solanki
 * shows us the chances of a person sharing the same birthday with 
 * another person in a room. 
 *
 */
public class BirthdaySlover {

	/**
	 * Creates a list of peoples birthday
	 * @param population: amount of people we are comparing 
	 * @return returns a list of peoples birthday;
	 */
	private ArrayList<Person> listOfPeoplesBirthday(int population)
	{
		ArrayList<Person> listOfPeoplesBirthday = new ArrayList<Person>();
		Random randomMonthsAndDays = new Random();
		int month;
		int day;
		
		for(int i = 0; i < population; i++)
		{
			month = randomMonthsAndDays.nextInt(12)+1;
			if(month == 2)
			{
				day = randomMonthsAndDays.nextInt(28)+1;
			}
			if(month%2 == 0)
			{
				day = randomMonthsAndDays.nextInt(30)+1;
			}
			else
			{
				day = randomMonthsAndDays.nextInt(31)+1;
			}
			Person person = new Person(month, day);
			listOfPeoplesBirthday.add(person);
		}
		return listOfPeoplesBirthday;	
	}
	/**
	 * Checks if there are people with the same birthday in the list
	 * @param listOfPeoplesBirthday list of peoples birthday
	 * @return return true if one person shares a birthday with someone in the list.
	 */
	private boolean sameBirthdays(ArrayList<Person> listOfPeoplesBirthday)
	{
		boolean doesSomeoneHaveTheSameBirthday = false;
		
		for(int i = 0; i < listOfPeoplesBirthday.size(); i++)
		{
			for(int j = i+1; j < listOfPeoplesBirthday.size(); j++)
			{
				int personOneDay = listOfPeoplesBirthday.get(i).getDay();
				int personOneMonth = listOfPeoplesBirthday.get(i).getMonth();
				int personTwoDay = listOfPeoplesBirthday.get(j).getDay();
				int personTwoMonth = listOfPeoplesBirthday.get(j).getMonth();
				if((personOneDay == personTwoDay) && (personOneMonth == personTwoMonth))
				{
					 doesSomeoneHaveTheSameBirthday = true;
				}
			}
		}
		return doesSomeoneHaveTheSameBirthday;
	}
	/**
	 * shows us the probability that at least one person in the room share the same 
	 * birthday in the list.
	 * @return returns a percentage of chance that a person will share a birthday 
	 * with another.
	 */
	public double probablityOfSameBirthdays()
	{
		double countSameBirthdays = 0;
		double percentage = 0.0;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter amount of times you want to re-populate the room.");
		int runs = scan.nextInt();
		System.out.println("Enter the population of people in the room.");
		int population = scan.nextInt();
		
		
		for(int i = 0;  i < runs; i++)
		{
			ArrayList<Person> birthdayList = listOfPeoplesBirthday(population); 
			if(sameBirthdays(birthdayList) == true)
			{
				countSameBirthdays++;
			}
		}
		
		percentage = (countSameBirthdays/runs) * 100;
		return percentage;
	}
}
