package statsLibraryAndSetOperations;
import java.util.ArrayList;
import java.lang.Math;
import java.math.BigInteger;
import java.math.BigDecimal;
/**
 * 
 * @author Raghvandersinh Solanki
 *	Contains methods that finds mean, median mode, standard deviation, permutation,
 *	Combinations, Factorial, and Binomial distribution
 */

public class StatsLibrary {

	/**
	 * Sorts an ArrayList
	 * @param numberList- ArrayList to be sorted
	 */
	public void sort(ArrayList<Double> numberList) {
		double temp = 0;
		for (int i = 0; i < numberList.size(); i++) {
			for (int j = 0; j < numberList.size(); j++) {
				if (numberList.get(i) < numberList.get(j)) {
					temp = numberList.get(i);
					numberList.set(i, numberList.get(j));
					numberList.set(j, temp);
				}
			}
		}
	}
	
	/**
	 * Finds the mean of an ArrayList.
	 * @param numberList = ArrayList of Double
	 * @return returns the mean of the ArrayList
	 */

	public double mean(ArrayList<Double> numberList) {

		int mean = 0;
		int total = 0;
		for (double n : numberList) {
			total += n;
		}

		mean = total / numberList.size();
		return mean;
	}
	
	/**
	 * Finds the median in the ArrayList
	 * @param numberList ArrayList of Double
	 * @return returns the median of the ArrayList.
	 */

	public double median(ArrayList<Double> numberList) {
		double median = 0;
		int middle = numberList.size() / 2;
		if (numberList.size() % 2 != 0) {

			median = numberList.get(middle);
		} else {
			median = (numberList.get(middle) + numberList.get(middle - 1)) / 2;
		}
		return median;
	}

	/**
	 * Finds the mode in the ArrayList (Note: there can be only be one mode)
	 * @param numberList -  ArrayList of Double
	 */
	public void mode(ArrayList<Double> numberList) {
		double mode = 0;
		int maxCount = 0;
		int modeCountFail = 0;
		//Finds the mode 
		for (int i = 0; i < numberList.size(); i++) {
			int count = 0;

			for (int j = 0; j < numberList.size(); j++) {
				double elementI = numberList.get(i);
				double elementJ = numberList.get(j);
				if (elementI == elementJ) {
					count++;
				}
			}
			if (count > maxCount) {
				maxCount = count;
				mode = numberList.get(i);
			}

			count = 0;
		}
		//Finds the another mode. Since we can only have one Mode
		for (int i = 0; i < numberList.size(); i++) {

			int count = 0;

			for (int j = 0; j < numberList.size(); j++) {
				double elementI = numberList.get(i);
				double elementJ = numberList.get(j);
				if(elementI == mode)
				{
				      count = 0;
				}
				else if (elementI == elementJ) {
					count++;
				}
			}
			if (count > modeCountFail) {
				modeCountFail = count;
			}
			count = 0;
		}
		if (modeCountFail == maxCount) {
			System.out.println("No Mode");

		} else {
			System.out.println("Mode: " + mode);
		}

	}
	/**
	 * Finds the Standard Deviation of the ArrayList.
	 * @param numberList ArrayList of Double.
	 * @return returns the Standard Deviation of the ArrayList.
	 */
	public double statdardDeviation(ArrayList<Double> numberList) {
		double stnDeviation;
		double mean = mean(numberList);
		ArrayList<Double> temp = new ArrayList<>();
		for (double n : numberList) {
			double newMean = Math.pow(n - 50, 2);
			temp.add(newMean);
		}
		int sumNewMean = 0;
		for (double t : temp) {
			sumNewMean += t;
		}
		double variance = sumNewMean / (temp.size() - 1);
		stnDeviation = Math.sqrt(variance);
		return stnDeviation;
	}
	/**
	 * gets a permutation number
	 * @param sampleSpace: enter a sample space.
	 * @param options: enter number of object selected.
	 */
	public BigInteger getPermutation(int sampleSpace, int objectSelected)
	{
		BigInteger r = getFactorial(sampleSpace - objectSelected);
		BigInteger permutation = getFactorial(sampleSpace).divide(r);
		return permutation;
	}
	/**
	 * gets a combination number
	 * @param sampleSpace: enter a sample space.
	 * @param options: enter number of object selected.
	 */
	public BigInteger getCombination(int sampleSpace, int options)
	{
		BigInteger r = getFactorial(sampleSpace - options);
		BigInteger combination = getFactorial(sampleSpace).divide((r.multiply(getFactorial(options))));		
		return combination;
	}
	/**
	 * gets a factorial number.
	 * @param input1: enter a number that you want to get factorial of
	 * Citation:
	 * I was lost on how to loop through a BigInteger, but I simply had to reassign the
	 * factorial variable to a new value. 
	 * https://www.youtube.com/watch?v=UD8rCe_QVOE
	 */
	public BigInteger getFactorial(int input1)
	{
		BigInteger factorial = BigInteger.ONE;
		
		for(int i = 1; i <= input1; i++)
		{
			long iToLong = i;
			BigInteger iValue = BigInteger.valueOf(iToLong);
			factorial = factorial.multiply(iValue);
		}
		return factorial;
	}
	/**
	 * gets a binomial distribution number
	 * @param sampleSpace: enter the sample space
	 * @param success: probability of success
	 * @param failure: probability of failure
	 * @param option: enter the number of object selected
	 * I didn't know how to turn a BigInteger into a double, I searched it up and found that
	 * I can use BigDecimal from stackOverflow.
	 * https://stackoverflow.com/questions/13105905/is-it-possible-to-multiple-a-biginteger-by-a-double-in-java
	 */
	public BigDecimal getBinomialDistribution(int sampleSpace,double success, double failure, int option)
	{
		BigDecimal combination = new BigDecimal(getCombination(sampleSpace, option));
		double variableSuccess = Math.pow(success, option);
		double variableFailure = Math.pow(failure, sampleSpace - option);
		combination = combination.multiply(new BigDecimal(variableSuccess));
		combination = combination.multiply(new BigDecimal(variableFailure));
		return combination;
		
	}

}
