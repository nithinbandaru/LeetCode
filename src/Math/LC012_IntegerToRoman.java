package Math;

public class LC012_IntegerToRoman {

	public static void main(String[] args) {

		int num = 73;
		
		String roman = IntegerToRoman(num);
		System.out.println(roman);
		
		
	}

	private static String IntegerToRoman(int num) {

		int[] values = { 1000 , 900 , 500 , 400, 100, 90 , 50 , 40, 10 , 9 , 5 , 4 , 1} ;
		String[] romans = {"M" , "CM" , "D" , "CD", "C" , "XC" , "L" , "XL" , "X" , "IX" , "V" , "IV" , "I"};
		
		StringBuilder roman = new StringBuilder();
		
		for(int i = 0 ; i < values.length ; i++)
		{
			while(num >= values[i])
			{
				num = num - values[i];
				roman.append(romans[i]);
			}			
			
		}	
		
		return roman.toString();
	}

}
