package Matrix;

// time complexity and space complexity = O(n)
public class LC200_NumberOfIsland {

	static int[] dirX = {1,0,-1,0};
	static int[] dirY = {0,-1,0,1};
	
	public static void main(String[] args) {

		int[][] grid = {{1,1,0,0,0},
						{1,1,0,0,0},
						{0,0,1,0,0},
						{0,0,0,1,1}
					   };
		
		int numOfIslands = NumberOfIslands(grid);
		System.out.println(numOfIslands);
		
	}

	private static int NumberOfIslands(int[][] grid) {

		if(grid == null || grid.length == 0 || grid[0].length == 0)
		{
			return 0;
		}
		
		int islands = 0;
		
		for(int i = 0; i < grid.length; i++)
		{
			for(int j = 0; j < grid[0].length; j++)
			{
				if(grid[i][j]==1)
				{
					islands++;
					explore(grid, i, j);
				}
			}
		}
		
		return islands;
	}

	private static void explore(int[][] grid, int row, int col) {

		grid[row][col] = -1; // mark it as visited
		
		// explore 4 directions
		
		for(int dir = 0; dir < 4; dir++)
		{
			int r = row + dirY[dir];
			int c = col + dirX[dir];
			// check boundary condition and explore if 1 is found
			if(r >= 0 && r < grid.length && c >=0 && c < grid[0].length && grid[r][c] == 1)
			{
				explore(grid,r,c);
			}
		}
		
		
		
	}

}
