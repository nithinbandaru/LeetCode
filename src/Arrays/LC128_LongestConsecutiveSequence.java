package Arrays;

import java.util.HashSet;
import java.util.Set;

public class LC128_LongestConsecutiveSequence {

	public static void main(String[] args) {

		int[] A = { 2, 15, 1, 18, 3, 10, 4};
		
		int len = longestConsecutiveSequence(A);
		System.out.println(len);		
		
	}

	private static int longestConsecutiveSequence(int[] A) {

		int maxSeqLen = 0;
		
		Set<Integer> set = new HashSet<Integer>();
		
		for(int num : A)
		{
			set.add(num);
		}
		
		for(int num : set)
		{
			if(!set.contains(num-1))
			{
				int nextNum = num + 1;
				
				while(set.contains(nextNum))
				{
					nextNum++;
				}
				
				maxSeqLen = Math.max(maxSeqLen, nextNum - num);
			}
		}
		
		return maxSeqLen;
	}

}
