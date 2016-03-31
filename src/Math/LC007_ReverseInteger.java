package Math;

public class LC007_ReverseInteger {

	// Time Complexity = O(Num of Digits in the number)
	
	public static void main(String[] args) {

		int num = -2147483648;
		
		int reverseNum = reverse(num);
		
		System.out.println(reverseNum);
	}

	private static int reverse(int num) {

		int flag = 1 ;
		
		int givenNum = num;
		
		// converting a negative number to positive number to check for overflow condition
		
		if(num < 0)
		{
			givenNum = -1 * num;
			flag = -1;
		}
		
		int reverseNum = 0;
		
		while(givenNum != 0)
		{
			// check overflow condition
			int overflowNum = Integer.MAX_VALUE / 10;
			System.out.println(overflowNum);
			System.out.println(reverseNum);
			if(reverseNum > overflowNum)
			{
				return 0;
			}
			
			int lastDigit = givenNum % 10;
			reverseNum = reverseNum * 10 + lastDigit;
			givenNum = givenNum / 10;
		}
		
		return (flag * reverseNum);
	}

}
