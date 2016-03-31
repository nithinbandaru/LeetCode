package Arrays;

public class LC055_JumpToEndOfArray {

	public static void main(String[] args) {

		//int[] A = {2,3,1,1,4}; // true
		int[] B = {3,2,1,0,4};
		
		boolean canJump = canJumpToEnd(B);
		System.out.println(canJump);
		
	}

	private static boolean canJumpToEnd(int[] A) {

		int maxReach = 0;
		
		for(int i = 0 ; i < A.length ; i++)
		{
			if(i > maxReach)
			{
				return false;
			}
			
			maxReach = Math.max(maxReach, A[i] + i);
		}	
		
		return true;
	}

}
