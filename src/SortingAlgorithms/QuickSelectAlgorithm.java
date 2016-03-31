package SortingAlgorithms;

public class QuickSelectAlgorithm {

	public static void main(String[] args) {

		int[] A = { 2, 3, 27, 4, 15, 9, 8 };
		printArray(A);
		
		int kthSmallest = QuickSelect(A, 2);
		System.out.println(kthSmallest);
		
	}

	private static void printArray(int[] A) {

		for(int i : A)
		{
			System.out.print(i + " ");
		}
		System.out.println();
	}

	private static int QuickSelect(int[] A, int k) {

		ShuffleArray(A);
		printArray(A);	
		
		int low = 0 ; 
		int high = A.length-1;
		
		while(low < high)
		{
			
			int pIndex = partition(A, low , high);
			if(pIndex == k)
			{
				return A[pIndex];
			}
			else if(pIndex < k)
			{
				low = pIndex + 1;
			}
			else
			{
				high = pIndex - 1;
			}
			
		}		
		
		return A[k];
	}

	private static int partition(int[] A, int low, int high) {

		int pivot = low;
		
		int i = low;
		int j = high;
		
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
			
			if(i<=j)
			{
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
			}
			
		}
		
		int temp = A[pivot];
		A[pivot] = A[j];
		A[j] = A[pivot];
		
		return j;
	}

	private static void ShuffleArray(int[] A) {

		int index = A.length - 1;
		
		for(int i = index ; i > 0 ; i--)
		{
			int randIndex = (int) (Math.random() * index);
			
			int temp = A[randIndex];
			A[randIndex] = A[index];
			A[index] = temp;			
						
		}		
		
	}

}
