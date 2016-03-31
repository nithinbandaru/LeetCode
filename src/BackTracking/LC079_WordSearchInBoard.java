package BackTracking;

public class LC079_WordSearchInBoard {

	static int[] x = { 0, 1, 0, -1,};
	static int[] y = { 1, 0, -1, 0, };
	// right, down, left, top - 4 directions in x-y plane read as
	// (0,-1) (-1,0) (0,1) (1,0)
	
	static boolean[][] visited; 
	
	public static void main(String[] args) {

		
		char[][] board = { {'A','B','C','E'},
				           {'S','F','C','S'},
				           {'A','D','E','E'}
						 };
		
		String word = "ABCCED";
		
		
		boolean found = patternSearch(board, word);
		System.out.println("word found: " + found);
		
	}

	private static boolean patternSearch(char[][] board, String word) {

		// 1. board validation
		if(board == null || word == null)
		{
			return false;
		}
			
		int numRows = board.length;
		int numCols = board[0].length;
		int wordLen = word.length();
		
		visited = new boolean[numRows][numCols];
		
		if(numRows == 0 || numCols == 0 || wordLen == 0)
		{
			return false;
		}
		
		
		// 2. consider every point as starting point and search the given word
		
		for(int row = 0 ; row < numRows; row++)
		{
			for(int col = 0 ; col < numCols; col++)
			{
				// 1. If first character of word match its the starting point
				if(word.charAt(0) == board[row][col] && searchBoard(board, word , row , col, 0))
				{
					return true;
				}
			}
		}
		
		return false;
	}

	// search in all 4 directions
	
	private static boolean searchBoard(char[][] board, String word, int row, int col, int index) {

		if(index == word.length())
		{
			return true;
		}
		
		
		// boundary conditions
		if( row < 0 || row >= board.length || col < 0 || col >= board[0].length)
		{
			return false;
		}
		System.out.println(board[row][col]);
		// if character doesnt match or already visited
		if(board[row][col] != word.charAt(index) || visited[row][col])
		{
			return false;
		}
		
		visited[row][col] = true;
		// search right, down, left , up
		if(	searchBoard(board, word, row, col + 1, index+1) ||
			searchBoard(board, word, row + 1, col, index+1) ||
			searchBoard(board, word, row, col - 1, index+1) ||
			searchBoard(board, word, row - 1, col, index+1)
		  )
		{
			return true;
		}
		
		visited[row][col] = false;
		
		return false;
	}

}
