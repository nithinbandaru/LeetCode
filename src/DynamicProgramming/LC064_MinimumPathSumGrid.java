package DynamicProgramming;

public class LC064_MinimumPathSumGrid {

	public static void main(String[] args) {

		
		int[][] grid = { {1,3,5,8},
						 {4,2,1,7},
						 {4,3,2,3}};
		
		
		int cost = minCostPath(grid);
		System.out.println(cost);
		
	}

	private static int minCostPath(int[][] grid) {

		int numRows = grid.length;
		int numCols = grid[0].length;
		
		int[][] costMatrix = new int[numRows][numCols];
		
		int sum = 0;
		
		for(int i = 0 ; i < numRows ; i++)
		{
			costMatrix[i][0] = sum + grid[i][0];
			sum = costMatrix[i][0];
		}
		
		sum = 0;
		
		for(int i = 0 ; i < numCols ; i++)
		{
			costMatrix[0][i] = sum + grid[0][i];
			sum = costMatrix[0][i];
		}
		
		for(int i = 1; i < numRows; i++)
		{
			for(int j = 1; j < numCols; j++)
			{
				costMatrix[i][j] = grid[i][j] + Math.min(costMatrix[i-1][j], costMatrix[i][j-1]);
			}
		}
		
		return costMatrix[numRows-1][numCols-1];
	}

}
