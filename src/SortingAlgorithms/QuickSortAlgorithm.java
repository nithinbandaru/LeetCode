package SortingAlgorithms;

import java.util.Random;

public class QuickSortAlgorithm {

	public static void main(String[] args) {

		int[] A = { 2, 4 , 1, 6, 8, 5, 3, 7 };
		
		for(int i : A)
		{
			System.out.print(i + " ");
		}
		System.out.println();
		
		QuickSort(A, 0, 7);
		
		for(int i : A)
		{
			System.out.print(i + " ");
		}
	}

	private static void QuickSort(int[] A, int start, int end) {

		if(start < end)
		{
			int partitionIndex = RandomisedPartition(A, start , end);
			QuickSort(A, start, partitionIndex-1);
			QuickSort(A, partitionIndex+1 , end);
		}
	}

	private static int RandomisedPartition(int[] A, int start, int end) {

		Random random = new Random();
		int partitionIndex = random.nextInt(end - start) + start;
		
		int temp = A[partitionIndex];
		A[partitionIndex] = A[end];
		A[end] = temp;
		
		int index = partition(A, start, end);
		
		return index;
	}

	private static int partition(int[] A, int start, int end) {

		int pivot = A[end];
		int pIndex = start;
		
		for(int i = start ; i < end; i++)
		{
			if(A[i] <= pivot)
			{
				int temp = A[i];
				A[i] = A[pIndex];
				A[pIndex] = temp;
				pIndex++;
			}
		}
		
		int temp = A[pIndex];
		A[pIndex] = A[end];
		A[end] = temp;
		
		return pIndex;
	}


}
