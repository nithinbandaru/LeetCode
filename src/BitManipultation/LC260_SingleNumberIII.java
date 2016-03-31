package BitManipultation;

public class LC260_SingleNumberIII {

	public static void main(String[] args) {

		
		int[] nums = {1, 2, 1, 3, 2, 5};
		
		int[] singleRepeats = singleNumbers(nums);
		System.out.println(singleRepeats[0] + " " + singleRepeats[1]);
	}

	private static int[] singleNumbers(int[] nums) {

		int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        
        System.out.println(diff);
                
        // Get its last set bit
        diff &= -diff;
        System.out.println(diff);
        
        // Pass 2 :
        int[] rets = {0, 0}; // this array stores the two numbers we will return
        
        for (int num : nums)
        {
            if ((num & diff) == 0) // the bit is not set
            {
                rets[0] = rets[0] ^ num;
            }
            else // the bit is set
            {
                rets[1] = rets[1] ^ num;
            }
        }
        return rets;

		
	}

}
