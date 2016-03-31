package Arrays;

import java.util.Arrays;

public class LC016_ThreePairClosestSum {

	public static void main(String[] args) {

		int[] A = {-1, 2, 1, -4};
		
		int target = 1;
		
		int closestSum = closestSum(A, target);
		System.out.println(closestSum);
		
	}

	private static int closestSum(int[] A, int target) {

		Arrays.sort(A);
		
		int result = A[0] + A[1] + A[A.length - 1];
		
		for(int i=0; i < A.length-2; i++)
		{
			int low = i+1; 
			int high = A.length - 1;
			
			while(low < high)
			{
				int sum = A[i] + A[low] + A[high];
				
				if(sum < target)
				{
					low++;
				}
				else 
				{
					high--;
				}
				
				if(Math.abs(sum - target) < Math.abs(result - target))
				{
					result = sum;
				}
			}
			
		}
		
		return result;
	}

}
