package Math;

import java.util.HashMap;

public class LC013_RomanToInteger {

	public static void main(String[] args) {

		
		String roman = "DCXLIX";
		
		int decimal = romanToInt(roman);
		
		System.out.println(decimal);
	}

	private static int romanToInt(String roman) {

		if(roman == null || roman.length() == 0)
		{
			return 0;
		}
		
		// Store mapping of roman numeral to decimal
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		
		int len = roman.length();
		
		int result = map.get(roman.charAt(len - 1));
		
		int nextRoman = result;
		
		for(int i = len -2 ; i >=0 ; i--)
		{
			int currRoman = map.get(roman.charAt(i));
			// check if current roman is greater than next roman
			if(currRoman >= nextRoman)
			{
				result = result + currRoman;
			}
			else				
			{
				result = result - currRoman;
			}	
			
			nextRoman = currRoman;
		}
		
		return result;
	}

}
