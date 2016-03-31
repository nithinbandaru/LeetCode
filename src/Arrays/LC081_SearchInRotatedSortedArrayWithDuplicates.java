package Arrays;

public class LC081_SearchInRotatedSortedArrayWithDuplicates {

	public static void main(String[] args) {

		//int[] A = { 4, 5, 4, 4, 4, 4, 4 } ;
		int[] A = { 4, 5, 6, 7, 0, 1, 2 } ;
		
		int target = 2;
		
		int index = modifiedBinarySearch(A, target);
		
		System.out.println(index);
		
	}

	private static int modifiedBinarySearch(int[] A, int target) {

		int low = 0 ;
		int high = A.length-1;
		
		while(low <= high)
		{
			int mid = low + (high-low)/2;
			
			if(target == A[mid])
			{
				return mid;
			}
			
			if(A[low] < A[mid])  // left half sorted
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
			else if (A[low] > A[mid] )
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
			else
			{
				low++;
			}
		}
		
		return -1;
	}

}
