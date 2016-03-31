package DynamicProgramming;

public class LC322_CoinChangeMinimumCoins {

	public static void main(String[] args) {

		
		//int[] coins = { 2, 1, 5};
		
		int[] coins = {2};
		int total = 3;
		
		int minCoins = CoinChangeMinimumCoins(coins, total);
		System.out.println("Minimum coins " + minCoins);
	}

	private static int CoinChangeMinimumCoins(int[] coins, int total) {

		int[] T = new int[total+1];
		int[] R = new int[total+1];
		
		T[0] = 0;
		
		for(int i = 1; i <= total; i++)
		{
			T[i] = Integer.MAX_VALUE-1;
			R[i] = -1;
		}
		
		// loop thru coins
		for(int j=0; j < coins.length; j++)
		{
			// loop thru total
			for(int i = 1; i <= total ; i++)
			{
				if(coins[j] <= i)
				{
					if( 1 + T[i - coins[j]] < T[i])
					{
						T[i] = 1 + T[i-coins[j]];
						R[i] = j;
					}
				}
								
			}			
		}		
		
		printCombination(R, coins);
		
		return T[total];
	}

	private static void printCombination(int[] R, int[] coins) {

		
		if(R[R.length-1] == -1)
		{
			System.out.println("No combinations possible");
			return;
		}
		
		int start = R.length-1;
		
		while(start != 0)
		{
			int j = R[start];
			System.out.print(coins[j] +" ");
			start = start - coins[j];
		}
			
		System.out.println();
		
	}

}
