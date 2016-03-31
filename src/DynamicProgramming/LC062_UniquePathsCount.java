package DynamicProgramming;

public class LC062_UniquePathsCount {

	public static void main(String[] args) {

		int count = uniquePathsCount(3,3);
		
		System.out.println(count);
	}

	private static int uniquePathsCount(int numRows, int numCols) {

		if(numRows == 1 || numCols == 1)
		{
			return 1;
		}
		
		int[][] pathMatrix = new int[numRows][numCols];
		
		for(int i = 0 ; i < numCols ; i++)
		{
			pathMatrix[0][i] = 1;
		}
		
		for(int i = 0 ; i < numRows ; i++)
		{
			pathMatrix[i][0] = 1;
		}
		
		for(int i = 1; i < numRows ; i++)
		{
			for(int j = 1 ; j < numCols; j++)
			{
				pathMatrix[i][j] = pathMatrix[i][j-1] + pathMatrix[i-1][j];
			}
		}		
		
		return pathMatrix[numRows-1][numCols-1];
	}

}
