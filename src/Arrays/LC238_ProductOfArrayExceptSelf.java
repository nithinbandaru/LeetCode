package Arrays;

public class LC238_ProductOfArrayExceptSelf {

	public static void main(String[] args) {

		int[] A = {1,2,3,4};
		
		int[] productArray = productOfArrayExceptSelf(A);
		
		printArray(productArray);
		
				
	}

	private static void printArray(int[] A) {

		for(int i : A)
		{
			System.out.print(i+" ");
		}
		System.out.println();
	}

	private static int[] productOfArrayExceptSelf(int[] A) {

		int len = A.length;
		
		int[] leftArray = new int[len];
		leftArray[0] = 1;
		
		for(int i = 1; i < len; i++)
		{
			leftArray[i] = leftArray[i-1] * A[i-1];
		}
		
		int[] rightArray = new int[len];
		rightArray[len-1] = 1;		
		
		for(int i= len-2; i>=0 ; i--)
		{
			rightArray[i] = rightArray[i+1] * A[i+1];
		}
		
		int[] productArray = new int[len];
		
		for(int i= 0 ; i < len ; i++)
		{
			productArray[i] = leftArray[i] * rightArray[i];
		}
			
		return productArray;
	}

}
