package Arrays;

public class LC280_WiggleSortI {

	public static void main(String[] args) {

		//int[] A = {8, 5, 2, 1, 6, 4};
		
		int[] A = {2,1};
		
		wiggleSort(A);
		
		for(int i : A)
		{
			System.out.print(i + " ");
		}
	}

	private static void wiggleSort(int[] A) {

		for(int i = 0 ; i < A.length; i++)
		{
			if(i%2 == 1)
			{
				if(A[i-1] > A[i])
				{
					swap(A,i);
				}
			}
			else if(i != 0 && A[i-1] < A[i])
			{
				swap(A,i);
			}
			
		}
		
		
	}

	private static void swap(int[] A, int i) {

		int temp = A[i-1];
		A[i-1] = A[i];
		A[i] = temp;
		
	}

}
