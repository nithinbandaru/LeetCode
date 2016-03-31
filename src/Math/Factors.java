package Math;

import java.util.ArrayList;
import java.util.List;

public class Factors {

	public static void main(String[] args) {

		int num =12;
		
		List<Integer> factors = getFactors(num);
		System.out.println(factors);
		
	}

	private static List<Integer> getFactors(int num) {

		List<Integer> factors = new ArrayList<Integer>();
		
		for(int i = 1; i < Math.sqrt(num); i++)
		{
			if(num % i == 0)
			{
				factors.add(i);
				
				if(i != Math.sqrt(num))
				{
					factors.add(num/i);
				}				
			}
		}
		
		return factors;
	}

}
