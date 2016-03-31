package DynamicProgramming;

public class LC322_CoinChangeNumWays {

	public static void main(String[] args) {

		int[] coins = { 2, 3, 5, 6};
		
		int total = 10;
		
		int numWays = CoinChangeNumWays(coins , total);
		System.out.println(numWays);
	}

	private static int CoinChangeNumWays(int[] coins, int total) {

		int[][] temp = new int[coins.length+1][total+1];
		
		for(int i = 0 ; i < temp.length; i++)
		{
			temp[i][0] = 1;
		}
		
		for(int i=1; i <= coins.length; i++)
		{
            for(int j=1; j <= total ; j++)
            {
                if(coins[i-1] > j)
                {
                    temp[i][j] = temp[i-1][j];
                }
                else
                {
                    temp[i][j] = temp[i][j-coins[i-1]] + temp[i-1][j];
                }
            }
        }
		
        return temp[coins.length][total];		
	}

}
