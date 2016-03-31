package Arrays;

public class LC162_PeakElement {

	public static void main(String[] args) {

		//int[] A = { 1, 2, 3, 4, 5, 2, 1};
		
		int[] A = { 1, 2, 3};
		
		int peak = peakElement(A);
		
		System.out.println(peak + " " + A[peak]);
	}

	private static int peakElement(int[] A) {

		int low = 0;
		int high = A.length-1;
		
		return peakElementUtil(A, low, high);
		
	}

	private static int peakElementUtil(int[] A, int low, int high) {
		
		if(low == high)
		{
			return low;
		}
		else if(low + 1 == high)
		{
			return Math.max(A[low], A[high]);
		}
		else
		{
			
			int mid = low + (high-low)/2;
			
			if( A[mid-1] < A[mid] && A[mid] > A[mid+1])
			{
				return mid;
			}
			else if( A[mid-1] < A[mid] && A[mid] < A[mid+1])
			{
				return peakElementUtil(A,mid + 1 , high);
			}
			else
			{
				return peakElementUtil(A, low , mid-1);
			}
		}

	}

}
