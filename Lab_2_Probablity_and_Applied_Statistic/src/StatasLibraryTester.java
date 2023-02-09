import java.util.ArrayList;

public class StatasLibraryTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StatsLibrary test = new StatsLibrary();
		ArrayList<Double> someNumbers = new ArrayList<>();
		someNumbers.add(46.0);
		someNumbers.add(69.0);
		someNumbers.add(52.0);
		someNumbers.add(32.0);
		someNumbers.add(41.0);
		someNumbers.add(60.0);
		
		
		test.sort(someNumbers);
		double mean = test.mean(someNumbers);
		double standardDeviation = test.statdardDeviation(someNumbers);
		double median = test.median(someNumbers);
		
		
		System.out.println("Mean: " + mean);
		System.out.println("Median: " + median);
		test.mode(someNumbers);
		System.out.println("Standard Deviation: " + standardDeviation);
		double perma = test.getPermutation(50, 3);
		double comba = test.getCombination(8, 4);
		System.out.printf("Permutation: %.1f\n", perma);
		System.out.printf("Combination: %.1f\n",  comba);
		System.out.printf("Factorial: %.1f\n", test.getFactorial(54));
		
	}

}
