package Arrays;

public class LC152_MaximumProductSubArray {

	public static void main(String[] args) {

		// int[] A = {6, -3, -10, 0, 2};
		
		int[] A = {2, 3, -2, 4};
		
		int maxProduct = maximumProductSubArray(A);
		System.out.println(maxProduct);
	}

	private static int maximumProductSubArray(int[] A) {

		int len = A.length;
		
		if (len == 0) return 0;
		
	    int maxProduct = A[0];
	    int minProduct = A[0];
	    int maxResult = A[0];
	    
	    for (int i = 1; i < len; i++)
	    {
	        if (A[i] >= 0)
	        {
	            maxProduct = Math.max(maxProduct * A[i], A[i]);
	            minProduct = Math.min(minProduct * A[i], A[i]);
	        }
	        else
	        {
	            int temp = maxProduct;
	            maxProduct = Math.max(minProduct * A[i], A[i]);
	            minProduct = Math.min(temp * A[i], A[i]);
	        }
	        
	        maxResult = Math.max(maxResult, maxProduct);
	    }
		
		return maxResult;
	}

}
