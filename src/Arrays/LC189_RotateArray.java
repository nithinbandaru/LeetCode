package Arrays;

public class LC189_RotateArray {

	public static void main(String[] args) {

		int[] A = { 1, 2 , 3, 4, 5, 6, 7 };
		
		printArray(A);
		
		RotateArray(A, 2);
		
		printArray(A);
		
	}

	private static void RotateArray(int[] A, int rotateBy) {

		rotateBy = rotateBy % A.length;
		printArray(A);
		reverseArray(A, 0 , rotateBy - 1);
		printArray(A);
		reverseArray(A, rotateBy  , A.length - 1);
		reverseArray(A, 0 , A.length - 1);
		
		
	}

	private static void reverseArray(int[] A, int start, int end) {

		while(start < end)
		{
			int temp = A[start];
			A[start] = A[end];
			A[end] = temp;
			start++;
			end--;
		}		
	}

	private static void printArray(int[] A) {

		for(int i : A)
		{
			System.out.print(i + " ");
		}	
		System.out.println();
	}
}
