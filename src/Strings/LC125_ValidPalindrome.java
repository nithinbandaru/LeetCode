package Strings;

public class LC125_ValidPalindrome {

	public static void main(String[] args) {

		String str = "A man, a plan, a canal: Panama";
		String str1  = "race a car";
		boolean palindrome = IsValidPalindrome(str);
		
		System.out.println("Palindrome : " + palindrome);
	}

	private static boolean IsValidPalindrome(String text) {

		if(text.isEmpty())
		{
			return true;
		}
		
		text = text.toLowerCase();
		int start = 0;
		int end = text.length() - 1;
		
		char head ;
		char tail;
		
		while(start <= end)
		{
			head = text.charAt(start);
			tail = text.charAt(end);
			System.out.println(head + " - " + tail);
			if(!Character.isLetterOrDigit(head))
			{
				start++;
			}
			else if(!Character.isLetterOrDigit(tail))
			{
				end--;
			}
			else
			{
				if(head != tail)
				{
					return false;
				}
				start++;
				end--;
			}
		}
		
		return true;
	}

}
