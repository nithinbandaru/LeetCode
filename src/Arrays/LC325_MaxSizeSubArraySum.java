package Arrays;

import java.util.HashMap;

public class LC325_MaxSizeSubArraySum {

	public static void main(String[] args) {

		int sum = 1;
		
		//int[] A = {1, -1, 5, -2, 3};
		
		int[] A = {-2, -1, 2, 1};
		
		int maxSubArray = maxSizeSubArray(A , sum);
		
		System.out.println(maxSubArray);
	}

	private static int maxSizeSubArray(int[] A, int target) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		int sum = 0;
		int maxLen = 0;
		
		for(int i = 0; i < A.length; i++)
		{
			sum = sum + A[i];
			if(sum == target)
			{
				maxLen = i + 1;
			}
			else if(map.containsKey(sum - target))
			{
				maxLen = Math.max(maxLen, i - map.get(sum-target));
			}
			
			if(!map.containsKey(sum))
			{
				map.put(sum, i);
			}
		}
		
		return maxLen;
	}

}
