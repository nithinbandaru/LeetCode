package Math;

public class LC029_DivideTwoIntegers {

	public static void main(String[] args) {

		int dividend = 2147483647;
		
		int divisor = 3;
		
		int quotient = divide(dividend, divisor);
		
		System.out.println(quotient);
		
	}

	private static int divide(int dividend, int divisor) {

		if(dividend == Integer.MIN_VALUE)
		{
			if(divisor == 0)
			{
				return Integer.MAX_VALUE;
			}
			else if(divisor == 1)
			{
				return dividend;
			}
			
		}
		
		int quotient = 0;
		
		int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
		
		int dvd = Math.abs(dividend);
		int div = Math.abs(divisor);
		
		while(dvd >= div)
		{
			int temp = div;
			int multiply = 1;
			System.out.println(temp << 1);
			while(dvd >= (temp << 1))
			{
				temp = temp << 1;
				multiply = multiply << 1;
			}
			
			dvd = dvd - temp;
			quotient = quotient + multiply;
		}
		
		
		return sign == 1 ? quotient : -quotient;
	}

}
