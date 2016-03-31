package Matrix;

import java.util.ArrayList;
import java.util.List;

public class PrintMatrixDiagonally {

	public static void main(String[] args) {

		int[][] matrix = { {1, 2, 3, 4, 5},
		   		   {6, 7, 8, 9, 10},
		           {11, 12, 13, 14, 15},
		           {16, 17, 18, 19, 20}
		 };

		List<List<Integer>> diagonal = printDiagonally(matrix);

		for(List<Integer> l : diagonal)
		{
			System.out.println(l);
		}
	}

	// Time complexity = O(rows*columns)
	
	private static List<List<Integer>> printDiagonally(int[][] matrix) {

		List<List<Integer>> diagonal = new ArrayList<List<Integer>>();
		
		int numRows = matrix.length;
		int numCols = matrix[0].length;
		
		int row, col;
		
		for(int k = 0 ; k < numRows; k++)
		{
			row = k;
			col = 0;
			
			List<Integer> list = new ArrayList<Integer>();
			
			while(row >=0 && col < numCols)
			{
				list.add(matrix[row][col]);
				row--;
				col++;
			}
			
			diagonal.add(list);
			
		}
		
		for(int k = 1 ; k < numCols; k++)
		{
			col = k;
			row = numRows-1;
			
			List<Integer> list = new ArrayList<Integer>();
			
			while(row >=0 && col < numCols)
			{
				list.add(matrix[row][col]);
				row--;
				col++;
			}
			
			diagonal.add(list);
			
		}
		
		return diagonal;
	}

}
