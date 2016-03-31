package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class LC077_Combinations {

	public static void main(String[] args) {

		
		int n = 4;
		int k = 2;
		
		List<List<Integer>> combinations = getCombinations(n,k);
		
		for(List<Integer> l : combinations)
		{
			System.out.println(l);
		}
		
	}

	private static List<List<Integer>> getCombinations(int n, int k) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		if(n <=0 || k <=0 || k > n)
		{
			return result;
		}
		
		List<Integer> list = new ArrayList<Integer>();
		
		combinationsUtil(1, n, k, list, result);
		
		return result;
	}

	private static void combinationsUtil(int start, int n, int k,
			List<Integer> list, List<List<Integer>> result) {

		if(k == 0)
		{
			result.add(new ArrayList<Integer>(list));
			return;
		}
		
		for(int i = start; i <= n ; i++)
		{
			list.add(i);
			combinationsUtil(i+1, n, k-1, list, result);
			list.remove(list.size()-1);
		}
		
		
	}

}
