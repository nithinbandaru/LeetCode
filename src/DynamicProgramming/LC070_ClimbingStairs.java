package DynamicProgramming;

public class LC070_ClimbingStairs {

	public static void main(String[] args) {

		
		int numOfStairs = 5;
		
		int numofWays = climbStairs2(numOfStairs);
		System.out.println(numofWays);
		
	}

	private static int climbStairs2(int n)
	{
		if(n == 0 || n == 1 || n == 2){return n;}
	    int[] mem = new int[n];
	    mem[0] = 1;
	    mem[1] = 2;
	    for(int i = 2; i < n; i++){
	        mem[i] = mem[i-1] + mem[i-2];
	    }
	    return mem[n-1];

	}
	
	
	private static int climbStairs(int numOfStairs) {

		if(numOfStairs == 0 || numOfStairs == 1)
		{
			return numOfStairs;
		}
		
		int numOfStepsFromStep1 = 1;
		int numOfStepsFromStep2 = 1;
		
		int numOfWays = 0;
		
		for(int i = 2; i<= numOfStairs ;i++)
		{
			numOfWays = numOfStepsFromStep1 + numOfStepsFromStep2;
			numOfStepsFromStep2 = numOfStepsFromStep1;
			numOfStepsFromStep1 = numOfWays;					
		}
		
		
		return numOfWays;
	}

}
