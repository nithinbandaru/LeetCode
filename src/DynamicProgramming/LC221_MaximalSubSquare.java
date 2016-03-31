package DynamicProgramming;

public class LC221_MaximalSubSquare {

	public static void main(String[] args) {

		int[][] matrix = { {1, 0, 1, 0, 0},
						   {1, 0, 1, 1, 1},
						   {1, 1, 1, 1, 1},
						   {1, 0, 1, 1, 1}
						 };
		
		int maxSquareArea = maximalSubSquare(matrix);
		
		System.out.println(maxSquareArea);
		
	}

	private static int maximalSubSquare(int[][] matrix) {

		int numRows = matrix.length;
		if(numRows == 0)
		{
			return 0;
		}
		int numCols = matrix[0].length;
		int squareSize = 0;
		
		int[][] dpMatrix = new int[numRows+1][numCols+1];
		
		for(int i = 1; i <= numRows; i++)
		{
			for(int j = 1; j <= numCols; j++)
			{
				if(matrix[i-1][j-1] == 1)
				{
					dpMatrix[i][j] = 1 + Math.min(dpMatrix[i-1][j-1], Math.min(dpMatrix[i][j-1], dpMatrix[i-1][j]));
					squareSize = Math.max(squareSize, dpMatrix[i][j]);
				}
			}
		}
		
		int maxSquareArea = squareSize * squareSize;
		
		return maxSquareArea;
	}

}
