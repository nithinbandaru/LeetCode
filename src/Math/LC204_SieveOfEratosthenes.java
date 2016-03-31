package Math;

public class LC204_SieveOfEratosthenes {

	public static void main(String[] args) {

		int num = 100;
		
		int count = countPrimes(num);
		System.out.println(count);
		
	}

	private static int countPrimes(int num) {

		int[] primes = new int[num+1];
		
		for(int i = 0 ; i<= num ;i++)
		{
			primes[i] = 1;
		}
		
		primes[0] = 0;
		primes[1] = 0;
		
		for(int i = 2 ; i <= Math.sqrt(num) ; i++)
		{			
			if(primes[i] == 1)
			{		
				for(int j = 2 ; i*j <= num ; j++)
				{
					primes[i*j] = 0;
				}
			}			
		}		
		
		int count = 0;
		
		for(int i = 2 ; i <= num ; i++)
		{
			if(primes[i]==1)
			{
				System.out.print(i + " ");
				count++;
			}
		}
		System.out.println();
		return count;
	}

}
