package SortingAlgorithms;

public class LC215_KthSmallestElement {

	public static void main(String[] args) {

		
		int[] A = {3,2,1,5,6,4}; 
		
		int k = 2;
		
		int smallestElement = KthSmallestElement(A , 4);
		System.out.println(smallestElement);
		for(int i : A)
		{
			//System.out.print(i + " ");
		}
		
		int i = 0;
		while(A[i] <= smallestElement)
		{
			System.out.print(A[i] + " ");
			i++;
		}
		
	}

	private static int KthSmallestElement(int[] A, int k) {
		
		return QuickSelect(A, 0, A.length-1, k);
	}

	private static int QuickSelect(int[] A, int start, int end, int k) {

		
		if(start <= end)
		{
			int pivotIndex = partition(A, start, end);
			
			if(pivotIndex == k-1)
			{
				return A[pivotIndex];
			}
			else if(pivotIndex < k-1)
			{
				return QuickSelect(A, pivotIndex + 1, end, k);
			}
			else
			{
				return QuickSelect(A, start, pivotIndex - 1, k);
			}			
		}
		
		return -1;
		
	}

	private static int partition(int[] A, int start, int end) {

		int i = start;
		int j = end;
		
		int pivot = start;
		
		while(i <= j)
		{
			while(i<=j && A[i] <= A[pivot])
			{
				i++;
			}
			
			while(i<=j && A[j] >= A[pivot])
			{
				j--;
			}
			
			if(i < j)
			{
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
			}
		}
		
		int temp = A[j];
		A[j] = A[pivot];
		A[pivot] = temp;		
		
		return j;
	}

}
