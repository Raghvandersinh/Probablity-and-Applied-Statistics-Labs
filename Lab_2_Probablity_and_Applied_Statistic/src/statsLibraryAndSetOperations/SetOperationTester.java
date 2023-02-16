package statsLibraryAndSetOperations;
import java.util.ArrayList;
public class SetOperationTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SetOperation op = new SetOperation();
		
		ArrayList<String> daysInAWeek = new ArrayList<String>();
		daysInAWeek.add("Monday");
		daysInAWeek.add("Tuesday");
		daysInAWeek.add("Wednesday");
		daysInAWeek.add("Thursday");
		daysInAWeek.add("Friday");
		daysInAWeek.add("Saturday");
		daysInAWeek.add("Sunday");
		ArrayList<String> subSetA = new ArrayList<String>();
		subSetA.add("Monday");
		subSetA.add("Tuesday");
		subSetA.add("Wednesday");
		subSetA.add("Sunday");
		subSetA.add("Sunday");
		
		ArrayList<String> subSetB = new ArrayList<String>();
		subSetB.add("Thursday");
		subSetB.add("Saturday");
		subSetB.add("Sunday");
		
		
		ArrayList<String> intersection = op.intersection(subSetA, subSetB);
		System.out.println("Intersection in Set A and Set B: ");
		for(String it:intersection)
		{
			System.out.print(it + " ");
		}
		
		System.out.println("\n\nUnion in Set A and Set B:");
		ArrayList<String> union = op.union(subSetA, subSetB);
		for(String u:union)
		{
			System.out.print(u + " ");
		}
		
		System.out.println("\n\nComplement in Set A: ");
		ArrayList<String>complementsetA = op.complement(daysInAWeek, subSetA);
		for(String c:complementsetA)
		{
			System.out.print(c + " ");
		}
		
		System.out.println("\n\nComplement in Set B: ");
		ArrayList<String> complementsetB = op.complement(daysInAWeek, subSetB);
		for(String c:complementsetB)
		{
			System.out.print(c + " ");
		}
		//System.out.println("\nIntersection Test " + op.intersectionTest(subSetA, subSetB));
		System.out.println("\nUnion " + op.union(subSetA, subSetB));
		System.out.println("\nComplement " + op.complement(subSetA, subSetB));
		System.out.println("\nIntersection " + op.intersection(subSetA, subSetB));
		
		
		
	}

}
