package Arrays;

public class LC088_MergeTwoSortedArrays {

	// Time Complexity = O(m+n)
	// Space Complexity = O(1)
	
	public static void main(String[] args) {

		
		int[] A = { 1 , 2, 3, 0, 0, 0 } ;
		
		int[] B = { 2 , 5, 6 };
		
		
		MergeArrays(A, 3, B, B.length);
		
		for(int i : A)
		{
			System.out.print(i + " ");
		}
		
		
	}

	// Merge A into B 
	
	private static void MergeArrays(int[] A, int m, int[] B, int n) {

		for(int i = m+n-1; i >=0 ; i--)
		{
			if(m > 0 && n > 0)
			{
				if(B[n-1] > A[m-1])
				{
					A[i] = B[n-1];
					n--;
				}
				else
				{
					A[i] = A[m-1];
					m--;
				}				
			}
			else if(m > 0)
			{
				A[i] = A[m-1];
				m--;
			}
			else if(n > 0)
			{
				A[i] = B[n-1];
				n--;
			}			
		}
	}

}
