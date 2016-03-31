package Arrays;

public class LC283_MoveZerosToEndOfArray {

	public static void main(String[] args) {

		int[] nums = {0, 1, 0, 3, 12};
		
		MoveZerosToEnd(nums);
		
		printArray(nums);
		
		
	}

	private static void printArray(int[] nums) {

		for(int i:nums)
		{
			System.out.print(i+" ");
		}
	}

	private static void MoveZerosToEnd(int[] nums) {

		if(nums == null || nums.length == 0)
		{
			return;
		}
		
		int index = 0;
		
		for(int i=0 ;i<nums.length;i++)
		{
			if(nums[i]!=0)
			{
				nums[index] = nums[i];
				index++;
			}
		}
		
		
		while(index < nums.length)
		{
			nums[index++] = 0;
		}
		
	}

}
