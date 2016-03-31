package Arrays;

public class LC035_SearchInsertPositionSortedArray {

	public static void main(String[] args) {

		int[] A = { 2 , 5 , 10 , 20 , 30 , 48 , 60 };
		int target  = 3;
 		
		int index = searchIndex(A , target);
		System.out.println(index);
		
	}

	private static int searchIndex(int[] A, int key) {

		int low = 0;
		int high = A.length-1;
		
		while(low <= high)
		{
			int mid = low + (high - low)/2;
			
			if(A[mid] == key)
			{
				return mid;
			}
			else if(key < A[mid])
			{
				high = mid - 1;
			}
			else
			{
				low = mid + 1;
			}
		}
		
		return low;
	}

}
