package Math;

public class LC009_SmallestPalindromeNumberGreaterThanGivenNumber {

	// Time Complexity = O(Number Of Digits)
	
	public static void main(String[] args) {
		
		int number = 125;
		
		boolean pal = IsPalindrome(number);
		
		int smallPal = smallestPalindrome(number);
		
		System.out.println(smallPal);
		
	}

	private static int smallestPalindrome(int number) {

		while(!IsPalindrome(number))
		{
			number++;
		}
		
		return number;
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
