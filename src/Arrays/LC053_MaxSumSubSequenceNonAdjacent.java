package Arrays;

public class LC053_MaxSumSubSequenceNonAdjacent {

	public static void main(String[] args) {

		int[] A = {4, 1, 1, 4 , 2 , 1 };
		
		int sum = maxSumSubsequence(A);
		System.out.println(sum);
	}

	private static int maxSumSubsequence(int[] A) {

		int exclSum = 0;
		int inclSum = A[0];
		
		for(int i = 1; i < A.length; i++)
		{
			int temp = inclSum;
			inclSum = Math.max(inclSum, exclSum + A[i]);
			exclSum = temp;
			
		}
		
		return inclSum;
	}

}
