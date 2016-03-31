package Math;

public class LC065_ValidNumber {

	public static void main(String[] args) {

		String num = "1.2e33";
		
		boolean validNum = IsValidNumber(num);
		System.out.println(validNum);
		
	}

	private static boolean IsValidNumber(String num) {

		num = num.trim();
		
		boolean dotSeen = false; // seen .(decimal)
		boolean eSeen = false; // seen Exponential symbol (E)
		boolean numberSeen = false; // seen any number
		boolean numberAfterE = true; // seen any number after E as in e5
		
		for(int i = 0; i < num.length(); i++)
		{
			char ch = num.charAt(i);
			if(ch >= '0' && ch <= '9')
			{
				numberSeen = true;
				numberAfterE = true;
			}
			else if(ch == '.')
			{
				// We can only see . if we didn't see e or .
				if(eSeen || dotSeen)
				{
					return false;
				}
				dotSeen = true;
			}
			else if(ch == 'e')
			{
				// We can only see e if we didn't see e but we did see a number
				if(eSeen || !numberSeen)
				{
					return false;
				}
				eSeen = true;
				numberAfterE = false;
			}
			else if(ch == '+' || ch == '-')
			{
				// We can only see + and - in the beginning and after an e
				if(i != 0 || num.charAt(i-1) != 'e')
				{
					return false;
				}
			}
			else
			{
				// Any other character breaks the validation
				return false;
			}
		}
		
		// At the end it is only valid if there was at least 1 number 
		// and if we did see an e then a number after it as well
		
		return numberSeen && numberAfterE;
	}

}
