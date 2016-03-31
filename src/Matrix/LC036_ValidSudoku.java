package Matrix;

import java.util.HashSet;
import java.util.Set;

public class LC036_ValidSudoku {

	public static void main(String[] args) {

		char[][] sudoku = { {'5','3','.','.','7','.','.','.','.'},
							{'6','.','.','1','9','5','.','.','.'},
							{'.','9','8','.','.','.','.','6','.'},
							{'8','.','.','.','6','.','.','.','3'},
							{'4','.','.','8','.','3','.','.','1'},
							{'7','.','.','.','2','.','.','.','6'},
							{'.','6','.','.','.','.','2','8','.'},
							{'.','.','.','4','1','9','.','.','5'},
							{'.','.','.','.','8','.','.','7','9'},
		
						 };

		
		boolean valid = IsValidSudoku(sudoku);
		System.out.println(valid);
	}

	private static boolean IsValidSudoku(char[][] sudoku) {

		for(int i = 0; i < 9; i++)
		{
			// check all rows
			if(!IsValidSudokuUtil(sudoku, i, 0, i, 8))
			{
				return false;
			}
			// check all columns
			if(!IsValidSudokuUtil(sudoku, 0, i, 8, i))
			{
				return false;
			}
		}
		
		// check each 3 x 3 matrix now
		
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				if(!IsValidSudokuUtil(sudoku, i*3, j*3, i*3+2, j*3+2))
				{
					return false;
				}
			}
		}
		
		return true;
	}

	private static boolean IsValidSudokuUtil(char[][] sudoku, int x1, int y1, int x2, int y2) {

		Set<Character> set = new HashSet<Character>();
		
		for(int i = x1; i <= x2; i++)
		{
			for(int j = y1; j <= y2; j++)
			{
				char ch = sudoku[i][j];
				if( ch != '.')
				{
					if(set.contains(ch))
					{
						return false;
					}
					else
					{
						set.add(ch);
					}
				}				
			}
		}
		
		return true;
	}

}
