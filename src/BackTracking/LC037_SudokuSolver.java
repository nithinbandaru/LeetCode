package BackTracking;

public class LC037_SudokuSolver {

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
		
		SolveSudoku(sudoku);
		
		for(int i=0; i<9; i++)
		{
			for(int j=0; j<9; j++)
			{
				System.out.print(sudoku[i][j] + " ");
			}
			System.out.println();
		}
		
	}

	private static void SolveSudoku(char[][] sudoku) {

		if(sudoku == null || sudoku.length == 0)
		{
			return;
		}
		
		SolveSudokuUtil(sudoku);
		
	}

	private static boolean SolveSudokuUtil(char[][] sudoku) {

		for(int i = 0; i < sudoku.length; i++)
		{
			for(int j = 0; j < sudoku[0].length; j++)
			{
				
				if(sudoku[i][j] == '.')
				{
					for(char c = '1'; c <= '9' ; c++)
					{
						
						if(IsValid(sudoku, i, j, c))
						{
							sudoku[i][j] = c;
							
							if(SolveSudokuUtil(sudoku))
							{
								return true;
							}
							else
							{
								sudoku[i][j] = '.';
							}
							
						}
					}
					
					return false;
				}
			}
		}
		
		return true;
	}

	private static boolean IsValid(char[][] sudoku, int i, int j, char c) {

		// check row
		
		for(int col = 0; col < 9; col++)
		{
			if(sudoku[i][col] == c)
			{
				return false;
			}
		}
		
		// check row
		
		for(int row = 0; row < 9; row++)
		{
			if(sudoku[row][j] == c)
			{
				return false;
			}
		}
		
		
		// check 3 x 3 blocks
		
		for(int row = (i/3) * 3 ; row < (i/3) * 3 + 3 ; row++)
		{
			for(int col = (j/3) *3 ; col < (j/3) * 3 + 3; col++)
			{
				if(sudoku[row][col] == c)
				{
					return false;
				}
			}
		}
		
		return true;
	}

}
