package Arrays;

public class LC026_RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {

		int[] A = {1, 1 , 2 , 3, 3, 3, 4, 5, 6, 6};
		
		int newLen = removeDuplicates(A);
		
		printNewArray(A, newLen);
		
		//sSystem.out.println(newLen);
	}

	private static void printNewArray(int[] A, int newLen) {

		for(int i = 0 ; i < newLen ; i++)
		{
			System.out.print(A[i] + " ");
		}
		
	}

	private static int removeDuplicates(int[] A) {

		int len = A.length;
		
		if(len < 2)
		{
			return len;
		}
		
		int index = 1;
		
		for(int i = 1 ; i < len  ; i++)
		{
			if(A[i] != A[i-1])
			{
				A[index] = A[i];
				index++;
			}
		}
		
		return index;
	}

}
