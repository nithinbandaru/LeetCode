package Strings;

public class LC067_AddBinaryStrings {

	public static void main(String[] args) {
		

		String s1 = "11";
		String s2 = "1";
		
		String sum = binarySum(s1, s2);
		
		System.out.println(sum);
		
	}

	private static String binarySum(String s1, String s2) {
		
		int i = s1.length()-1;
		int j = s2.length()-1;

		StringBuilder result = new StringBuilder();
		
		int carry = 0;
		
		while(i>=0 || j>=0)
		{
			int sum = carry;
			
			if(i>=0)
			{
				sum = sum + s1.charAt(i--)-'0';
			}
			if(j>=0)
			{
				sum = sum + s2.charAt(j--)-'0';
			}
			result.append(sum%2);
			carry = sum / 2;			
		}
		
		if(carry != 0)
		{
			result.append(carry);
		}
		
		return result.reverse().toString();
	}

}
