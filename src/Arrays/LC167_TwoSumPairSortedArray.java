package Arrays;

public class LC167_TwoSumPairSortedArray {

	public static void main(String[] args) {

		int[] A = { 2, 7 , 11, 15};
		
		int[] indices = twoSumPair(A, 9);
		System.out.println(indices[0] + " " + indices[1]);
		
	}

	private static int[] twoSumPair(int[] A, int target) {

		int[] indices = new int[2];
		
		if(A == null || A.length < 2)
		{
			return indices;
		}
		
		int low = 0 ; 
		int high = A.length-1;
		
		while(low < high)
		{
			int sum = A[low] + A[high];
			if(sum == target)
			{
				indices[0] = low;
				indices[1] = high;
				break;
			}
			else if(sum < target)
			{
				low++;
			}
			else
			{
				high--;
			}
		}
		
		return indices;
	}

}
