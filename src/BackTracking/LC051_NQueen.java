package BackTracking;

public class LC051_NQueen {

	public static void main(String[] args) {

		
		int boardSize = 4;
		
		boolean solve = solveBoard(boardSize);
		System.out.println(solve);
	}

	private static boolean solveBoard(int N) {

		int[][] board = new int[N][N];
		// place 1st queen at 0th column and start iteration
		if(!solveUtil(board, 0))
		{
			return false;
		}
		
		printBoard(board);		
		
		return true;
	}

	private static void printBoard(int[][] board) {

		for(int i = 0 ; i < board.length; i++)
		{
			for(int j =0; j < board.length; j++)
			{
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		
		
	}

	private static boolean solveUtil(int[][] board, int colNum) {

		// If all queens are placed then return true
		
		if(colNum >= board.length)
		{
			return true;
		}
		
		// consider this column and try to place queens in the other columns  one by one
		// Iterate thru all columns 0 to N-1
		for(int i = 0 ; i < board.length; i++)
		{
			if(canQueenBePlacedHere(board,i,colNum))
			{
				// if queen can be placed, place
				board[i][colNum] = 1;
				
				// solve for next queen placement
				
				if(solveUtil(board, colNum+1))
				{
					return true;
				}
				
				// if it doesnt yeild a solution , remove queen from that position and back track
				
				board[i][colNum] = 0;
			}
			
		}
		
		// If queen cannot be placed in any rows in this columns return false
		return false;
	}

	private static boolean canQueenBePlacedHere(int[][] board, int row, int col) {

		int i, j;
		
		// check for attacking queen on left side

		for(i = 0; i < col; i++)
		{
			if(board[row][i]==1)
			{
				return false;
			}
		}
		
		// check upper diagonals for attacking queens
		
		for(i = row, j = col; i >=0 && j >=0 ; i--, j--)
		{
			if(board[i][j] == 1)
			{
				return false;
			}
		}
		
		// check lower diagonals for attacking queens
		
		for(i = row, j = col; i < board.length && j >=0 ; i++, j--)
		{
			if(board[i][j] == 1)
			{
				return false;
			}
		}
		
		return true;
	}

}
