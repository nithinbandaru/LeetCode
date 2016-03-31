package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class LC060_KthPermutationSequence {

	public static void main(String[] args) {
		
		String seq = KthPermutationSequence(3, 6);
		System.out.println(seq);

	}

	private static String KthPermutationSequence(int n, int k) {

		List<Integer> numbers = new ArrayList<Integer>();
		// generate numbers sequence {1,2,3,4}
		for(int i = 1; i <= n; i++)
		{
			numbers.add(i);
		}
		
		// create factorial look up
		// {1, 1, 2, 3, 6, 24, ... n!}
		int[] factorial = new int[n+1];
		factorial[0] = 1;
		
		int sum = 1;
		
		for(int i = 1; i <= n; i++)
		{
			sum = sum * i;
			factorial[i] = sum;
		}
		
		k--; // as k = 14 means k = 13 in 0 based index
		
		StringBuilder result = new StringBuilder();
		
		for(int i = 1; i <= n; i++)
		{
			int index = k / factorial[n-i];
			
			result.append(String.valueOf(numbers.get(index)));
			
			numbers.remove(index); // u ll have remaining numbers to form permutations
			
			k = k - (index)*(factorial[n-i]);
		}
		
		return result.toString();
	}

}
