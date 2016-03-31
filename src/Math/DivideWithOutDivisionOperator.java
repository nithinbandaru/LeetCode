package Math;

public class DivideWithOutDivisionOperator {

	public static void main(String[] args) {

		int dividend = -19;
		
		int divisor = -4;
		
		int quotient = divide(dividend, divisor);
		System.out.println("Quotient: " + quotient);
		//int remainder = Modulus(dividend, divisor);
		
		//System.out.println("Quotient: " + quotient + " Remainder: " + remainder);
	}

	private static int Modulus(int dividend, int divisor) {

		while(dividend >= divisor)
		{
			dividend = dividend -  divisor;
		}
		
		return dividend;
	}

	private static int divide(int dividend, int divisor) {

		int quotient = 0;
		
		int sign = -1;;
		
		if( (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0) )
		{
			sign = 1;
		}
		
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		while(dividend >= divisor)
		{
			dividend = dividend - divisor;
			quotient++;
		}		
		
		return (sign * quotient);
	}

}
