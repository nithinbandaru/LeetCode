package Arrays;

public class LC033_SearchInRotatedSortedArray {

	public static void main(String[] args) {

		int[] A = { 4, 5, 6, 7, 0, 1, 2 } ;
		
		int target = 0;
		
		boolean found = modifiedBinarySearch(A, target);
		
		System.out.println(found);
		
	}

	private static boolean modifiedBinarySearch(int[] A, int target) {

		int low = 0 ;
		int high = A.length-1;
		
		while(low <= high)
		{
			int mid = low + (high-low)/2;
			
			if(target == A[mid])
			{
				return true;
			}
			
			if(A[low] <= A[mid])  // left half sorted
			{
				if(target >= A[low] && target < A[mid])
				{
					high = mid - 1;
				}
				else
				{
					low = mid + 1;
				}
			}
			else
			{
				if(target > A[mid] && target <= A[high])
				{
					low = mid + 1;
				}
				else
				{
					high = mid - 1;
				}				
			}
		}
		
		return false;
	}

}
