package Matrix;

import java.util.ArrayList;
import java.util.List;

public class LC054_SpiralMatrixTraversal {

	public static void main(String[] args) {

		int[][] matrix = { {1,2,3},
						   {8,9,4},
						   {7,6,5}
				 		 };
		
		List<Integer> spiral = spiralMatrixTraversal(matrix); 
		
		for(int i : spiral)
		{
			System.out.print(i +" ");
		}
	}

	private static List<Integer> spiralMatrixTraversal(int[][] matrix) {

		List<Integer> result = new ArrayList<Integer>();
		
		if(matrix.length == 0)
		{
			return result;
		}
		
		int rowBegin = 0;
		int rowEnd = matrix.length-1;
		
		int colBegin = 0;
		int colEnd = matrix[0].length-1;
		
		while(rowBegin <= rowEnd && colBegin <= colEnd)
		{
			// Traverse Right
			
			for(int i = colBegin ; i <= colEnd ; i++)
			{
				result.add(matrix[rowBegin][i]);
			}
			rowBegin++;
			
			// Traverse Down
			
			for(int i = rowBegin ; i <= rowEnd ; i++)
			{
				result.add(matrix[i][colEnd]);
			}
			colEnd--;
			
			// Traverse Left
			
			if(rowBegin <= rowEnd)
			{
				for(int i = colEnd ; i >= colBegin ; i--)
				{
					result.add(matrix[rowEnd][i]);
				}
			}
			rowEnd--;
			
			// Traverse Up
			
			if(colBegin <= colEnd)
			{
				for(int i = rowEnd ; i>= rowBegin ; i--)
				{
					result.add(matrix[i][colBegin]);
				}
			}
			
			colBegin++;			
		}
		
		return result;
	}

}
