package Math;

public class LC258_RepeatedlyAddDigits {

	public static void main(String[] args) {

		int num = 123;
		
		int digit = repeatedlyAdd(num);
		System.out.println(digit);
		
	}

	private static int repeatedlyAdd(int num) {

		if(num == 0)
		{
			return 0;
		}
		
		if(num % 9 == 0 )
		{
			return 9;
		}
				
		return num % 9;
	}

}
