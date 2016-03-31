package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class LC046_PermutationsDistinctElements {

	public static void main(String[] args) {

		int[] A = { 1, 2, 3};
		
		List<List<Integer>> permutations = permutationsDistinctElements(A);
 		
		for(List<Integer> p : permutations)
		{
			System.out.println(p);
		}
	}

	private static List<List<Integer>> permutationsDistinctElements(int[] A) {

		List<List<Integer>> permutations = new ArrayList<List<Integer>>();
		
		if(A.length == 0)
		{
			return permutations;
		}
		
		List<Integer> firstNum = new ArrayList<Integer>();		
		firstNum.add(A[0]);
		
		permutations.add(firstNum);
		
		for(int i = 1; i < A.length; i++)
		{
			// to avoid concurrent modification
			List<List<Integer>> temp = new ArrayList<List<Integer>>();
			
			for(int j=0; j <= i; j++)
			{
				for(List<Integer> p : permutations)
				{
					List<Integer> newList = new ArrayList<>(p);
					newList.add(j, A[i]);
					temp.add(newList);
				}
			}
			
			permutations = temp;
		}
		
		return permutations;
	}

}
