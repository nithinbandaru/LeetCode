package BackTracking;

import java.util.LinkedList;
import java.util.List;

public class LC017_LetterCombinationPhoneNumber {

	public static void main(String[] args) {

		String phoneDigits = "23";
		
		List<String> letterCombinations = letterCombinationPhoneNumber(phoneDigits);
		
		System.out.println(letterCombinations);
	}

	private static List<String> letterCombinationPhoneNumber(String phoneDigits) {

		LinkedList<String> letterCombinations = new LinkedList<String>();
		
		if(phoneDigits == null || phoneDigits.length() == 0)
		{
			return letterCombinations;
		}
		
		letterCombinations.add("");
		
		String[] phoneMapping = {"0" , "1", "abc", "def", "ghi" , "jkl", "mno", "pqrs", "tuv","wxyz"};
		
		
		for(int i = 0 ; i < phoneDigits.length(); i++)
		{
			int digit = Character.getNumericValue(phoneDigits.charAt(i));
			
			while(letterCombinations.peek().length() == i)
			{
				String front = letterCombinations.remove();
				
				for(char ch : phoneMapping[digit].toCharArray())
				{
					letterCombinations.add(front + ch);
				}								
			}
		}
		
		return letterCombinations;
	}

}
