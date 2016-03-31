package BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC047_PermutationsDuplicateElements {

	public static void main(String[] args) {

		int[] A = {1,2,1};
		
		List<List<Integer>> permutations = permutationGenerator(A);
		
		for(List<Integer> l : permutations)
		{
			System.out.println(l);
		}
		
	}

	private static List<List<Integer>> permutationGenerator(int[] A) {
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i : A)
		{
			map.put(i, map.containsKey(i) ? map.get(i) + 1 : 1);
		}
		
		List<List<Integer>> permutations = new ArrayList<List<Integer>>();
		
		Integer[] permutation = new Integer[A.length];
		
		permuteUtil(map, permutation, permutations, 0);
		
		return permutations;
	}

	private static void permuteUtil(Map<Integer, Integer> map,
			Integer[] permutation, List<List<Integer>> permutations, int startIndex) {

		if(startIndex == permutation.length)
		{
			List<Integer> perm = new ArrayList<Integer>();
			
			for(int k : permutation)
			{
				perm.add(k);
			}
			
			permutations.add(perm);
			return;
		}
		
		for(Integer num : map.keySet())
		{
			int countOfInteger =  map.get(num);
			
			if(countOfInteger > 0)
			{
				permutation[startIndex] = num;
				map.put(num, countOfInteger - 1);
				
				permuteUtil(map, permutation, permutations, startIndex + 1);
				
				// once call is done restore Map
				map.put(num, countOfInteger);
			}
		}
	}
}
