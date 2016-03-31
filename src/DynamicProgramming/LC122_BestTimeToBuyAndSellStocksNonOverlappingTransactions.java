package DynamicProgramming;

public class LC122_BestTimeToBuyAndSellStocksNonOverlappingTransactions {

	public static void main(String[] args) {

		int[] stockPrices = {100, 80, 120, 130, 70, 60, 100, 125};
		
		int maxProfit = maxProfitStocks(stockPrices);
	
		System.out.println(maxProfit);
	}

	private static int maxProfitStocks(int[] stockPrices) {

		int totalProfit = 0;
		
		int profit = 0 ;
		
		for(int i = 1 ; i < stockPrices.length ; i++)
		{
		    profit = stockPrices[i] - stockPrices[i-1];
		    if(profit > 0)
		    {
		    	totalProfit = totalProfit + profit;
		    }
		}
		
		return totalProfit;
	}

}
