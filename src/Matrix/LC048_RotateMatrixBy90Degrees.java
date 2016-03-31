package Matrix;

public class LC048_RotateMatrixBy90Degrees {

	public static void main(String[] args) {

		int[][] matrix = { {1,2,3},
						   {4,5,6},
						   {7,8,9}
						 };
		
		
		int[][] rotatedMatrix = rotateMatrix(matrix);
		
		for(int i =0 ;i < rotatedMatrix.length ; i++)
		{
			for(int j = 0 ; j < rotatedMatrix[0].length ; j++)
			{
				System.out.print(rotatedMatrix[i][j] +" ");
			}
			System.out.println();
		}
		
	}

	private static int[][] rotateMatrix(int[][] matrix) {

		int numRows = matrix.length;
		int numCols = matrix[0].length;
		
		// 1. transpose matrix		
		
		for(int i = 0 ; i < numRows ; i++)
		{
			for(int j = i ; j < numCols; j++)
			{
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		
		// 2. Flip the rows
		
		for(int i = 0 ; i < numRows ; i++)
		{
			
			int low = 0 ; 
			int high = numCols-1;
			
			while(low <= high)
			{
				int temp = matrix[i][low];
				matrix[i][low] = matrix[i][high];
				matrix[i][high] = temp;
				low++;
				high--;
			}			
			
		}
		
		return matrix;
	}

}
