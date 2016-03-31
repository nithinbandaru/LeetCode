package Matrix;

public class LC074_SearchSorted2DMatrix {

	// Stair search algorithm
	
	// Time Complexity = O(n)	
	
	public static void main(String[] args) {

		int[][] matrix = { {1,   3,  5,  7},
						   {10, 11, 16, 20},
						   {23, 30, 34, 50}
						 };
		
		int target = 51;
		
		boolean found = searchMatrix(matrix, target);
		System.out.println(found);
		
		
	}

	private static boolean searchMatrix(int[][] matrix, int target) {

		int numRows = matrix.length;
		int numCols = matrix[0].length;
		
		if(target < matrix[0][0] || target > matrix[numRows-1][numCols-1])
		{
			return false;
		}
		
		int row = 0;
		int col = numCols-1;
		
		while(row < numRows && col >= 0)
		{
			if(target > matrix[row][col])
			{
				row++;
			}
			else if(target < matrix[row][col])
			{
				col--;
			}
			else
			{
				return true;
			}
		}
		
		return false;
	}

}
