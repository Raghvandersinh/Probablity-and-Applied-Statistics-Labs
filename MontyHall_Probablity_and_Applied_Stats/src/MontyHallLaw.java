import java.util.ArrayList;
import java.util.Random;

/**
 * 
 * @author Raghvandersinh Solanki
 * Checks if the MontyHall Law holds true or not.
 */
public class MontyHallLaw {

	/**
	 * Picks one of the 3 doors
	 * @param doors: 1,2,and 3.
	 * @return returns a picked door.
	 */
	public int pickDoor(ArrayList<Integer> doors)
	{
		Random random = new Random();
		int pickedDoor = random.nextInt(doors.size());
		return pickedDoor;
	}
	
	/**
	 * Which door has the prize
	 * @param doors: 1,2,and 3
	 * @return returns the prize door.
	 */
	public int prizeDoor(ArrayList<Integer> doors)
	{
		Random random = new Random();
		int rightDoor = random.nextInt(doors.size());
		return rightDoor;
	}
	
	/**
	 * The wrong door the host opens.
	 * @param doors: 1,2 and 3
	 * @return returns the door the host opens.
	 */
	public int hostDoor(ArrayList<Integer> doors)
	{
		Random random = new Random();
		int hostDoor = random.nextInt(doors.size());
		if(hostDoor == pickDoor(doors) || hostDoor == prizeDoor(doors))
		{
			hostDoor = random.nextInt(doors.size());
		}
		return hostDoor;
	}
	/**
	 * Counts how many times we win, if we don't change the doors
	 * @return returns the count of wins
	 */
	public int notSwitiching()
	{
		ArrayList<Integer> doors = new ArrayList<Integer>();
		doors.add(1);
		doors.add(2);
		doors.add(3);
		
		int pickedDoor;
		int rightDoor;
		int hostGuessDoor;
		int noSwitchCounter = 0;
		
		for(int i = 0; i < 10000; i++)
		{
			pickedDoor = pickDoor(doors);
			rightDoor = prizeDoor(doors);
			hostGuessDoor = hostDoor(doors);
			
			if(doors.get(rightDoor) == doors.get(pickedDoor))
			{
				noSwitchCounter++;
			}
		}
		return noSwitchCounter;
	}
	/**
	 * Counts how many times we win, if we switch doors.
	 * @return returns the count of wins
	 */
	public int switchingDoors()
	{
		ArrayList<Integer> doors = new ArrayList<Integer>();
		doors.add(1);
		doors.add(2);
		doors.add(3);
		
		int pickedDoor;
		int rightDoor;
		int hostGuessDoor;
		int switchCounter = 0;
		
		for(int i = 0; i < 10000; i++)
		{
			pickedDoor = pickDoor(doors);
			rightDoor = prizeDoor(doors);
			hostGuessDoor = hostDoor(doors);
			
			if(doors.get(rightDoor) != doors.get(pickedDoor))
			{
				switchCounter++;
			}
		}
		return switchCounter;
	}

	/**
	 * Describes the result
	 */
	public void description()
	{
		double stickingWithTheDoor = notSwitiching();
		double switchTheDoor = switchingDoors();
		double percentageWithNotSwitchingDoors =  (stickingWithTheDoor/10000) * 100;
		double percentageWithSwitchingDoors = (switchTheDoor/10000) * 100;
		
		System.out.printf("Not Swithcing Doors succession rate: %.2f", percentageWithNotSwitchingDoors);
		System.out.print("%\n");
		System.out.printf("Switching Doors succession rate: %.2f", percentageWithSwitchingDoors);
		System.out.print("%\n\n");
		System.out.println("Should you Switch or Not Switch?");
		
		if(percentageWithNotSwitchingDoors < percentageWithSwitchingDoors)
		{
			System.out.println("Yes, you should switch doors.");
		}
		else
		{
			System.out.println("Do not switch doors.");
		}
	}
}
