package Matrix;

public class LC059_GenerateSpiralMatrix {

	public static void main(String[] args) {

		int num = 3;
		
		int[][] spiralMatrix = generateSpiralMatrix(num);
		
		for(int i =0 ;i < spiralMatrix.length ; i++)
		{
			for(int j = 0 ; j < spiralMatrix[0].length ; j++)
			{
				System.out.print(spiralMatrix[i][j] +" ");
			}
			System.out.println();
		}
	}

	private static int[][] generateSpiralMatrix(int num) {

		int[][] matrix = new int[num][num];
		
		if(num == 0)
		{
			return matrix;
		}
		
		int rowBegin = 0;
		int rowEnd = matrix.length-1;
		
		int colBegin = 0;
		int colEnd = matrix[0].length-1;
		
		int count = 1;
		
		while(rowBegin <= rowEnd && colBegin <= colEnd)
		{
			// Traverse Right
			
			for(int i = colBegin ; i <= colEnd ; i++)
			{
				matrix[rowBegin][i] = count;
				count++;
			}
			rowBegin++;
			
			// Traverse Down
			
			for(int i = rowBegin ; i <= rowEnd ; i++)
			{
				matrix[i][colEnd] = count;
				count++;
			}
			colEnd--;
			
			// Traverse Left
			
			if(rowBegin <= rowEnd)
			{
				for(int i = colEnd ; i >= colBegin ; i--)
				{
					matrix[rowEnd][i] = count;
					count++;
				}
			}
			rowEnd--;
			
			// Traverse Up
			
			if(colBegin <= colEnd)
			{
				for(int i = rowEnd ; i>= rowBegin ; i--)
				{
					matrix[i][colBegin] = count;
					count++;
				}
			}
			
			colBegin++;			
		}
		
		return matrix;
	}

}
