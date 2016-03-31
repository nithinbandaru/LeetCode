package Math;

public class LC009_PalindromeNumber {

	// Time Complexity = O(Number Of Digits)
	
	public static void main(String[] args) {
		
		int number = 2332;
		
		boolean pal = IsPalindrome(number);
		
		System.out.println(pal);
		
	}

	private static boolean IsPalindrome(int x) {

		if(x < 0)
		{
			return false;
		}
		
		int givenNum = x;
		int revNum = 0;
		
		// reverse till most significant digit
		while(givenNum >= 10)
		{
			revNum = revNum *10 + givenNum % 10;
			givenNum = givenNum / 10;			
		}
		
		// Handle overflow situation
		
		return (revNum == x / 10);
	}

}
