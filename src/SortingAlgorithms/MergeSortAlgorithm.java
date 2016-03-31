package SortingAlgorithms;

public class MergeSortAlgorithm {

	public static void main(String[] args) {

		int[] A = { 2, 4 , 1, 6, 8, 5, 3, 7 };
		
		MergeSort(A);
		
		for(int i : A)
		{
			System.out.print(i + " ");
		}
	}

	private static void MergeSort(int[] A) {

		int numElements = A.length;
		
		if(numElements < 2)
		{
			return;
		}
		
		int mid = numElements/2;
		
		int[] leftA = new int[mid];
		int[] rightA = new int[numElements-mid];
		
		for(int i = 0 ; i < mid ; i++)
		{
			leftA[i] = A[i];
		}
		
		for(int i = mid; i < numElements ; i++)
		{
			rightA[i-mid] = A[i];
		}
		
		MergeSort(leftA);
		MergeSort(rightA);
		
		MergeSortedArrays(leftA, rightA , A);
		
	}

	private static void MergeSortedArrays(int[] A, int[] B, int[] C) {

		int lenA = A.length;
		int lenB = B.length;
		
		int i = 0 ; int j = 0 ; int k = 0;
		
		while(i < lenA && j < lenB)
		{
			if(A[i] <= B[j])
			{
				C[k] = A[i];
				i++;
			}
			else
			{
				C[k] = B[j];
				j++;
			}
			
			k++;
		}
		
		while(i < lenA)
		{
			C[k] = A[i];
			i++;
			k++;
		}
		
		while(j < lenB)
		{
			C[k] = B[j];
			k++;
			j++;
		}
		
	}

}
