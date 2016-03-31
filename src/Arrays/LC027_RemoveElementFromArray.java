package Arrays;

public class LC027_RemoveElementFromArray {

	public static void main(String[] args) {

		int[] A = { 1 ,5, 3, 6, 4, 3, 2 , 3 };
		
		int newLen = removeElement(A, 3);
		System.out.println(newLen);
		
		for(int i =0 ; i < newLen ; i++)
		{
			System.out.print(A[i] + " ");
		}
		
	}

	private static int removeElement(int[] A, int key) {

		int index = 0;
		
		for(int i = 0 ; i < A.length; i++)
		{
			if(A[i] != key)
			{
				A[index] = A[i];
				index++;
			}
		}
		
		return index;
	}

}
