package Arrays;


public class LC053_MaximumSumSubArrayKadaneAlgorithm {

	public static void main(String[] args) {

		int[] A = {-2,1,-3,4,-1,2,1,-5,4};
		
		LC053_MaximumSumSubArrayKadaneAlgorithm obj = new LC053_MaximumSumSubArrayKadaneAlgorithm();
		
		KadaneResult result = obj.maxSumSubArray(A);
		
		System.out.println(result.maxSum);
		
		for(int i = result.start ; i <= result.end; i++)
		{
			System.out.print(A[i] + " ");
		}
		
	}

	private KadaneResult maxSumSubArray(int[] A)
	{
		int maxStart = -1;
		int maxEnd = -1;
		int currentStart = 0;
		
		int maxSumSoFar = 0;
		int maxSum = Integer.MIN_VALUE;
		
		
		for(int i = 0; i < A.length; i++)
		{
			maxSumSoFar = maxSumSoFar + A[i];
			
			if(maxSumSoFar > maxSum)
			{
				maxSum = maxSumSoFar;
				maxStart = currentStart;
				maxEnd = i;
			}
			
			if(maxSumSoFar < 0)
			{
				maxSumSoFar = 0;
				currentStart = i+1;
			}
			
		}
		
		return new KadaneResult(maxSum, maxStart, maxEnd);
	}


	
	class KadaneResult
	{
		int maxSum;
		int start;
		int end;
		
		public KadaneResult(int maxSum, int start, int end)
		{
			this.maxSum = maxSum;
			this.start = start;
			this.end = end;
		}
				
	}

}
