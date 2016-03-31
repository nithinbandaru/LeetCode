package DynamicProgramming;

public class LC123_BestTimeToBuyAndSellStocksWith2Transcations {

	// time complexity = O(days * transactions)
	public static void main(String[] args) {

		int[] stockPrices = {100, 80, 120, 130, 70, 60, 100, 125};
		
		int transactions = 2;
		
		int maxProfit = maxProfitStocks(stockPrices, transactions);
	
		System.out.println(maxProfit);
	}

	private static int maxProfitStocks(int[] stockPrices, int transactions) {
		
		if(transactions == 0 || stockPrices.length == 0)
		{
			return 0;
		}
		
		int[][] T = new int[transactions+1][stockPrices.length];
		
		// loop over all possible transactions
		for(int i = 1; i < T.length; i++)
		{
			int maxDiff = - stockPrices[0];
			// start selling from day1 to end day
			for(int j = 1; j < T[0].length; j++)
			{
				T[i][j] = Math.max(T[i][j-1], stockPrices[j] + maxDiff); // max profit without transaction on that day
				maxDiff = Math.max(maxDiff, T[i-1][j] - stockPrices[j]);
			}
			
		}
		
		return T[transactions][stockPrices.length-1];
	}

}
