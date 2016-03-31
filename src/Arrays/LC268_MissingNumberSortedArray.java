package Arrays;

public class LC268_MissingNumberSortedArray {

	public static void main(String[] args) {

		int[] A = { 0, 2, 3, 4, 5, 6};
		
		int missNum = findMissingNumber(A);
		System.out.println("Missing Number: "+ missNum);
		
	}

	private static int findMissingNumber(int[] A) {

		int left = 0; 
		int right = A.length - 1;
		
		while(left < right)
		{
			int mid = left + (right - left)/2;
			
			if(A[mid] > mid)
			{
				right = mid;
			}
			else
			{
				left = mid+1;
			}
		}
		
		return left;
	}

}
