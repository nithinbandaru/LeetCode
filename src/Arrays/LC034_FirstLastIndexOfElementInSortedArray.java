package Arrays;

public class LC034_FirstLastIndexOfElementInSortedArray {

	public static void main(String[] args) {

		int[] A = { 2 , 4 , 10 , 10 , 10 , 18 , 20 };
		
		int target = 41;
		
		int[] range = binarySearch(A, target);
		
		System.out.println(range[0] + " " + range[1]);
		
	}

	private static int[] binarySearch(int[] A, int target) {

		int firstOccurence = binarySearchFindFirst(A, target, true);
		int lastOccurence = binarySearchFindFirst(A, target, false);
		
		return new int[]{firstOccurence, lastOccurence};
	}

	private static int binarySearchFindFirst(int[] A, int target, boolean searchFirst) {

		int low = 0 ; 
		int high = A.length-1;
		
		int index = -1;
		
		while(low <= high)
		{
			int mid = low+ (high-low)/2;
			
			if(A[mid] == target)
			{
				index = mid;
				if(searchFirst)
				{
					high = mid-1;
				}
				else
				{
					low = mid+1;
				}
			}
			else if(A[mid] < target)
			{
				low = mid + 1;
			}
			else
			{
				high = mid - 1;
			}			
		}
		
		return index;
	}

}
