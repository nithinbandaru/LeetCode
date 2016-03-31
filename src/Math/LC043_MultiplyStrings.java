package Math;

public class LC043_MultiplyStrings {

	public static void main(String[] args) {

		String num1 = "123";
		String num2 = "45";
		
		String result = multiply(num1, num2);
		System.out.println(result);		
		
	}

	private static String multiply(String num1, String num2) {

		if(num1.equals("0") || num2.equals("0"))
		{
			return "0";
		}
		
		int len1 = num1.length();
		int len2 = num2.length();
		
		int[] product = new int[len1 + len2];
		
		for(int i = len1-1 ; i >=0 ; i--)
		{
			for(int j = len2-1; j >=0 ; j--)
			{
				int digit1 = (int) (num1.charAt(i) - '0');
				int digit2 = (int) (num2.charAt(j) - '0');
				
				int mult = digit1 * digit2;
				int pos1 = i + j;
				int pos2 = i + j + 1;
				
				int sum = mult + product[pos2];
				
				product[pos1] = product[pos1] + sum / 10;
				product[pos2] = sum % 10;
			
			}
		}
		
		StringBuilder result = new StringBuilder();
	
		for(int i : product)
		{
			if(!(result.length() == 0 && i == 0))
			{
				result.append(i);
			}
		}
		
		return result.length() == 0 ? "0" : result.toString();
		
	}

}
