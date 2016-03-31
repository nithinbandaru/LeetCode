package Arrays;

public class LC303_RangeSumQueryImmutable {

	public static void main(String[] args) {

		int[] nums = {-2, 0, 3, -5, 2, -1};
		
		int sum = rangeSumQuery(nums, 2, 5);
		System.out.println(sum);
		
	}
	
	

	private static int rangeSumQuery(int[] A ,int start, int end) {

		int sum = 0;
		
		for(int i = start ; i <= end ; i++ )
		{
			sum = sum + A[i];
		}
		
		return sum;
	}

}
