package Math;

import java.util.HashMap;

public class LC166_FractionToRecurringDecimal {

	public static void main(String[] args) {

		int numerator = 10 ;
		
		int denominator = 4;
		
		String fraction = convertToFractionDecimal(numerator, denominator);
		System.out.println(fraction);
		
	}

	private static String convertToFractionDecimal(int numerator, int denominator) {
		
		if(numerator == 0)
		{
			return "0";
		}
		
		StringBuilder fraction = new StringBuilder();
		
		// 1. Find the sign
		
		String sign = ( (numerator > 0) ^ (denominator > 0) ? "-" : "");
		fraction.append(sign);
		
		// 2. Integral part

		long num = Math.abs((long) numerator);
		long den = Math.abs((long) denominator);
		
		fraction.append(num/den);
		
		// 3. fraction part
		
		long remainder = num % den;
		
		if(remainder == 0)
		{
			return fraction.toString();
		}
		
		fraction.append(".");
		
		HashMap<Long, Integer> map = new HashMap<Long, Integer>();
		
		while(!map.containsKey(remainder))
		{
			map.put(remainder, fraction.length());
			fraction.append((10 * remainder) / den);
			remainder = ( 10 * remainder ) % den;
		}
		
		int index = map.get(remainder);
		fraction.insert(index, "(");
		fraction.append(")");		
		
		return fraction.toString().replace("(0)", "");
	}

}
