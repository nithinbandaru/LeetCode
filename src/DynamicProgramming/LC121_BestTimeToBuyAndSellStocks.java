package DynamicProgramming;

public class LC121_BestTimeToBuyAndSellStocks {

	public static void main(String[] args) {

		int[] stockPrices = {100, 80, 120, 130, 70, 60, 100, 125};
		
		int maxProfit = maxProfitStocks(stockPrices);
	
		System.out.println(maxProfit);
	}

	
	
	private static int maxProfitStocks(int[] stockPrices) {

		int profit = 0;
		int minBuyPrice = Integer.MAX_VALUE;
		
		for(int i =0 ; i < stockPrices.length ; i++)
		{
			if(stockPrices[i] < minBuyPrice)
			{
				minBuyPrice = stockPrices[i];
			}
			else
			{
				profit = Math.max(profit, stockPrices[i] - minBuyPrice);
			}
		}
		
		return profit;
	}

}
