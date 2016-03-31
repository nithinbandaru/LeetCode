package DynamicProgramming;

public class LC063_UniquePathsWithObstacles {

	public static void main(String[] args) {

		
		int[][] obstacles = { {0, 0, 0},
							  {0, 1, 0},
							  {0, 0, 0}};
		
		
		int paths = countPaths(obstacles);
		System.out.println(paths);
		
	}

	private static int countPaths(int[][] obstaclesGrid) {

		
		int numRows = obstaclesGrid.length;
		int numCols = obstaclesGrid[0].length;
		
		
		obstaclesGrid[0][0] = obstaclesGrid[0][0] ^ 1;
		
		// all rows first column
		
		for(int i=1; i < numRows; i++)
		{
			obstaclesGrid[i][0] = (obstaclesGrid[i][0] == 1) ? 0 : obstaclesGrid[i-1][0]; 
		}
		
		// first row all columns
		
		for(int j = 1; j < numCols ; j++)
		{
			
			obstaclesGrid[0][j] = (obstaclesGrid[0][j]==1 ) ? 0 : obstaclesGrid[0][j-1];  
		}
		
		for(int i = 1; i < numRows ; i++)
		{
			for(int j = 1; j < numCols ; j++)
			{
				obstaclesGrid[i][j] = (obstaclesGrid[i][j] == 1) ? 0 : obstaclesGrid[i-1][j] + obstaclesGrid[i][j-1] ; 
			}
		}		
		
		return obstaclesGrid[numRows-1][numCols-1];
	}

}
