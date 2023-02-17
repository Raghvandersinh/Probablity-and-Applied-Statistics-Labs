package statsLibraryAndSetOperations;
import java.util.ArrayList;
/**
 * 
 * @author Raghvandersinh Solanki
 *
 * @param <E>
 */
public class SetOperation<E> {
	
	/**
	 * Finds an intersection between two sub sets.
	 * @param setA - an ArrayList SetA
	 * @param setB - an ArrayList SetB
	 * @return an ArrayList that contains intersection of setA and setB
	 */
	public ArrayList<E> intersection(ArrayList<E> setA, ArrayList<E> setB)
	{
		ArrayList<E> intersectionList = new ArrayList<E>();
		
		for(int i = 0; i < setA.size(); i++)
		{
			for(int j = 0; j < setB.size(); j++)
			{
				System.out.println(setA.size());
				if(setA.get(i) == setB.get(j) && !(intersectionList.contains(setA.get(i))))
				{
					
					intersectionList.add(setA.get(i));
					
				}
			}
		}
		return intersectionList;
	}
	
	/**
	 * gets the union of two ArrayList
	 * @param setA -  ArrayList SetA
	 * @param setB - ArrayList SetB
	 * @return - an ArrayList that contains the union of SetA and SetB
	 */
	public ArrayList<E> union(ArrayList<E> setA, ArrayList<E> setB)
	{
		ArrayList<E> unionList = new ArrayList<E>();
		
		for(int i = 0; i < setA.size(); i++)
		{
			if(!(unionList.contains(setA.get(i))))
			{
				unionList.add(setA.get(i));
			}
		}
		for(int i = 0; i < setB.size(); i++)
		{
			if(!(unionList.contains(setB.get(i))))
			{
				unionList.add(setB.get(i));
			}
		}
		
		return unionList;
	}
	/**
	 * gets the complement of a set
	 * @param set - ArrayList Set
	 * @param subSet - ArrayList that is a subset of set
	 * @return an Arraylist that contains complement of subSet. 
	 */
	public ArrayList<E> complement(ArrayList<E> set, ArrayList<E> subSet)
	{
		ArrayList<E> complementList = new ArrayList<E>();
		
		for(E s:set)
		{
			complementList.add(s);
		}
		
		for(int i = 0; i < subSet.size(); i++)
		{
			complementList.remove(subSet.get(i));
		}
		return complementList;
	}
	
}
