package Arrays;

public class LC209_MinimumSizeSubArraySum {

	public static void main(String[] args) {

		int[] A = {2,3,1,2,4,3};
		int k = 7;
		
		int len = minSizeSubArray(A, k);
		System.out.println(len);
		
	}

	private static int minSizeSubArray(int[] A, int k) {

		if(A == null || A.length == 0)
		{
			return 0;
		}
		
		int i =0; 
		int sum = 0;
		int minLen = Integer.MAX_VALUE;
		
		for(int j = 0 ; j < A.length; j++)
		{
			sum = sum + A[j];
			
			while(sum >= k)
			{
				minLen = Math.min(minLen, j-i);
				
				sum = sum - A[i++];
			}
		}
		
		return minLen == Integer.MAX_VALUE ? 0 : minLen;
	}

}
