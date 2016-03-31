package Arrays;

public class LC268_MissingNumberUnsortedArray {

	public static void main(String[] args) {

		int[] A = { 3, 4, 0, 5, 2, 1};
		
		int missNum = findMissingNumber(A);
		System.out.println("Missing Number: "+ missNum);
		
	}

	private static int findMissingNumber(int[] A) {

		int xorOfArrayElements = A[0];
		
		for(int i = 1 ; i < A.length ; i++)
		{
			xorOfArrayElements = xorOfArrayElements ^ A[i];
		}
		
		int xorOfNaturalNumbers = 0;
		
		for(int i = 1; i <= A.length ; i++)
		{
			xorOfNaturalNumbers = xorOfNaturalNumbers ^ i;
		}
		
		int missingNumber = xorOfArrayElements ^ xorOfNaturalNumbers;
		
		return missingNumber;
	}

}
