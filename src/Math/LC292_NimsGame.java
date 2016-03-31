package Math;

public class LC292_NimsGame {

	/*
	You are playing the following Nim Game with your friend: 
	There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. 
	The one who removes the last stone will be the winner. 
	You will take the first turn to remove the stones.
	*/
	// https://leetcode.com/discuss/63725/theorem-all-4s-shall-be-false
	
	public static void main(String[] args) {

		int numOfStones = 7;
		
		boolean canWin = canWinNimsGame(numOfStones);
		System.out.println(canWin);		
	}

	private static boolean canWinNimsGame(int numOfStones) {
		
		return (numOfStones % 4 != 0 );
	}

}
