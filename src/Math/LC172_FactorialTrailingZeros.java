package Math;

public class LC172_FactorialTrailingZeros {

	public static void main(String[] args) {

		int num = 100; // 24
		
		int numZeros = getTrailingZeros(num);
		
		System.out.println(numZeros);
		
	}

	private static int getTrailingZeros(int num) {

		if(num <= 4 )
		{
			return 0;
		}
		
		int zeroCount = 0;
		
		while(num > 0)
		{
			zeroCount = zeroCount + num / 5;
			num = num/5;
		}
		
		return zeroCount;
	}

}
