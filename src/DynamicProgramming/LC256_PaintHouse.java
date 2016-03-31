package DynamicProgramming;

public class LC256_PaintHouse {

	public static void main(String[] args) {

		int[][] costMatrix = { {10,20,30},
							   {10,20,30},
							   {10,20,30},
							   {10,20,30},
							   {10,20,30}
							 };
		
		
		int minCost = paintHouse(costMatrix);
		System.out.println(minCost);
		
	}

	private static int paintHouse(int[][] costMatrix) {

		if(costMatrix == null || costMatrix.length == 0)
		{
			return 0;
		}
		
		int prevCostToPaintWithRed = costMatrix[0][0];
		int prevCostToPaintWithGreen = costMatrix[0][1];
		int prevCostToPaintWithBlue = costMatrix[0][2];
		
		for(int i = 1; i < costMatrix.length; i++)
		{
			int currCostToPaintWithRed = costMatrix[i][0] + Math.min(prevCostToPaintWithGreen, prevCostToPaintWithBlue);
			int currCostToPaintWithGreen = costMatrix[i][1] + Math.min(prevCostToPaintWithRed, prevCostToPaintWithBlue);
			int currCostToPaintWithBlue = costMatrix[i][2] + Math.min(prevCostToPaintWithRed, prevCostToPaintWithGreen);
			
			prevCostToPaintWithRed = currCostToPaintWithRed;
			prevCostToPaintWithGreen = currCostToPaintWithGreen;
			prevCostToPaintWithBlue = currCostToPaintWithBlue;
			
		}
				
		return Math.min(prevCostToPaintWithGreen, Math.min(prevCostToPaintWithRed, prevCostToPaintWithBlue));
	}

}
