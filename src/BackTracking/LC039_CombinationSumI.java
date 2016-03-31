package BackTracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class LC039_CombinationSumI {

	public static void main(String[] args) {

		int[] candidates = { 2, 3, 5, 7};
		int target = 7;
		
		List<List<Integer>> combinations = combinationSum(candidates , target);
		
		for(List<Integer> l : combinations)
		{
			System.out.println(l);
		}
		
	}

	private static List<List<Integer>> combinationSum(int[] candidates, int target) {

		Arrays.sort(candidates);
		
		List<List<Integer>> combinations = new ArrayList<List<Integer>>();
		
		List<Integer> currSum = new ArrayList<Integer>();
		
		combinationSumUtil(candidates, target, combinations, currSum, 0);
		
		return combinations;
	}

	private static void combinationSumUtil(int[] candidates, int target,
			List<List<Integer>> combinations, List<Integer> currSum, int startIndex) {

		if(target == 0)
		{
			combinations.add(currSum);
			return;
		}
		
		for(int i = startIndex; i < candidates.length; i++)
		{
			int newTarget = target - candidates[i];
			
			if(newTarget >= 0)
			{
				List<Integer> copy = new ArrayList<Integer>(currSum);
	            copy.add(candidates[i]);
	            
	            combinationSumUtil(candidates, target - candidates[i], combinations, copy, i);
	            
			}
			else
			{
				break;
			}
		}
		
	}

}
