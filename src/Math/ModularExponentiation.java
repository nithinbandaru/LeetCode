package Math;

public class ModularExponentiation {

	public static void main(String[] args) {

		int num = 5;
		int pow = 3;
		int mod = 7;
		
		int rem = ModularExponentiationMethod(num, pow, mod);
				
		System.out.println(rem);
	}

	// Time complexity O(log n)
	
	private static int ModularExponentiationMethod(int num, int pow, int mod) {

		if(pow == 0)
		{
			return 1;
		}
		else if(num % 2 == 0)
		{
			int temp = ModularExponentiationMethod(num, pow/2, mod);
			return (temp * temp) % mod;
		}
				
		return ( ((num % mod) * ModularExponentiationMethod(num, pow-1, mod) ) % mod );
	}

}
