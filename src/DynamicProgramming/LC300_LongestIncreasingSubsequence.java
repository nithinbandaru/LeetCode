package DynamicProgramming;

public class LC300_LongestIncreasingSubsequence {

	// Time Complexity = O(n2)
	// space complexity = O(n)
	
	public static void main(String[] args) {

		
		int[] A = {10, 9, 2, 5, 3, 7, 101, 18};
		
		int len = longestIncreasingSubsequence(A);
		System.out.println(len);
	}

	private static int longestIncreasingSubsequence(int[] A) {

		int len = A.length;
		
		if(len < 2)
		{
			return len;
		}
		
		
		int[] T = new int[len];
		
		int[] actualSolution = new int[len];
		
		// minimum longest subsequence is that element itself
		
		for(int i = 0; i < len; i++)
		{
			T[i] = 1;
			actualSolution[i] = i;
		}
		
		for(int i = 1; i < len; i++)
		{
			for(int j = 0; j < i; j++)
			{
				if(A[j] < A[i])
				{
					T[i] = Math.max(T[i], T[j] + 1);
					//set the actualSolution to point to guy before me
					actualSolution[i] = j;
				}
			}
		}
		
		int maxIndex = 1;
		
		for(int i = 0; i < T.length; i++)
		{
			if(T[i] > T[maxIndex])
			{
				maxIndex = i;
			}
		}
		
		//lets print the actual solution
        int t = maxIndex;
        int newT = maxIndex;
        do
        {
            t = newT;
            System.out.print(A[t] + " ");
            newT = actualSolution[t];
        }
        while(t != newT);
        System.out.println();

		
		return T[maxIndex];
	}

}
