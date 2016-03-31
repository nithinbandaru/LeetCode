package Matrix;

public class LC073_SetMatrixZeros {

	public static void main(String[] args) {

		
		int[][] matrix2 = { {1, 1, 1, 0},
							{1, 1, 1, 0},
							{1, 1, 0, 0},
							{1, 1, 1, 1}
						  };

		int[][] zeroMatrix = setZerosInPlace(matrix2);

		printMatrix(zeroMatrix);
		
	}

	private static void printMatrix(int[][] matrix)
	{
		
		for(int i = 0 ; i < matrix.length ; i++)
		{
			for(int j =0 ; j < matrix[0].length ; j++)
			{
				
				System.out.print(matrix[i][j]+ " ");
				
			}
			System.out.println();
		}
		
	}
	
	private static int[][] setZerosInPlace(int[][] matrix) {

		boolean firstRowZero = false;
		boolean firstColumnZero = false;
		
		// check first column for zeros
		for(int i = 0; i < matrix.length ; i++)
		{
			if(matrix[i][0] == 0)
			{
				firstColumnZero = true;
				break;
			}
		}
		
		// check first row for zeros
		for(int i = 0; i < matrix[0].length ; i++)
		{
			if(matrix[0][i] == 0)
			{
				firstRowZero = true;
				break;
			}
		}
		
		// mark first row and column where zeros are occuring
		
		for(int i = 1 ; i < matrix.length ; i++)
		{
			for(int j = 1; j < matrix[0].length ; j++)
			{
				if(matrix[i][j] == 0)
				{
					matrix[0][j] = 0 ;
					matrix[i][0] = 0;
					
				}
			}
		}
		
		// now set elements to zero based on markings
		
		for(int i = 1 ; i < matrix.length ; i++)
		{
			for(int j = 1; j < matrix[0].length ; j++)
			{
				if(matrix[0][j] == 0 || matrix[i][0] == 0)
				{
					matrix[i][j] = 0 ;
				}
			}
		}
		
		if(firstRowZero)
		{
			for(int i = 0 ; i< matrix[0].length ; i++)
			{
				matrix[0][i] = 0;
			}
		}
		
		if(firstColumnZero)
		{
			for(int i = 0 ; i< matrix.length ; i++)
			{
				matrix[i][0] = 0;
			}
		}
		
		return matrix;
	}

}
