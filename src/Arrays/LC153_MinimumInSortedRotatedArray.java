package Arrays;

public class LC153_MinimumInSortedRotatedArray {

	public static void main(String[] args) {

		int[] A = { 6, 7, 0, 1, 2 ,4, 5};
		
		int minNum = minimumElement(A);		
		
		System.out.println(minNum);
	}

	private static int minimumElement(int[] A) {

		int low = 0;
		int high = A.length-1;
		
		while(low < high)
		{
			if(A[low] < A[high])
			{
				return A[low];
			}
			
			int mid = low + (high-low)/2;
			
			if(A[low] <= A[mid])
			{
				low = mid + 1;
			}
			else
			{
				high = mid;
			}
			
		}		
		
		return A[low];
	}

}
