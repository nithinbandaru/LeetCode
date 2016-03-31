package Strings;

public class LC008_StringToInteger {

	// Time Complexity = O( String Length )
	
	
	public static void main(String[] args) {
		
		String text = "-2147483647";

		int num = atoi(text);
		
		System.out.println(num);
		
	}

	// Handle 5 cases
	
	private static int atoi(String text) {

		// 1. Is it empty or null string

		if(text == null || text.length() == 0)
		{
			return 0;
		}
		
		// 2. Trim all white spaces
		
		text = text.trim();
		
		// 3. Handle + and - sign
		
		char flag = '+';
		
		int i = 0 ;
		
		if(text.charAt(i)=='-')
		{
			flag = '-';
			i++;
		}
		else if (text.charAt(i)=='+')
		{
			i++;
		}
		
		long result = 0;
		
		// 4. Calculate value
		
		while(i < text.length() && text.charAt(i) >= '0' && text.charAt(i) <= '9')
		{
			result = result * 10 + (text.charAt(i) - '0');
			i++;
			
			// 5. Handle overflow situations
			
			if(result > Integer.MAX_VALUE && flag == '+')
			{
				return Integer.MAX_VALUE;
			}			
			else if(result > Integer.MAX_VALUE && flag == '-')
			{
				return Integer.MIN_VALUE;
			}
		
		}
		
		if(flag == '-')
		{
			result = -result;
		}
		
				
		
		return (int) result;
	}

}
