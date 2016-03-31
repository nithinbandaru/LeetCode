package BackTracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class LC078_SubSetDistinctElements {

	// Time complexity = O(2^n)
	public static void main(String[] args) {

		int[] A = {2,1,2};
		
		List<List<Integer>> subsets = generateSubsets(A);
		
		for(List<Integer> subset : subsets)
		{
			System.out.println(subset);
		}				
	}

	private static List<List<Integer>> generateSubsets(int[] A) {

		List<List<Integer>> subsets = new ArrayList<List<Integer>>();
		
		subsets.add(new ArrayList<Integer>());
		
		Arrays.sort(A);
		
		for(int i : A)
		{
			// saves from concurrent modification exception
			List<List<Integer>> tempSubsets = new ArrayList<List<Integer>>();
			
			for(List<Integer> subset : subsets)
			{
				List<Integer> newSubset = new ArrayList<Integer>(subset);
				newSubset.add(i);
				tempSubsets.add(newSubset);
			}
			
			subsets.addAll(tempSubsets);			
		}		
		
		return subsets;
	}

}
